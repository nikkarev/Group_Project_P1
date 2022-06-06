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
		// initiates the javalin server on port 7474
		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins());
		server.start(7474);

		// end point for GET ALL EMPLOYEES
		server.get("/employees", (ctx) -> {
			List<EmployeePojo> allEmployees = employeeService.getAllEmployees();
			ctx.json(allEmployees);
		});

		// end point for login validation
		server.post("/employees/login", (ctx) -> {
			EmployeePojo loginEmpPojo = ctx.bodyAsClass(EmployeePojo.class);
			ctx.json(employeeService.login(loginEmpPojo));
		});

		// post request to update employee info
		server.get("/employees/{eID}", (ctx) -> {
<<<<<<< HEAD
			EmployeePojo returnEmpProfilePojo = employeeService.viewInfo((Integer.parseInt(ctx.pathParam("eID"))));
			ctx.json(returnEmpProfilePojo);
		});

=======
			

			EmployeePojo returnEmpProfilePojo = employeeService.viewInfo((Integer.parseInt(ctx.pathParam("eID"))));
			ctx.json(returnEmpProfilePojo); 
		});
		
		
>>>>>>> d13c78013ecbea86e30a9c9e172138436c9ada5f
		// update employee profile info
		server.post("/employees/profile", (ctx) -> {
			EmployeePojo updateEmpProfilePojo = ctx.bodyAsClass(EmployeePojo.class);
			ctx.json(employeeService.updateInfo(updateEmpProfilePojo));
		});

		// **************************************************REIMBURSEMENT CRUD
		// OPERATION***************************************************

		// Get All Reimbursement Request
		server.get("/reimbursement", (ctx) -> {
			List<ReimbursementPojo> allRequests = reimbursementService.viewAllRequests();
			ctx.json(allRequests);
		});
		// Get all resolved requests
		server.get("/resolvedreimbursement", (ctx) -> {
			List<ReimbursementPojo> allResolvedRequests = reimbursementService.viewAllResolvedRequests();
			ctx.json(allResolvedRequests);
		});

		// submit reimbursement request
		server.post("/reimbursement", (ctx) -> {
			ReimbursementPojo newReimbursementPojo = ctx.bodyAsClass(ReimbursementPojo.class);
			ReimbursementPojo returnReimbursementPojo = reimbursementService.submitRequest(newReimbursementPojo);
			ctx.json(returnReimbursementPojo);
			ReimbursementPojo returnBookPojo = reimbursementService.submitRequest(newReimbursementPojo);
			ctx.json(returnBookPojo);
		});
		//end point for change a reimbursement status 
		server.post("/reimbursement/changestatus", (ctx) -> {

			ReimbursementPojo newReimbursementPojo = ctx.bodyAsClass(ReimbursementPojo.class);

			ReimbursementPojo updateReimbursementPojo = reimbursementService.changeRequestStatus(newReimbursementPojo);

			ctx.json(updateReimbursementPojo);
		});

		// end point for viewing specific employee reimbursement request
		server.get("/reimbursement/{eID}", (ctx) -> {
			List<ReimbursementPojo> employeeRequestPojo = reimbursementService
					.viewEmployeeRequests(Integer.parseInt(ctx.pathParam("eID")));
			ctx.json(employeeRequestPojo);
		});
	}
}