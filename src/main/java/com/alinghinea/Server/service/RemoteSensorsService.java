package com.alinghinea.Server.service;

import com.alinghinea.Server.entities.RemoteSensors;
import com.alinghinea.Server.repository.RemoteSensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RemoteSensorsService {

    @Autowired
    private RemoteSensorsRepository repository;

    public RemoteSensors createRemoteSensors(RemoteSensors remoteSensors) {
        return repository.save(remoteSensors);
    }

    public RemoteSensors getSensorsByUser(long id) {
        return repository.getByUser(id);
    }
}
