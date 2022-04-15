package com.vhs.bts.controllers;

import com.vhs.bts.dto.GraphicCardDto;
import com.vhs.bts.services.GraphicCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/graphics_card")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GraphicCardController {
    private final GraphicCardService graphicCardService;

    @GetMapping
    public List<GraphicCardDto> getGraphicCards() {
        return graphicCardService.getGraphicCards().stream().map(GraphicCardDto::new).collect(Collectors.toList());
    }

}
