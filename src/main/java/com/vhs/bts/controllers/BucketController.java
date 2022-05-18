package com.vhs.bts.controllers;

import com.vhs.bts.dto.BucketDto;
import com.vhs.bts.dto.BucketDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.BucketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bucket")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BucketController {

    private final DtoConverter dtoConverter;
    private final BucketService bucketService;

    @GetMapping
    public List<BucketDto> getBuckets() {
        return dtoConverter.simpleConvert(bucketService.getBuckets(), BucketDto.class);
    }

    @PutMapping("/{id}")
    public BucketDto addLaptopsToBucket(@PathVariable Long id, @RequestBody BucketDtoIn bucketDto) {
        return dtoConverter.simpleConvert(bucketService.changeLaptopsInTheBucketById(id, bucketDto), BucketDto.class);
    }

    @GetMapping("/{id}")
    public BucketDto getBucketById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(bucketService.getBucketById(id), BucketDto.class);
    }
}
