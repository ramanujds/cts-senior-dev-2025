package com.cts.portfolioservice.client;

import com.cts.portfolioservice.dto.StockDto;
import com.cts.portfolioservice.model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "stock-service")
public interface StockServiceFeignClient {

    @PostMapping("/stocks/api/v1/bulk")
    List<StockDto> fetchStocksWithCurrentPrices(List<Stock> stocks);

}
