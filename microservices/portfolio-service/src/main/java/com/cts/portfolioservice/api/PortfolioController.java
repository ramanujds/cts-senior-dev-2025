package com.cts.portfolioservice.api;

import com.cts.portfolioservice.model.Portfolio;
import com.cts.portfolioservice.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {


    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // api to fetch the portfolio details
    @GetMapping("/api/v1/{username}")
    public Portfolio getPortfolio(@PathVariable String username){
        return portfolioService.retrievePortfolio(username);
    }

    @PostMapping("/api/v1")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio){
        return portfolioService.createPortfolio(portfolio);
    }

    // api to fetch individual stocks in the portfolio

}
