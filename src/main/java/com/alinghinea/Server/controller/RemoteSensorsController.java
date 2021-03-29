package com.alinghinea.Server.controller;

import com.alinghinea.Server.dto.RemoteSensorsDto;
import com.alinghinea.Server.service.RemoteSensorsService;
import com.alinghinea.Server.transformer.RemoteSensorsTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remote")
public class RemoteSensorsController {

    @Autowired
    private RemoteSensorsTransformer remoteSensorsTransformer;

    @Autowired
    private RemoteSensorsService remoteSensorsService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    RemoteSensorsDto createRemoteSensors(RemoteSensorsDto remoteSensorsDto) {
        return remoteSensorsTransformer.toDto(remoteSensorsService.createRemoteSensors(remoteSensorsTransformer.toEntity(remoteSensorsDto)));
    }

}
