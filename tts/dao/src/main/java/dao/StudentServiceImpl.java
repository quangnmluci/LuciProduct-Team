package dao;

import model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.StudentRepository;
import service.IStudentService;
import service.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {


    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> stm = new ArrayList<Student>(); //khoi tao 1 mang student o service xong
        for (StudentModel s : studentRepository.findAll()){
            stm.add(map(s)); // add du lieu tu entity vao student
        }
        return stm; // -> tra ve du lieu mang student
    }

    @Override
    public String save(Student student) {
        studentRepository.save(mapReverse(student));
        return "Student is created";
    }
    @Override
    public String update(Student student,Integer id ) {
        if (!studentRepository.existsById(id) ){
            return "not exist";
        }else {
        StudentModel stm = studentRepository.findById(id).get();
        stm.setName(student.getName());
        stm.setAge(student.getAge());
        studentRepository.save(stm);
        return "update success";}
    }

    @Override
    public boolean existById(Integer id) {
        return studentRepository.existsById(id);
    }


    @Override
    public String deleteById(Integer id) {
        if (!studentRepository.existsById(id) ){
            return "not exist";
        }else {
            studentRepository.deleteById(id);
            return "student is removed";
        }

    }

    @Override
    public Student findById(Integer id) {
        if(!studentRepository.existsById(id))
        {
           return null;
        }
        else {
        StudentModel stm = studentRepository.findById(id).get();
        Student student = new Student();
        student.setAge(stm.getAge());
        student.setName(stm.getName());
        student.setId(stm.getId());
        return student ;}
    }
//    @Override
//    public Student findByName(String name) { khong duoc vi student chi tra ve 1 ket qua ma` ten thi` lai co nhièu
//        StudentModel stm = studentRepository.findByName(name);
//        Student student = new Student();
//        student.setA'ge(stm.getAge());
//        student.setName(stm.getName());
//        student.setId(stm.getId());
//        return student ;
//
//    }
          @Override
            public List<Student> findByName(String name) {
            List<Student> student = new ArrayList<>();
            for (StudentModel stm : studentRepository.findByName(name)){
                student.add(map(stm));
            }
             return student;
        }




    public static Student map(StudentModel studentModel){ //get
        if (studentModel == null)
        {
            return null;
        }
        Student student = new Student();
        student.setAge(studentModel.getAge());
        student.setName(studentModel.getName());
        student.setId(studentModel.getId());
        return student;
    }
    public static StudentModel mapReverse(Student student){ //create
        if(student ==null){
            return null;
        }
        StudentModel stm = new StudentModel();
        stm.setAge(student.getAge());
        stm.setName(student.getName());
        return stm;
    }

}
