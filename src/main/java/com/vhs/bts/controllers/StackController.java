package com.vhs.bts.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stack")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StackController {

}
