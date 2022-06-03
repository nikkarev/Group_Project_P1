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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
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

=======
=======
>>>>>>> Stashed changes
		//GET ALL EMPLOYEES
		server.get("/employees", (ctx)->{
			// here we contact service, service contacts dao 
			// allEmployees contains all the employees fetched from the DB
			List<EmployeePojo> allEmployees = employeeService.getAllEmployees();

			//now put the books in the response body, it has to converted to json format, 
			// the ctx.json() will take care of the above 2 and sends back the response to the client/consumer
			ctx.json(allEmployees);
		});


<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
		// endpoint for login validation
		server.post("/employees/login", (ctx) -> {
			EmployeePojo loginEmpPojo = ctx.bodyAsClass(EmployeePojo.class);
			ctx.json(employeeService.login(loginEmpPojo));
		});
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		
		// post request to update employee info
		server.post("/employees/profile", (ctx) -> {
			
			EmployeePojo updateEmpProfilePojo = ctx.bodyAsClass(EmployeePojo.class);
			EmployeePojo returnEmpProfilePojo = employeeService.updateInfo(updateEmpProfilePojo);
			ctx.json(returnEmpProfilePojo); 
		});
		
=======

>>>>>>> Stashed changes
=======

>>>>>>> Stashed changes
		// get all reimbursement
		server.get("/reimbursement", (ctx)->{
			List<ReimbursementPojo> allRequests = reimbursementService.viewAllRequests();
			ctx.json(allRequests);
		});
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		
		// get reimbursement details for a user
		server.get("/reimbursement/{bid}", (ctx)->{
			
			List<ReimbursementPojo> returnUserReimbursement =  reimbursementService.viewEmployeeRequests(Integer.parseInt(ctx.pathParam("bid")));
			ctx.json(returnUserReimbursement);
		});



		// **************************************************REIMBURSEMENT CRUD OPERATION***************************************************

		// Get All Reimbursement Request
		server.get("/reimbursement", (ctx) -> {
			List<ReimbursementPojo> allRequests = reimbursementService.viewAllRequests();
			ctx.json(allRequests);
		});

		server.post("/reimbursement", (ctx) -> {

			ReimbursementPojo newReimbursementPojo = ctx.bodyAsClass(ReimbursementPojo.class);

			
			
			ReimbursementPojo returnReimbursementPojo = reimbursementService.submitRequest(newReimbursementPojo);
			
			
			ctx.json(returnReimbursementPojo);


			ReimbursementPojo returnBookPojo = reimbursementService.submitRequest(newReimbursementPojo);

=======

		server.post("/reimbursement", (ctx) -> {
			ReimbursementPojo newReimbursementPojo = ctx.bodyAsClass(ReimbursementPojo.class);
			ReimbursementPojo returnBookPojo = reimbursementService.submitRequest(newReimbursementPojo);
>>>>>>> Stashed changes
=======

		server.post("/reimbursement", (ctx) -> {
			ReimbursementPojo newReimbursementPojo = ctx.bodyAsClass(ReimbursementPojo.class);
			ReimbursementPojo returnBookPojo = reimbursementService.submitRequest(newReimbursementPojo);
>>>>>>> Stashed changes
			ctx.json(returnBookPojo);
		});
		
		// endpoint for viewing specific employee reimbursement request
		server.get("/reimbursement/{employeeIdRequest}", (ctx) -> {
			String employeeId = ctx.pathParam("employeeIdRequest"); // bid is the parameter name
			int employeeIdInteger = Integer.parseInt(employeeId);
//			ctx.result(reimbursementService.viewEmployeeRequests(employeeIdInteger) + "");
			List<ReimbursementPojo> employeeRequestPojo = reimbursementService.viewEmployeeRequests(employeeIdInteger);
			ctx.json(employeeRequestPojo);
		});
	
	}

}
