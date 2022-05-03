package com.vhs.bts.services;

import com.vhs.bts.dto.LaptopDtoIn;
import com.vhs.bts.entities.StackLaptop;
import com.vhs.bts.repositories.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StackService {

    private final StackRepository stackRepository;

    public void addLaptop(LaptopDtoIn laptop) {
        StackLaptop stack = new StackLaptop(laptop);
        tags.add(stack);
        tag.getPosts().add(stack);
    }
}
