package maksym.holikov.demo.controller;

import jakarta.validation.Valid;
import maksym.holikov.demo.model.Student;
import maksym.holikov.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000") // React
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        service.addStudent(student);
        return student;
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}