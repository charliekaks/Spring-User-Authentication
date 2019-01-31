package school_login.com.example.school_login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_login.com.example.school_login.dao.StudentDao;
import school_login.com.example.school_login.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao addUser;

    @Override
    public List<Student> findAll() {
        List<Student> students = (List<Student>) addUser.findAll();
        return students;
    }

    @Override
    public void save(Student student) {
        addUser.save(student);
    }
}
