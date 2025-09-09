package com.cts.stockservice.api;

import com.cts.stockservice.model.Stock;
import com.cts.stockservice.repository.StocksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class SocksController {


    private final StocksRepository stocksRepository;

    public SocksController(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }

    // api to fetch individual stocks by name
    @GetMapping("/api/v1/{name}")
    public Stock findStock(@PathVariable String name){
        return stocksRepository.findByNameIgnoreCase(name).get();
    }

    @GetMapping("/api/v1")
    public List<Stock> getAllStocks(){
        return stocksRepository.findAll();
    }

    @PostMapping("/api/v1")
    public Stock addStock(@RequestBody Stock stock){
        return stocksRepository.save(stock);
    }


}
