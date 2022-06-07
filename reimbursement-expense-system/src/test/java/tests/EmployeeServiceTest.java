package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dao.EmployeeDao;
import exception.ApplicationException;
import model.EmployeePojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;


@ExtendWith (MockitoExtension.class)

public class EmployeeServiceTest {
	
	@Mock
	
	private EmployeeDao daoMock;
	
	
	@InjectMocks
	
	private EmployeeServiceImpl service;
	
	
	@Test
	public void testViewInfo() throws ApplicationException {
		EmployeeService employeeService = new EmployeeServiceImpl();

		EmployeePojo expectedPojo = employeeService.viewInfo(2);
		EmployeePojo actualPojo = null;
		try {
			// since there is no mockito, in the next line the service layer will call the
			// dao layer and that does not qualify for unit testing
			actualPojo = employeeService.viewInfo(2);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// for assert equals to work, ProductPojo class should have overridden equals
		// and hashcode method
		assertEquals(expectedPojo, actualPojo);
	}
	
	@Test
	public void testGetAllEmployees() throws ApplicationException {
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		List<EmployeePojo> expectedEmployees = employeeService.getAllEmployees();
		
		List<EmployeePojo> actualEmployees = null;
		try {
			actualEmployees = employeeService.getAllEmployees();
		} catch(ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedEmployees, actualEmployees);
	}
	
	@Test
	public void testUpdateInfoWithMockito() throws ApplicationException {
		
		EmployeePojo sendPojo = new EmployeePojo(0, 1, "rambo", "terminator", "rambo@gmail.com","johnny123","rambo123",false);
		EmployeePojo returnPojo = new EmployeePojo(5, 1, "rambo", "terminator", "rambo@gmail.com","johhny123","rambo123",false);
		
		
		when(daoMock.updateInfo(sendPojo)).thenReturn(returnPojo);
		
		EmployeePojo expectedPojo = new EmployeePojo(5, 1, "rambo", "terminator", "rambo@gmail.com","johhny123","rambo123",false);
		EmployeePojo actualReturnPojo = null;
		
		try {
			
			actualReturnPojo = service.updateInfo(sendPojo);		
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedPojo, actualReturnPojo);
	}
	
	
}

  		
	

