package com.cts.portfolioservice.client;

import com.cts.portfolioservice.config.FeignConfigWithInterceptor;
import com.cts.portfolioservice.dto.StockDto;
import com.cts.portfolioservice.model.Stock;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "stocks-service", url = "http://stocks-service/stocks/api/v1",configuration = FeignConfigWithInterceptor.class)
public interface StockServiceFeignClient {

    Logger log = LoggerFactory.getLogger(StockServiceFeignClient.class);

    @PostMapping("/bulk")
    @CircuitBreaker(name = "stock-service", fallbackMethod = "fetchStocksWithCurrentPricesFallback")
    @RateLimiter(name = "stock-service", fallbackMethod = "fetchStocksWithCurrentPricesRateLimiterFallback")
    @Retry(name = "stock-service")
    @Bulkhead(name = "stock-service", fallbackMethod = "fetchStocksWithCurrentPricesBulkheadFallback")
    List<StockDto> fetchStocksWithCurrentPrices(List<Stock> stocks);


    default List<StockDto> fetchStocksWithCurrentPricesFallback(List<Stock> stocks, Exception ex){
        log.warn("Fallback method called");
        log.error(ex.getMessage());
        return List.of();
    }

    default List<StockDto> fetchStocksWithCurrentPricesRateLimiterFallback(List<Stock> stocks, RequestNotPermitted ex){
        log.warn("Rate limit exceeded");
        log.error(ex.getMessage());
        return List.of();
    }

    default List<StockDto> fetchStocksWithCurrentPricesBulkheadFallback(List<Stock> stocks, RequestNotPermitted ex){
        log.warn("Bulkhead exceeded");
        log.error(ex.getMessage());
        return List.of();
    }



}
