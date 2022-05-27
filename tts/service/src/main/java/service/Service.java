package service;

import java.util.List;

public class Service {

    private IStudentService iStudentService;

    public Service(IStudentService iStudentService) {
        this.iStudentService = iStudentService ;
    }
    public List<Student> getAll(){
        return iStudentService.findAllStudent();
    }
    public String save(Student student){
        return iStudentService.save(student);
    }
    public String deleteById(Integer id){
      return  iStudentService.deleteById(id);

    }

    public boolean existById(Integer id){
        return iStudentService.existById(id);
    }
    public Student findById(Integer id){
        return iStudentService.findById(id);
    }
    public List<Student> findByName(String name){
        return iStudentService.findByName(name);
    }
    public String update(Student student,Integer id){
        return iStudentService.update(student,id);
    }

    public Service() {
    }
}
