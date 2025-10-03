package com.cts.stockservice.api;

import com.cts.stockservice.dto.StockNameRequestDto;
import com.cts.stockservice.dto.StockResponseDto;
import com.cts.stockservice.model.Stock;
import com.cts.stockservice.repository.StocksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins = {"http://localhost:5173"})
public class SocksController {


    private final StocksRepository stocksRepository;

    public SocksController(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }

    // api to fetch individual stocks by name
    @GetMapping("/api/v1/{name}")
    public Stock findStock(@PathVariable String name) {
        return stocksRepository.findByNameIgnoreCase(name).get();
    }

    @GetMapping("/api/v1")
    public List<Stock> getAllStocks() {
        return stocksRepository.findAll();
    }

    @PostMapping("/api/v1")
    public Stock addStock(@RequestBody Stock stock) {
        return stocksRepository.save(stock);
    }


    @PostMapping("/api/v1/bulk")
    public List<StockResponseDto> fetchBulkStocks(@RequestBody List<StockNameRequestDto> stockNames) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        if(!stockNames.isEmpty()){
//            throw new RuntimeException();
//        }
        return stocksRepository.findByNameInIgnoreCase(
                stockNames.stream().map(StockNameRequestDto::name).toList()
        ).stream().map(stock -> new StockResponseDto(stock.getName(), stock.getPrice())).toList();
    }

    @PatchMapping
    public Stock updateStockPrice(@RequestParam String name, @RequestParam double price){
        var stockOpt = stocksRepository.findByNameIgnoreCase(name);
        if(stockOpt.isPresent()){
            var stock = stockOpt.get();
            stock.setPrice(price);
            return stocksRepository.save(stock);
        }
        return null;
    }


}
