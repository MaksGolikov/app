package maksym.holikov.demo.service.impl;

import maksym.holikov.demo.model.Student;
import maksym.holikov.demo.repository.StudentRepository;
import maksym.holikov.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> searchByName(String name) {
        return repository.findByName(name);
    }
}
