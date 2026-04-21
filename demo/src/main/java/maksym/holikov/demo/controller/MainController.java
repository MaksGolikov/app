package maksym.holikov.demo.controller;


import maksym.holikov.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MainController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/world")
    public String helloWorld(Model model){
        String message = "hello world!";
        model.addAttribute("message", message);
        return "hello-world";
    }

    @GetMapping
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }


    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        students.add(student);
        return "redirect:/api";
    }

}
