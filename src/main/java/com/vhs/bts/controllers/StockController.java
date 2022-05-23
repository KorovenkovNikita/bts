package com.vhs.bts.controllers;

import com.vhs.bts.dto.StockDto;
import com.vhs.bts.dto.StockDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.StockService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StockController {

    private final StockService stockService;
    private final DtoConverter dtoConverter;

    @GetMapping
    public List<StockDto> getAllStocks() {
        return dtoConverter.simpleConvert(stockService.getAllStocks(), StockDto.class);
    }

    @PostMapping
    public StockDto createStock(@RequestBody StockDtoIn stockDto) {
        return dtoConverter.simpleConvert(stockService.createStock(stockDto), StockDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteStockById(@PathVariable Long id) {
        stockService.deleteStockById(id);
    }

    @GetMapping("/{id}")
    public StockDto getStockById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(stockService.getStockById(id), StockDto.class);
    }

    @PutMapping("/{id}")
    public StockDto changeStockById(@PathVariable Long id, @RequestBody StockDtoIn stockDto) {
        return dtoConverter.simpleConvert(stockService.changeStockById(id, stockDto), StockDto.class);
    }
}
