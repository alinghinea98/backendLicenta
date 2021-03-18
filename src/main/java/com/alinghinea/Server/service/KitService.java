package com.alinghinea.Server.service;

import com.alinghinea.Server.entities.Kit;
import com.alinghinea.Server.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KitService {

    @Autowired
    private KitRepository kitRepository;

    public Kit createKit(Kit kit) {
        return kitRepository.save(kit);
    }

    public Kit getKitId(long id) {
        return kitRepository.getKitById(id);
    }
}
