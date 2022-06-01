
public class EmployeeCrud {

	public static void main(String[] args) {
		
		server.get("/employees", (ctx)->{
			// here we contact service, service contacts dao 
			// dao fetches all the books and return it back here
			
			// allEmployees contains all the employees fetched from the DB
			List<BookPojo> allBooks = bookService.getAllBooks();
			
			//now put the books in the response body, it has to converted to json format, 
			// the ctx.json() will take care of the above 2 and sends back the response to the client/consumer
			ctx.json(allBooks);
			
		});


	}

}
