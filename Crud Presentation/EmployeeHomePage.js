// JS functions will consum the endpoints


function printData(){

    console.log("data printed on the console");
    // document.write("Data Printed on the document")
    // console.log("data printed on the console.....")

    // document.getElementById("user input").innerHTML = "";
    

    let employeeFormTable = `"<table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Employee ID</th>
                                    <th>Employee Username</th>
                                    <th>Your Firstname</th>
                                    <th>Your Lastname</th>
                                    <th>Email Id</th>
                                    <th>Your Password</th>
                                
                                </tbody>
                            </table> `;

    fetch("http://localhost:7474/ers")
    .then(response => response.json())
    .then(responseJson => {
        
        console.log(responseJson)

        for(let employee of responseJson){
            employeeFormTable += `<tr><td>${employee.id}</td><td>${employee.username}</td><td>${employee.firstname}</td>
            <td>${employee.lastname}</td><td>${employee.email}</td><td>${employee.password}}`;
            document.getElementById("user input").innerHTML = employeeFormTable;
    }
})
    .catch(error =>console.log(error));
    
    
}

//  // 1 - this is supposed to be written inthe login functionality
//     // remove this once login functionailty is implemented
//     // start  - 1
//     let userInfo = {
//         employeeId: 3,
// 	    managerId: 5,
// 	    firstName:'John',
//         lastName: 'Smith',
// 	    email: 'abc@gmail.com',
// 	    userName: 'john',
// 	    password: '1234',
// 	    managerType: false
	
//     }

    // sessionStorage.setItem("user", JSON.stringify(userInfo)); // JSON.stringify() - converts a JS object to a String JSON
    // // end -1

    // let employee = JSON.parse(sessionStorage.getItem("user")); // JSON.parse() - converts a string JSON to JS object
    // console.log(employee); // for testing

    function displayUserProfile(){
                     let userForm   =  `<div class="container">
                                <form>
                                    <div class="mb-3 mt-3">
                                        <label for="FirstName" class="form-label">Firstname:</label>
                                        <input type="text" class="form-control" id="Firstname" placeholder="First Name" name="firstName">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="LastName" class="form-label">Lastname:</label>
                                        <input type="text" class="form-control" id="Lastname" placeholder="Last Name" name="lastName">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="Email" class="form-label">Email</label>
                                        <input type="text" class="form-control" id="Email" placeholder="Email" name="email">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="Username" class="form-label">Username:</label>
                                        <input type="text" class="form-control" id="Username" placeholder="username" name="userName">
                                    </div>
                                      <button type="button" class="btn btn-primary" onclick="updateProfile()">Update Profile</button>
                                </form>
                            </div>`;
                    document.getElementById("content").innerHTML = userForm;
    }

function displayReimbursementForm(){
    let reimbursementForm = `<div class="container">
                       <form id="someId">
                           <div class="mb-3 mt-3">
                               <label for="eID" class="form-label">Employee ID:</label>
                               <input type="text" class="form-control" id="eID" placeholder="Enter employee Id" name="employeeId">
                           </div>
                           <div class="mb-3 mt-3">
                               <label for="mID" class="form-label">Manager ID:</label>
                               <input type="text" class="form-control" id="mID" placeholder="Enter manager Id" name="managerId">
                           </div>
                           <div class="mb-3 mt-3">
                               <label for="amount" class="form-label">Amount</label>
                               <input type="text" class="form-control" id="amount" placeholder="Amount" name="amount">
                           </div>
                           <div class="mb-3 mt-3">
                               <label for="reason" class="form-label">Reason:</label>
                               <input type="text" class="form-control" id="reason" placeholder="Reason" name="Reason">
                           </div>
                           <button type="button" class="btn btn-primary" onclick="submitRequest()">Submit Request</button>
                       </form>
                   </div>
                   `;
   document.getElementById("content").innerHTML = reimbursementForm;


}

function viewReimbursement(){

            let viewForm   =  `<div class="container">
                                <form>
                                    <div class="mb-3 mt-3">
                                        <label for="Enter Your Employee ID" class="form-label">Employee ID:</label>
                                        <input type="text" class="form-control" id="eID" placeholder="Employee ID" name="employeeId">
                                    </div>
                                    <button type="button" class="btn btn-primary" onclick="viewMyReimbursement()">View My Reimbursement Details</button>
                                </form>
                            </div>`;
        
                    document.getElementById("content").innerHTML = viewForm;

}
                    // fetch("http://localhost:7474/reimbursement/")
                    // .then(response => response.json())
                    // .then(responseJson => 
        
    
    
function submitRequest(){

   // construct a java script object whose properties match the bookpojo object's properties
       // of the back end application
   
       let submitRequest = {
       reimbursementId: 0,
       employeeId: document.getElementById("eID").value,
       managerId: document.getElementById("mID").value,
       status: 0,
       amount: document.getElementById("amount").value,
       reason: document.getElementById("reason").value,
   }
   fetch("http://localhost:7474/reimbursement", {
       method: 'post',
       body: JSON.stringify(submitRequest) // converts JS object to JSON 
   })

}

function updateProfile(){

    // construct a java script object whose properties match the bookpojo object's properties
        // of the back end application
    let updateRequest = {
        
        firstName: document.getElementById("Firstname").value,
        lastName: document.getElementById("Lastname").value,
        email: document.getElementById("Email").value,
        userName: document.getElementById("Username").value,
    }
    fetch("http://localhost:7474/updateProfile", {
        method: 'post',
        body: JSON.stringify(updateRequest) // converts JS object to JSON 
    })
 
 }

 function viewMyReimbursement(eID){
    fetch("http://localhost:7474/reimbursement/"+eID)
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson)
        let reimbursementTableData = `<table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Reimbursement Id</th>
                            <th>Employee Id</th>
                            <th>Status</th>
                            <th>amount</th>
                            <th>reason</th>
                        </tr>
                        </thead>
                        <tbody>`;
        for(let reimbursement of responseJson){
            reimbursementTableData += `<tr>
                                <td>${reimbursement.reimbursementId}</td>
                                <td>${reimbursement.employeeId}</td>
                                <td>${reimbursement.status}</td>
                                <td>${reimbursement.amount}</td>
                                <td>${reimbursement.reason}</td>
                               </tr>`;
        }
        reimbursementTableData += `</tbody></table>`;
        document.getElementById("content").innerHTML = reimbursementTableData
    })
    .catch(error => console.log(error));
    }