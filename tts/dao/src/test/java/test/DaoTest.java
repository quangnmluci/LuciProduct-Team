package test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.IStudentService;
import service.Service;
import service.Student;

import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(MockitoExtension.class)
public class DaoTest {

     @Mock
     private IStudentService iStudentService;

     @InjectMocks
     private Service service;

    @Test
    public void shouldReturnNullIfInputNull(){

        assertNull(service.save(null));
    }
    @Test
    public void returnStudent(){
        org.assertj.core.api.Assertions.assertThat(service.save(new Student("dat",1)));

    }



//    @Test
//    public void getAll() {
//        List<StudentModel> stm = new ArrayList<>();
//        StudentModel a = new StudentModel("a", 1);
//        System.out.println();
//        stm.add(a);
//
//        List<Student> s = studentService.findAllStudent();
//        Student student = new Student("dat",1);
//        s.add(student);
//        System.out.println("dat   " +student.getAge() +student.getName());
//        String saved= studentService.save(student);
//        System.out.println("aaaa "+saved);
//    }





}
