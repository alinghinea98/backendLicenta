package com.alinghinea.Server.service;

import com.alinghinea.Server.entities.Alert;
import com.alinghinea.Server.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public Alert createAlert(Alert alert) {
        return this.alertRepository.save(alert);
    }
}
