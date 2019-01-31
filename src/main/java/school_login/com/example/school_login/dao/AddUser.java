package school_login.com.example.school_login.dao;



import org.springframework.stereotype.Repository;
import school_login.com.example.school_login.model.Student;

import java.util.List;

@Repository
public interface AddUser {
    List<Student> findAll();
    void save(Student studentUser);
}
