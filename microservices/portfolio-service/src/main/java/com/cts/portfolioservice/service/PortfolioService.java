package com.cts.portfolioservice.service;

import com.cts.portfolioservice.client.StockServiceFeignClient;
import com.cts.portfolioservice.dto.StockDto;
import com.cts.portfolioservice.model.Portfolio;
import com.cts.portfolioservice.model.Stock;
import com.cts.portfolioservice.repository.PortfolioRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextAware;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PortfolioService {
    @Value("${kafka.topic}")
    private String topic;

    private final StockServiceFeignClient stockServiceFeignClient;
    private final KafkaTemplate<String,String> kafkaTemplate;
    private String baseUrl = "http://stocks-service/stocks/api/v1";



    private final PortfolioRepository portfolioRepo;
    private final RestTemplate restTemplate;



    public PortfolioService(PortfolioRepository portfolioRepo, RestTemplate restTemplate, StockServiceFeignClient stockServiceFeignClient, KafkaTemplate<String,String> kafkaTemplate) {
        this.portfolioRepo = portfolioRepo;
        this.restTemplate = restTemplate;
        this.stockServiceFeignClient = stockServiceFeignClient;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Retry(name = "stock-service")
    public Portfolio retrievePortfolio(String username) {
        Portfolio portfolio = portfolioRepo.findByUsername(username);
        log.info(portfolio.toString());
        List<Stock> stocksInPortfolio = portfolio.getStocks();
        double totalInvested = stocksInPortfolio.stream().mapToDouble(stock -> stock.getBuyingPrice() * stock.getQuantity()).sum();
        portfolio.setTotalInvested(totalInvested);


       var currentStockWithPrices = fetchStockPricesInBulk(stocksInPortfolio);

       double currentValue = 0.0;
         if(currentStockWithPrices != null){
                for(Stock stock : stocksInPortfolio){
                    for(StockDto stockDto : currentStockWithPrices){
                        if(stock.getName().equalsIgnoreCase(stockDto.name())){
                            currentValue += stockDto.price() * stock.getQuantity();
                        }
                    }
                }
         }
        portfolio.setCurrentValue(currentValue);
        portfolio.setProfit(currentValue - totalInvested);
        return portfolio;


    }


    private List<StockDto> fetchStockPricesInBulk(List<Stock> stocks){
        return stockServiceFeignClient.fetchStocksWithCurrentPrices(stocks);
    }




    public Portfolio addStockToPortfolio(String name, int quantity, String username) {
        // Fetch stocks from  stock service

        StockDto stock = restTemplate.getForObject(baseUrl+"/"+name,StockDto.class);
        Portfolio portfolio = portfolioRepo.findByUsername(username);
        log.info(portfolio.toString());
        Stock newStock = new Stock();
        newStock.setName(stock.name());
        newStock.setQuantity(quantity);
        newStock.setBuyingPrice(stock.price());
        log.info(stock.toString());
        portfolio.getStocks().add(newStock);
        var upadtedPortfolio = portfolioRepo.save(portfolio);
//        try {
//            kafkaTemplate.send(topic,newStock.toString());
//        } catch (Exception e) {
//            log.error("Error sending message to Kafka: {}", e.getMessage());
//        }

        return upadtedPortfolio;

    }

    public Portfolio createPortfolio(Portfolio portfolio){
        return portfolioRepo.save(portfolio);
    }







}
