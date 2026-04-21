package maksym.holikov.demo.configuration;

import maksym.holikov.demo.model.Student;
import maksym.holikov.demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(StudentService service) {
        return args -> {
            service.addStudent(new Student("Taras", 20, "taras@gmail.com"));
            service.addStudent(new Student("Oksana", 22, "oksana@gmail.com"));
            service.addStudent(new Student("Ivan", 19, "ivan@gmail.com"));
            service.addStudent(new Student("Maria", 21, "maria@gmail.com"));
            service.addStudent(new Student("Andrii", 23, "andrii@gmail.com"));
        };
    }
}
