package school_login.com.example.school_login.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class StudentController {
    @RequestMapping({"/student-users"})
    public String greeting(){
        return "student";
    }
}
