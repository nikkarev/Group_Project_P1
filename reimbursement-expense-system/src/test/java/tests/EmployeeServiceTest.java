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
	public void testViewInfo() {
		EmployeeService employeeService = new EmployeeServiceImpl();

		EmployeePojo expectedPojo = new EmployeePojo(2, 1, "charlie", "chaplin", "bradpotter@gmail.com", "charlie123", "catsarecool789", false);
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
	public void testGetAllEmployees() {
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		List<EmployeePojo> expectedEmployees = new ArrayList<EmployeePojo>();
		EmployeePojo bradPojo = new EmployeePojo(2, 1, "charlie", "chaplin", "bradpotter@gmail.com", "charlie123", "catsarecool789", false);
		EmployeePojo harryPojo = new EmployeePojo(3, 1, "johnny", "depp", "", "", "turtlesaresweet987", false);
		EmployeePojo georgePojo = new EmployeePojo(4, 1, "George", "Jefferson", "georgejefferson@gmail.com", "gjefferson123", "birdistheword654", false);
		expectedEmployees.add(bradPojo);
		expectedEmployees.add(harryPojo);
		expectedEmployees.add(georgePojo);
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

  		
	

