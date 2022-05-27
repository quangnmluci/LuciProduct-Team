package org.example.dao;

import org.example.Dao;
import org.example.entity.Entity;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DaoImp implements Dao {

    private final UserRepository userRepository;

    @Autowired
    public DaoImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<Service.ServiceDTO> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(DaoImp::toServiceEntity).collect(Collectors.toList());
    }

    @Override
    public boolean save(Service.ServiceDTO serviceDTO) {
        userRepository.save(toEntity((serviceDTO)));
       return true;
    }

    @Override
    public boolean update(Service.ServiceDTO serviceDTO, int id) {
        if(!userRepository.existsById(id)) {
            return false;
        }
        Entity entity = new Entity();
        entity.setId(id);
        entity.setAge(serviceDTO.getAge());
        entity.setName(serviceDTO.getName());
        entity.setEmail(serviceDTO.getEmail());
        userRepository.save(entity);
        return true;
    }

    @Override
    public boolean delete(int id) {
        userRepository.deleteById(id);
        return true;
    }

    public static Service.ServiceDTO toServiceEntity(Entity entity){
        Service.ServiceDTO serviceEntity = new Service.ServiceDTO();
        serviceEntity.setId(entity.getId());
        serviceEntity.setAge(entity.getAge());
        serviceEntity.setName(entity.getName());
        serviceEntity.setEmail(entity.getEmail());
        return serviceEntity;
    }

    public static Entity toEntity(Service.ServiceDTO serviceDTO){
        Entity entity = new Entity();
        entity.setAge(serviceDTO.getAge());
        entity.setId(serviceDTO.getId());
        entity.setName(serviceDTO.getName().toString());
        entity.setEmail(serviceDTO.getEmail());
        return entity;
    }
}
