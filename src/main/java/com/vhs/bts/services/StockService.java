package com.vhs.bts.services;

import com.vhs.bts.dto.StockDtoIn;
import com.vhs.bts.entities.StockEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.StockRepository;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StockService {

    private final StockRepository stockRepository;
    private final AddressStockService addressStockService;

    public List<StockEntity> getAllStocks() {
        return stockRepository.findAll();
    }

    public StockEntity createStock(StockDtoIn stockDto) {
        StockEntity stock = new StockEntity();
        setUpStock(stockDto, stock);
        return stockRepository.save(stock);
    }

    public void deleteStockById(Long id) {
        stockRepository.deleteById(id);
    }

    public StockEntity getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find stock with id = " + id));
    }

    public StockEntity changeStockById(Long id, StockDtoIn stockDto) {
        StockEntity stock = getStockById(id);
        setUpStock(stockDto, stock);
        return stockRepository.save(stock);
    }

    private void setUpStock(StockDtoIn stockDto, StockEntity stock) {
        try {
            stock.setTimeOpen(LocalTime.parse(stockDto.getTimeOpen()));
            stock.setTimeClose(LocalTime.parse(stockDto.getTimeClose()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        stock.setAddress(addressStockService.getAddressStockById(stockDto.getAddressId()));
        stock.setTitle(stockDto.getTitle());
    }
}
