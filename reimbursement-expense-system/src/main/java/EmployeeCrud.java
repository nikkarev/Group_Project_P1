import java.util.List;

import io.javalin.Javalin;
import model.EmployeePojo;
import model.ReimbursementPojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class EmployeeCrud {

	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeServiceImpl();
		ReimbursementService reimbursementService = new ReimbursementServiceImpl();

		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins());
		server.start(7474);

		// GET ALL EMPLOYEES
		server.get("/employees", (ctx) -> {
			// here we contact service, service contacts dao
			// allEmployees contains all the employees fetched from the DB
			List<EmployeePojo> allEmployees = employeeService.getAllEmployees();

			// now put the books in the response body, it has to converted to json format,
			// the ctx.json() will take care of the above 2 and sends back the response to
			// the client/consumer
			ctx.json(allEmployees);
		});

		// endpoint for login validation
		server.post("/employees/login", (ctx) -> {
			EmployeePojo loginEmpPojo = ctx.bodyAsClass(EmployeePojo.class);
			ctx.json(employeeService.login(loginEmpPojo));
		});
<<<<<<< HEAD
		
		// post request to update employee info
		server.post("/employees/profile", (ctx) -> {
			
			EmployeePojo updateEmpProfilePojo = ctx.bodyAsClass(EmployeePojo.class);
			EmployeePojo returnEmpProfilePojo = employeeService.updateInfo(updateEmpProfilePojo);
			ctx.json(returnEmpProfilePojo); 
		});
		
		// get all reimbursement
		server.get("/reimbursement", (ctx)->{
			List<ReimbursementPojo> allRequests = reimbursementService.viewAllRequests();
			ctx.json(allRequests);
		});
		
		// get reimbursement details for a user
		server.get("/reimbursement/{bid}", (ctx)->{
			
			List<ReimbursementPojo> returnUserReimbursement =  reimbursementService.viewEmployeeRequests(Integer.parseInt(ctx.pathParam("bid")));
			ctx.json(returnUserReimbursement);
		});
		
		
=======



		// **************************************************REIMBURSEMENT CRUD OPERATION***************************************************

		// Get All Reimbursement Request
		server.get("/reimbursement", (ctx) -> {
			List<ReimbursementPojo> allRequests = reimbursementService.viewAllRequests();
			ctx.json(allRequests);
		});

>>>>>>> 5f3152b2467dea469ece2d3c57e468861ba78899
		server.post("/reimbursement", (ctx) -> {

			ReimbursementPojo newReimbursementPojo = ctx.bodyAsClass(ReimbursementPojo.class);
<<<<<<< HEAD
			
			
			ReimbursementPojo returnReimbursementPojo = reimbursementService.submitRequest(newReimbursementPojo);
			
			
			ctx.json(returnReimbursementPojo);
=======

			ReimbursementPojo returnBookPojo = reimbursementService.submitRequest(newReimbursementPojo);

			ctx.json(returnBookPojo);
>>>>>>> 5f3152b2467dea469ece2d3c57e468861ba78899
		});

	}

}
