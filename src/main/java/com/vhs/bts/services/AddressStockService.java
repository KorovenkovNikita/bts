package com.vhs.bts.services;

import com.vhs.bts.dto.AddressStockDtoIn;
import com.vhs.bts.entities.AddressStockEntity;
import com.vhs.bts.repositories.AddressStockRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AddressStockService {

    private final AddressStockRepository addressStockRepository;

    public List<AddressStockEntity> getAllAddresses() {
        return addressStockRepository.findAll();
    }

    public void deleteAddressStockById(Long id) {
        addressStockRepository.deleteById(id);
    }

    public AddressStockEntity createAddressStock(AddressStockDtoIn addressStockDtoIn) {
        return addressStockRepository.save(new AddressStockEntity(addressStockDtoIn));
    }

    public AddressStockEntity getAddressStockById(Long id) {
        return addressStockRepository.getById(id);
    }

    public AddressStockEntity changeAddressStockById(Long id, AddressStockDtoIn addressStockDto) {
        AddressStockEntity addressStock = getAddressStockById(id);
        addressStock.setCity(addressStockDto.getCity());
        addressStock.setAddress(addressStockDto.getAddress());
        return addressStockRepository.save(addressStock);
    }
}
