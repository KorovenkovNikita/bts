package com.vhs.bts.dto;

import com.vhs.bts.entities.BucketEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class BucketDto {
    private Long id;
    private UserDto user;
    private List<LaptopDto> laptops;


    public BucketDto(BucketEntity bucket) {
        setId(bucket.getId());
        setLaptops(bucket.getLaptops().stream().map(LaptopDto::new).collect(Collectors.toList()));
        setUser(new UserDto(bucket.getUser()));
    }
}
