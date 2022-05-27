package org.example.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.Dao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class Service {

    //Use Lombok
    @Data
    public static class ServiceDTO {
        private int id;
        private String name;
        private int age;
        private String email;
    }

    private Dao dao;

    public Service(Dao dao) {
        this.dao = dao;
    }

    public Optional<List<ServiceDTO>> getUsers() {
        Optional<List<ServiceDTO>> optionalServiceDTO = Optional.of(dao.getUsers());
        return optionalServiceDTO;
    }

    public boolean update(ServiceDTO serviceDTO, int id) {
        return dao.update(serviceDTO, id);
    }

    public boolean save(ServiceDTO serviceDTO) {
        Optional<ServiceDTO> serviceDTO1 = Optional.of(serviceDTO);
        dao.save(serviceDTO);
        return true;
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}