package com.vhs.bts.controllers;

import com.vhs.bts.dto.BucketDto;
import com.vhs.bts.dto.BucketDtoIn;
import com.vhs.bts.services.BucketService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bucket")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BucketController {

    private final BucketService bucketService;

    @GetMapping
    public List<BucketDto> getBucket() {
        return bucketService.getBuckets().stream().map(BucketDto::new).collect(Collectors.toList());
    }
    @PostMapping
    public BucketDto createBucket(@RequestBody BucketDtoIn bucketDto){
        return new BucketDto((bucketService.createBucket(bucketDto)));
    }
}
