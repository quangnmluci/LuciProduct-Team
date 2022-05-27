package org.example;

import org.example.service.Service;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface Dao {
    List<Service.ServiceDTO> getUsers();

    //Page<Service.ServiceDTO> findAll(Pageable pageable);

    boolean save(Service.ServiceDTO serviceDTO);
    boolean update(Service.ServiceDTO serviceDTO, int id);
    boolean delete(int id);

}
