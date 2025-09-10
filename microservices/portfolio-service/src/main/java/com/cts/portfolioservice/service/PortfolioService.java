package com.cts.portfolioservice.service;

import com.cts.portfolioservice.dto.StockDto;
import com.cts.portfolioservice.model.Portfolio;
import com.cts.portfolioservice.model.Stock;
import com.cts.portfolioservice.repository.PortfolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PortfolioService {



    private final PortfolioRepository portfolioRepo;
    private final RestTemplate restTemplate;

    public PortfolioService(PortfolioRepository portfolioRepo, RestTemplate restTemplate) {
        this.portfolioRepo = portfolioRepo;
        this.restTemplate = restTemplate;
    }


    public Portfolio retrievePortfolio(String username) {
        return portfolioRepo.findByUsername(username);
    }

    public Portfolio addStockToPortfolio(String name, int quantity, String username) {
        // Fetch stocks from  stock service

        StockDto stock = restTemplate.getForObject("http://localhost:8100/stocks/api/v1/"+name,StockDto.class);
        Portfolio portfolio = portfolioRepo.findByUsername(username);
        log.info(portfolio.toString());
        Stock newStock = new Stock();
        newStock.setName(stock.name());
        newStock.setQuantity(quantity);
        newStock.setBuyingPrice(stock.price());
        log.info(stock.toString());
        portfolio.getStocks().add(newStock);
        return portfolioRepo.save(portfolio);

    }

    public Portfolio createPortfolio(Portfolio portfolio){
        return portfolioRepo.save(portfolio);
    }







}
