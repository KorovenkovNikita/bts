package com.vhs.bts.services;


import com.vhs.bts.entities.ScreenEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ScreenService {
    private final ScreenRepository screenRepository;

    public ScreenEntity getScreenById(long id) {
        return screenRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find screen with id = " + id));
    }
}
