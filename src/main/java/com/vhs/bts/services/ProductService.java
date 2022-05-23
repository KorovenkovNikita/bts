package com.vhs.bts.services;

import com.vhs.bts.dto.ProductDtoIn;
import com.vhs.bts.entities.ProductEntity;
import com.vhs.bts.entities.StockEntity;
import com.vhs.bts.repositories.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductService {

    private final ProductRepository productRepository;
    private final LaptopService laptopService;
    private final StockService stockService;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity createProduct(ProductDtoIn laptopProductDto) {
        return productRepository.save(
            new ProductEntity(laptopService.getLaptopById(laptopProductDto.getLaptopId()),
                stockService.getStockById(laptopProductDto.getStockId())));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductEntity getProductById(Long id) {
        return productRepository.getById(id);
    }

    public ProductEntity changeProductById(Long id, ProductDtoIn productDto) {
        ProductEntity product = getProductById(id);
        StockEntity stock = stockService.getStockById(productDto.getStockId());
        product.setLaptop(laptopService.getLaptopById(productDto.getLaptopId()));
        product.setStock(stock);
        return productRepository.save(product);
    }

}
