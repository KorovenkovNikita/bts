package com.vhs.bts.mapper;

import com.vhs.bts.dto.BucketDto;
import com.vhs.bts.dto.UserDto;
import com.vhs.bts.entities.UserEntity;
import com.vhs.bts.services.BucketService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class DtoConverter {

    private final BucketService bucketService;
    private final ModelMapper modelMapper;

    public UserDto convertUser(UserEntity user) {
        UserDto userDto = simpleConvert(user, UserDto.class);
        userDto.setBucket(simpleConvert(bucketService.getBucketById(user.getId()), BucketDto.class));
        return userDto;
    }

    public <T> T simpleConvert(Object obj, Class<T> clazz) {
        return modelMapper.map(obj, clazz);
    }

    public <T> List<T> simpleConvert(List<?> entitiesList, Class<T> clazz) {
        return entitiesList.stream().map(x -> simpleConvert(x, clazz)).collect(Collectors.toList());
    }

}
