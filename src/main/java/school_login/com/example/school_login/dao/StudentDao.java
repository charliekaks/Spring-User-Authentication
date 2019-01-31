package school_login.com.example.school_login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school_login.com.example.school_login.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student,Long> {
    Student findByUsername (String username);
}
