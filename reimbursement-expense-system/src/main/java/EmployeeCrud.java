import java.util.List;

import io.javalin.Javalin;
import model.EmployeePojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class EmployeeCrud {

	public static void main(String[] args) {
		
			EmployeeService employeeService = new EmployeeServiceImpl();
			
			Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins());
			server.start(7474);
			
			
			server.get("/employees", (ctx)->{
			// here we contact service, service contacts dao 
			// dao fetches all the books and return it back here
			
			// allEmployees contains all the employees fetched from the DB
			List<EmployeePojo> allEmployees = employeeService.getAllEmployees();
			
			//now put the books in the response body, it has to converted to json format, 
			// the ctx.json() will take care of the above 2 and sends back the response to the client/consumer
			ctx.json(allEmployees);
			
		});


	}

}
