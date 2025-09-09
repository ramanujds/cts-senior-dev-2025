package com.cts.portfolioservice.service;

import com.cts.portfolioservice.model.Portfolio;
import com.cts.portfolioservice.model.Stock;
import com.cts.portfolioservice.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {


    private final PortfolioRepository portfolioRepo;

    public PortfolioService(PortfolioRepository portfolioRepo) {
        this.portfolioRepo = portfolioRepo;
    }


    public Portfolio retrievePortfolio(String username) {
        return portfolioRepo.findByUsername(username);
    }

    public Portfolio addStockToPortfolio(String name, int quantity) {
        // Fetch stocks from  stock service

        return null;
    }

    public Portfolio createPortfolio(Portfolio portfolio){
        return portfolioRepo.save(portfolio);
    }







}
