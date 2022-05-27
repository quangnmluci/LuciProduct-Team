package application;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repo.StudentRepository;
import dao.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.IStudentService;
import service.Service;


@Configuration
@ComponentScan({"dao","service","controller"})
@EnableJpaRepositories("repo")
@EntityScan("model")
public class StudentConfig {


    @Bean
    public Service service(IStudentService iStudentService){

        return new Service(iStudentService);
    }

    @Bean
    public IStudentService iStudentService(StudentRepository studentRepository){
        return new StudentServiceImpl(studentRepository);
    }




}
