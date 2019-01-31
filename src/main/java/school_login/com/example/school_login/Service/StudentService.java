package school_login.com.example.school_login.Service;

import school_login.com.example.school_login.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
}
