package com.vhs.bts.controllers;

import com.vhs.bts.dto.AddressStockDto;
import com.vhs.bts.dto.AddressStockDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.AddressStockService;
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
@RequestMapping("/api/address")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AddressStockController {

    private final DtoConverter dtoConverter;
    private final AddressStockService addressStockService;

    @GetMapping
    public List<AddressStockDto> getAllAddressStocks() {
        return dtoConverter.simpleConvert(addressStockService.getAllAddresses(), AddressStockDto.class);
    }

    @PostMapping
    public AddressStockDto createAddressStock(@RequestBody AddressStockDtoIn addressStockDto) {
        return dtoConverter.simpleConvert(addressStockService.createAddressStock(addressStockDto), AddressStockDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressStockById(@PathVariable Long id) {
        addressStockService.deleteAddressStockById(id);
    }

    @GetMapping("/{id}")
    public AddressStockDto getAddressStockById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(addressStockService.getAddressStockById(id), AddressStockDto.class);
    }

    @PutMapping("/{id}")
    public AddressStockDto changeAddressStockById(@PathVariable Long id, @RequestBody AddressStockDtoIn addressStockDto) {
        return dtoConverter.simpleConvert(addressStockService.changeAddressStockById(id, addressStockDto), AddressStockDto.class);
    }

}
