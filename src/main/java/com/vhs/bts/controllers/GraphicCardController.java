package com.vhs.bts.controllers;

import com.vhs.bts.dto.GraphicCardDto;
import com.vhs.bts.dto.GraphicCardDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.GraphicCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/graphics_card")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GraphicCardController {

    private final DtoConverter dtoConverter;
    private final GraphicCardService graphicCardService;

    @GetMapping
    public List<GraphicCardDto> getGraphicCards() {
        return dtoConverter.simpleConvert(graphicCardService.getGraphicCards(), GraphicCardDto.class);
    }

    @PostMapping
    public GraphicCardDto createGraphicCard(@RequestBody GraphicCardDtoIn graphicCardDto) {
        return dtoConverter.simpleConvert(graphicCardService.createGraphicCard(graphicCardDto), GraphicCardDto.class);
    }

    @GetMapping("/{id}")
    public GraphicCardDto getGraphicCardById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(graphicCardService.getGraphicCardById(id), GraphicCardDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteGraphicCardById(@PathVariable Long id) {
        graphicCardService.deleteGraphicCardById(id);
    }

    @PutMapping("/{id}")
    public GraphicCardDto updateGraphicCardById(@PathVariable Long id, @RequestBody GraphicCardDtoIn graphicCardDto) {
        return dtoConverter.simpleConvert(graphicCardService.updateGraphicCardById(id, graphicCardDto), GraphicCardDto.class);
    }
}
