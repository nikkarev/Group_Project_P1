<<<<<<< Updated upstream
import java.util.List;

import io.javalin.Javalin;
import model.EmployeePojo;
=======
import io.javalin.Javalin;
>>>>>>> Stashed changes
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class EmployeeCrud {

	public static void main(String[] args) {
		
<<<<<<< Updated upstream
			EmployeeService employeeService = new EmployeeServiceImpl();
			
			Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins());
			server.start(7474);
			
			//GET ALL EMPLOYEES
			server.get("/employees", (ctx)->{
			// here we contact service, service contacts dao 
			// allEmployees contains all the employees fetched from the DB
			List<EmployeePojo> allEmployees = employeeService.getAllEmployees();
			
			//now put the books in the response body, it has to converted to json format, 
			// the ctx.json() will take care of the above 2 and sends back the response to the client/consumer
			ctx.json(allEmployees);
<<<<<<< HEAD
			});
		
		
			// endpoint for login validation
			server.post("/employees/login", (ctx) -> {
				EmployeePojo loginEmpPojo = ctx.bodyAsClass(EmployeePojo.class);
				ctx.json(employeeService.login(loginEmpPojo));
			});
=======
=======
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins());
		
		server.get("/employees", (ctx)->{
			
>>>>>>> Stashed changes
			
		});
>>>>>>> 3acc696 (a)


	}

}
