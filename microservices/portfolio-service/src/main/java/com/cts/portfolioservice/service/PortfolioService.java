package com.cts.portfolioservice.service;

import com.cts.portfolioservice.dto.StockDto;
import com.cts.portfolioservice.model.Portfolio;
import com.cts.portfolioservice.model.Stock;
import com.cts.portfolioservice.repository.PortfolioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Portfolio addStockToPortfolio(String name, int quantity) {
        // Fetch stocks from  stock service

        StockDto stock = restTemplate.getForObject("http://localhost:8100/stocks/api/v1/"+name,StockDto.class);
        System.out.println(stock);

        return null;
    }

    public Portfolio createPortfolio(Portfolio portfolio){
        return portfolioRepo.save(portfolio);
    }







}
