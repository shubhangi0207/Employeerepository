package com.employee.service;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.dto.Employee;
import com.employee.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class EmployeeServiceImplTest {

	@Mock
	EmployeeRepository empRepo;

	@InjectMocks
	EmployeeServiceImpl service;

	@BeforeAll
	void init() {
		empRepo = mock(EmployeeRepository.class);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void addEmployeeDetailsTest() {

		Employee emp = new Employee();
		emp.setEmpid("testing-ID");
		emp.setName("Krishna");
		emp.setSalary(20000.0);
		emp.setAge(30);

		service.addEmployeeDetails(emp);
	}

}
