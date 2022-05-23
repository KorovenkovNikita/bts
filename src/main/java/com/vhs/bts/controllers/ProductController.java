package com.vhs.bts.controllers;

import com.vhs.bts.dto.ProductDto;
import com.vhs.bts.dto.ProductDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.ProductService;
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
@RequestMapping("/api/products")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductController {

    private final ProductService productService;
    private final DtoConverter dtoConverter;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return dtoConverter.simpleConvert(productService.getAllProducts(), ProductDto.class);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDtoIn laptopProductDto) {
        return dtoConverter.simpleConvert(productService.createProduct(laptopProductDto), ProductDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(productService.getProductById(id), ProductDto.class);
    }

    @PutMapping("/{id}")
    public ProductDto changeProductById(@PathVariable Long id, @RequestBody ProductDtoIn productDto) {
       return dtoConverter.simpleConvert(productService.changeProductById(id, productDto), ProductDto.class);
    }
}
