package ru.mis.mis.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mis.mis.exception.EmployeeNotFoundException;
import ru.mis.mis.exception.NotFoundException;
import ru.mis.mis.mapper.EmployeeMapper;
import ru.mis.mis.model.Employee;
import ru.mis.mis.repository.EmployeeRepository;
import ru.mis.mis.dto.EmployeeDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImpTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImp employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImp(employeeRepository);
    }

    @Test
    void getAll_ShouldReturnEmployees() {
        Employee employee = new Employee();
        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));

        Optional<Object> employees = employeeService.getAll();

        assertTrue(employees.isPresent());
        assertEquals(1, ((List<Employee>) employees.get()).size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void getAll_WhenNoEmployees_ShouldReturnEmptyOptional() {
        when(employeeRepository.findAll()).thenReturn(Collections.emptyList());

        Optional<Object> employees = employeeService.getAll();

        assertFalse(employees.isPresent());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void findById_ShouldReturnEmployee() {
        int employeeId = 1;
        Employee employee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        Optional<Employee> foundEmployee = employeeService.findById(employeeId);

        assertTrue(foundEmployee.isPresent());
        assertEquals(employee, foundEmployee.get());
        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test
    void findById_WhenEmployeeNotFound_ShouldThrowException() {
        int employeeId = 1;
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findById(employeeId);
        });

        assertEquals("Сотрудник с id 1 не найден", exception.getMessage());
        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test
    void create_ShouldReturnCreatedEmployeeDto() {
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDto createdEmployeeDto = employeeService.create(employeeDto);

        assertNotNull(createdEmployeeDto);
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void updateEmployee_ShouldReturnUpdatedEmployeeDto() {
        int employeeId = 1;
        Employee originalEmployee = new Employee();
        EmployeeDto employeeDto = new EmployeeDto();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(originalEmployee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(originalEmployee);

        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeDto, employeeId);

        assertNotNull(updatedEmployeeDto);
        verify(employeeRepository, times(1)).findById(employeeId);
        verify(employeeRepository, times(1)).save(originalEmployee);
    }

    @Test
    void employeeDelete_ShouldRemoveEmployee() {
        int employeeId = 1;
        Employee employee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        employeeService.employeeDelete(employeeId);

        verify(employeeRepository, times(1)).delete(employee);
    }

    @Test
    void employeeDelete_WhenEmployeeNotFound_ShouldThrowException() {
        int employeeId = 1;
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            employeeService.employeeDelete(employeeId);
        });

        assertEquals("No user ID", exception.getMessage());
        verify(employeeRepository, times(1)).findById(employeeId);
    }
}
