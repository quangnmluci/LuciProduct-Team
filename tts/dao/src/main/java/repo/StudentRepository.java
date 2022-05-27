package repo;

import model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {
//    @Query("SELECT s FROM StudentModel s where s.name = ?1 ")
//    StudentModel findByName(@Param("name") String name);


@Query("SELECT s FROM StudentModel s where s.name like %?1% ")
List<StudentModel> findByName(@Param("name") String name);


}
