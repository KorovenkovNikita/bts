package com.vhs.bts.services;

import com.vhs.bts.dto.GraphicCardDtoIn;
import com.vhs.bts.entities.GraphicCardEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.GraphicCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GraphicCardService {
    private final GraphicCardRepository graphicCardRepository;

    public List<GraphicCardEntity> getGraphicCards() {
        return graphicCardRepository.findAll();
    }

    public GraphicCardEntity getGraphicCardById(Long id) {
        return graphicCardRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find graphicCard with id = " + id));
    }

    public GraphicCardEntity createGraphicCard(GraphicCardDtoIn graphicCardDto) {
        return graphicCardRepository.save(new GraphicCardEntity(graphicCardDto));
    }

    public void deleteGraphicCardById(Long id) {
        graphicCardRepository.deleteById(id);
    }

    public GraphicCardEntity updateGraphicCardById(Long id, GraphicCardDtoIn newGraphicCardEntity) {
        GraphicCardEntity graphicCard = getGraphicCardById(id);
        graphicCard.setManufacturer(newGraphicCardEntity.getManufacturer());
        graphicCard.setModelNumber(newGraphicCardEntity.getManufacturer());
        graphicCard.setMemory(newGraphicCardEntity.getMemory());
        return graphicCardRepository.save(graphicCard);
    }
}
