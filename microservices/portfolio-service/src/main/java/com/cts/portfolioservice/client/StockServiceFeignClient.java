package com.cts.portfolioservice.client;

import com.cts.portfolioservice.dto.StockDto;
import com.cts.portfolioservice.model.Stock;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "stock-service")
public interface StockServiceFeignClient {

    Logger log = LoggerFactory.getLogger(StockServiceFeignClient.class);

    @PostMapping("/stocks/api/v1/bulk")
    @CircuitBreaker(name = "stock-service", fallbackMethod = "fetchStocksWithCurrentPricesFallback")
    List<StockDto> fetchStocksWithCurrentPrices(List<Stock> stocks);

    default List<StockDto> fetchStocksWithCurrentPricesFallback(List<Stock> stocks, Exception ex){
        log.warn("Fallback method called");
        log.error(ex.getMessage());
        return List.of();
    }

}
