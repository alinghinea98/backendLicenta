package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.AlertDto;
import com.alinghinea.Server.entities.Alert;
import com.alinghinea.Server.service.AlertService;
import com.alinghinea.Server.transformer.AlertTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AlertDto getAlerts(@RequestParam("id") long id) {
        return alertTransformer.toDto(alertService.getById(id));
    }

    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<AlertDto>> getAlertsByUser(@RequestParam("id") long id) {
        List<Alert> alert = alertService.getAlertByUser(id);
        List<AlertDto> alertDto = new ArrayList<AlertDto>();
        for (int i = 0; i < alert.size(); i++) {
            alertDto.add(alertTransformer.toDto(alert.get(i)));
        }
//        return alertDto.toArray(new AlertDto[0]);
        return Arrays.asList(alertDto);
    }

}
