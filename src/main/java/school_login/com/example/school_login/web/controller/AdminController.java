package school_login.com.example.school_login.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import school_login.com.example.school_login.Service.StudentService;
import school_login.com.example.school_login.Service.StudentServiceImpl;
import school_login.com.example.school_login.dao.StudentDao;
import school_login.com.example.school_login.model.Student;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentServiceImpl st;

    @Autowired
    private StudentDao studentDao;

    private Student studentData;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping({"/","/admin"})
    public String greeting(){
        return "admin";
    }
    // Form for adding a new student
    @RequestMapping("student/add")
    public String formNewCategory(Model model) {
        // TODO: Add model attributes needed for new form
        if(!model.containsAttribute("")) {
            model.addAttribute("student",new Student(studentData.getUsername(),studentData.getPassword(),studentData.isEnabled(), studentData.getRoles()));
        }
        model.addAttribute("action","/student");
        model.addAttribute("submit","Add");

        return "/admin";
    }

    @RequestMapping(value="/student", method=RequestMethod.POST)
    public String studentSubmit(@ModelAttribute Student student, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        String hashedPassword = passwordEncoder.encode(student.getPassword());

        Student studentDetails = new Student(student.getUsername(), hashedPassword, student.isEnabled(),student.getRoles());

        model.addAttribute("student", student);
        studentDao.save(studentDetails);

        return "/admin";
    }

    // Home page - index of all students
    @RequestMapping("/student")
    public String listStudents(Model model) {
        // TODO: Get all Students
        List<Student> students =  st.findAll();
        model.addAttribute("students", students);
        return "/student-list";
    }


}
