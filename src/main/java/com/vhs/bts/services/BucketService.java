package com.vhs.bts.services;

import com.vhs.bts.dto.BucketDtoIn;
import com.vhs.bts.entities.BucketEntity;
import com.vhs.bts.entities.UserEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.BucketRepository;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class BucketService {

    private final BucketRepository bucketRepository;
    private final LaptopService laptopService;

    public List<BucketEntity> getAllBuckets() {
        return bucketRepository.findAll();
    }

    public BucketEntity changeLaptopsToBucket(Long id, BucketDtoIn bucketDto) {
        BucketEntity bucketEntity = getBucketById(id);
        bucketEntity.setLaptops(bucketDto.getLaptopsId().stream().map(laptopService::getLaptopById).collect(Collectors.toList()));
        bucketEntity.setDate(Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).getTime());
        return bucketRepository.save(bucketEntity);
    }

    public void createEmptyBucketByUser(UserEntity user) {
        BucketEntity bucketEntity = new BucketEntity();
        bucketEntity.setUser(user);
        bucketRepository.save(bucketEntity);
    }

    public BucketEntity getBucketById(Long id) {
        return bucketRepository.findById(id)
            .orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find bucket with id = " + id));
    }
}
