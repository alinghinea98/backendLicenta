package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.AlertDto;
import com.alinghinea.Server.service.AlertService;
import com.alinghinea.Server.transformer.AlertTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @Autowired
    private AlertTransformer alertTransformer;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody AlertDto createAlert(AlertDto alertDto) {
        return alertTransformer.toDto(alertService.createAlert(alertTransformer.toEntity(alertDto)));
    }
}
