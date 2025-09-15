package com.cts.portfolioservice.api;

import com.cts.portfolioservice.dto.PortfolioStockRequestDto;
import com.cts.portfolioservice.model.Portfolio;
import com.cts.portfolioservice.service.PortfolioService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/portfolio")
public class PortfolioController {


    private final PortfolioService portfolioService;


    @PostConstruct
    public void init(){
        log.warn("PortfolioController instance created");
    }

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

    @PutMapping("/api/v1")
    public Portfolio addStock(@RequestBody PortfolioStockRequestDto dto){
        return portfolioService.addStockToPortfolio(dto.stockName(),dto.quantity(),dto.username());
    }

    // api to fetch individual stocks in the portfolio

}
