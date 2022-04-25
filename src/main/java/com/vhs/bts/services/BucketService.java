package com.vhs.bts.services;

import com.vhs.bts.dto.BucketDtoIn;
import com.vhs.bts.entities.BucketEntity;
import com.vhs.bts.repositories.BucketRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class BucketService {

    private final BucketRepository bucketRepository;
    private final LaptopService laptopService;
    private final UserService userService;

    public List<BucketEntity> getBuckets() {
        return bucketRepository.findAll();
    }

    public BucketEntity createBucket(BucketDtoIn bucketDto) {
        BucketEntity bucketEntity = new BucketEntity();
        bucketEntity.setUser(userService.getUserById(bucketDto.getUserId()));
        bucketEntity.setLaptops(bucketDto.getLaptopsId().stream().map(laptopService::getLaptopById).collect(Collectors.toList()));
        return bucketRepository.save(bucketEntity);
    }
}
