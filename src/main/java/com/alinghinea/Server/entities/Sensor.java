package com.alinghinea.Server.entities;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Column(name = "sensor_name",length = 128)
    private String name;

    @Column(name = "sensor_description",length = 128)
    private String description;

    @Column(name = "sensor_type",length = 128)
    private String type;

    @Column(name = "sensor_value",length = 128)
    private String value;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_kit", referencedColumnName = "user_kit")
    private Kit kit;

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
