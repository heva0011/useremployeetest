package com.example.useremployee.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repositories.EmployeeRepository;
import repositories.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void testOneHeval() {
        List<Employee> list = employeeRepository.findAllByName("Heval");
        assertTrue(list.size() > 0);
    }

    @Test
    void testDeleteUser() {
        List<Employee> employeeList = employeeRepository.findAllByName("Heval");
        Employee employee = employeeList.get(0);
        assertEquals("Heval", employee.getName());
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(employee.getUser()));
    }
}