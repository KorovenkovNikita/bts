package com.vhs.bts.controllers;

import com.vhs.bts.entities.DeviceEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @GetMapping
    public List<DeviceEntity> getDevices() {
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        DeviceEntity lenovo5 = new DeviceEntity("Ноутбук Lenovo Legion 5 17ACH6H, 17.3");
        DeviceEntity lenovo7 = new DeviceEntity("Ноутбук Lenovo Legion 7 16ACHg6, 16");
        deviceEntities.add(lenovo5);
        deviceEntities.add(lenovo7);
        return deviceEntities;
    }
    @GetMapping("/note")
    public DeviceEntity getNote() {
        return new DeviceEntity("Ноутбук Lenovo Legion 5 17ACH6H, 17.3");
    }
}
