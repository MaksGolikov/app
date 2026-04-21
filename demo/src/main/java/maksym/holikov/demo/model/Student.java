package maksym.holikov.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Student {

    @NotBlank(message = "Ім'я не може бути порожнім")
    private String name;

    @Min(value = 16, message = "Мінімальний вік 16")
    @Max(value = 100, message = "Максимальний вік 100")
    private int age;

    @Email(message = "Некоректний email")
    @NotBlank(message = "Email обов'язковий")
    private String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
