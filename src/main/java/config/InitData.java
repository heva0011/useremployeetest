package config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repositories.EmployeeRepository;
import repositories.UserRepository;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserID(0);
        user.setEmail("heval@hotmail.com");
        user.setPassword("password");
        userRepository.save(user);

        Employee employee = new Employee();
        employee.setBorn(LocalDateTime.of(2001, 5, 17, 8, 8, 45));
        employee.setName("Heval");
        employee.setGender(Gender.FEMALE);
        employee.setVegetarian(false);
        employee.setUser(user);
        employeeRepository.save(employee);
    }
}
