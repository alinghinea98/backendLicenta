package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.KitDto;
import com.alinghinea.Server.service.KitService;
import com.alinghinea.Server.transformer.KitTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kit")
public class KitController {

    @Autowired
    private KitTransformer kitTransformer;

    @Autowired
    private KitService kitService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody KitDto createKit(KitDto kit) {
        return kitTransformer.toDto(kitService.createKit(kitTransformer.toEntity(kit)));
    }
}
