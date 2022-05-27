package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Service;
import service.Student;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private Service service;

//    @Autowired
//    private MainController(Service service){
//        this.service = service;
//    }

    @GetMapping("/list")
    public List<Student> listStudent(){
        return service.getAll();
    }
    @GetMapping("/index")
    public String index(){
        return "hello";
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){

        return service.save(student);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return service.deleteById(id);
    }
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable Integer id){
        return service.findById(id);
    }
    @GetMapping("/student/findById/{id}")
    public ResponseEntity<Student> findId(@PathVariable Integer id){
        if ( !service.existById(id)){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(service.findById(id));
    }
    @PutMapping("/update/{id}")
    public String updateStudent(@RequestBody Student student,@PathVariable Integer id){
        return service.update(student,id);
        
    }
    @GetMapping("/findByName")
    public List<Student> findByName(@RequestParam(name="name") String name){
        return service.findByName(name);
    }

}
