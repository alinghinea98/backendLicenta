package com.alinghinea.Server.dto;

import javax.validation.constraints.Size;

public class SensorDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    @Size(min = 0, max = 255)
    private String name;

    @Size(min = 0, max = 255)
    private String description;

    @Size(min = 0, max = 255)
    private String type;

    @Size(min = 0, max = 255)
    private String value;
}
