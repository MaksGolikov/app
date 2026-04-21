package maksym.holikov.demo.repository;

import maksym.holikov.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> findByName(String name) {
        return students.stream()
                .filter(s -> s.getName() != null &&
                        s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }


}
