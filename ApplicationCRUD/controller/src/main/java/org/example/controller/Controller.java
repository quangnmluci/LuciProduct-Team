package org.example.controller;

import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class Controller {
    private Service service;
    @Autowired
    public Controller(Service service) {
        this.service = service;
    }
    @GetMapping(value = "/")
    public Optional<List<Service.ServiceDTO>> collection(){
        return service.getUsers();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@RequestBody Service.ServiceDTO serviceDTO){
        if(service.save(serviceDTO)) {
            return ResponseEntity.ok("Success");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/{userID}")
    public ResponseEntity<String> update(@PathVariable int userID, @RequestBody Service.ServiceDTO serviceDTO){
        if(service.update(serviceDTO,userID))
            return ResponseEntity.ok("Success !");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{userID}")
    public ResponseEntity<String> delete(@PathVariable int userID){
        if(service.delete(userID))
            return ResponseEntity.ok("Success !");
        return ResponseEntity.notFound().build();
    }

}