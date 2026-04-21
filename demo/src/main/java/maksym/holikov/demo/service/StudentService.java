package maksym.holikov.demo.service;

import maksym.holikov.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void addStudent(Student student);

    List<Student> searchByName(String name);
}
