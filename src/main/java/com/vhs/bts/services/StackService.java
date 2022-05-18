package com.vhs.bts.services;

import com.vhs.bts.dto.NumberOfLaptopsInStackDtoIn;
import com.vhs.bts.dto.StackDtoIn;
import com.vhs.bts.entities.StackEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.StackRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StackService {

    private final StackRepository stackRepository;
    private final LaptopService laptopService;

    public List<StackEntity> getStacks() {
        return stackRepository.findAll();
    }

    public void deleteStackById(Long id) {
        stackRepository.deleteById(id);
    }

    public StackEntity createEmptyStack(StackDtoIn stackDto) {
        StackEntity stack = new StackEntity(stackDto);
        try {
            stack.setTimeOpen(LocalTime.parse(stackDto.getTimeOpen()));
            stack.setTimeClose(LocalTime.parse(stackDto.getTimeClose()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return stackRepository.save(stack);
    }

    public StackEntity getStackById(Long id) {
        return stackRepository.findById(id)
            .orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find stack with id = " + id));
    }

    public StackEntity changeLaptopsInTheStackById(List<NumberOfLaptopsInStackDtoIn> numberOfLaptopsInStackDtoIn, Long stackId) {
        StackEntity stack = getStackById(stackId);
        stack.getLaptops().clear();
        numberOfLaptopsInStackDtoIn.forEach(
            laptopsInStackDto -> stack.addLaptop(laptopService.getLaptopById(laptopsInStackDto.getLaptopId()),
                laptopsInStackDto.getQuantity()));
        return stackRepository.save(stack);
    }
}
