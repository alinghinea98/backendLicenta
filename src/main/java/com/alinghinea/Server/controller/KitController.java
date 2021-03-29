package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.KitDto;
import com.alinghinea.Server.entities.Kit;
import com.alinghinea.Server.service.KitService;
import com.alinghinea.Server.transformer.KitTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kit")
public class KitController {

    @Autowired
    private KitTransformer kitTransformer;

    @Autowired
    private KitService kitService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    KitDto createKit(KitDto kit) {
        return kitTransformer.toDto(kitService.createKit(kitTransformer.toEntity(kit)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public KitDto getKit(long id) {
        return kitTransformer.toDto(kitService.getKitId(id));
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KitDto> getKits() {
        List<Kit> kits = kitService.getKits();
        List<KitDto> dtos = new ArrayList<KitDto>();
        for (int i = 0; i < kits.size(); i++) {
            dtos.add(kitTransformer.toDto(kits.get(i)));
        }
        return dtos;
    }
}
