
function displayReimbursementForm(){
    let reimbursementForm = `<div class="container">
                       <form id="empFormSubmit">
                           <div class="mb-3 mt-3">
                               <label for="eID" class="form-label">Employee ID:</label>
                               <input type="text" class="form-control" id="eID"  name="employeeId">
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
   var empId = sessionStorage.getItem('currentUser');
   document.getElementById("eID").value=empId;
   
}

function submitRequest(){

       var empId = sessionStorage.getItem('currentUser');

       let submitRequest = {
       reimbursementId: 0,
       employeeId: document.getElementById("eID").value=empId,
       managerId: document.getElementById("mID").value,
       status: 0,
       amount: document.getElementById("amount").value,
       reason: document.getElementById("reason").value,
   }
   fetch("http://localhost:7474/reimbursement", {
       method: 'post',
       body: JSON.stringify(submitRequest) // converts JS object to JSON 
   })
   document.getElementById("empFormSubmit").reset();

}


 function displayEmployeeRequest(){
    var eID = sessionStorage.getItem('currentUser');
    fetch("http://localhost:7474/reimbursement/"+eID)
    .then(response => response.json())
    .then(responseJson => {


        let requestTableData = ` <table class = "table table-striped">
                                    <thead> 
                                    <tr>
                                        <th>Reimbursement Id</th>
                                        <th>Status</th>
                                        <th>Amount</th>
                                        <th>Reason</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    `;
        for (let reimbursement of responseJson) {
            requestTableData += ` <tr>
                                    <td>${reimbursement.reimbursementId}</td>
                                    <td>${reimbursement.status}</td>
                                    <td>${reimbursement.amount}</td>
                                    <td>${reimbursement.reason}</td>
                                    </tr>`;
        }
        requestTableData += `</tbody></table>`;
        document.getElementById("content").innerHTML = requestTableData;
    })
    .catch(error => console.log(error));
}
 


                function displayUserProfile(){

                    var eID = sessionStorage.getItem('currentUser');
                    var firstName = sessionStorage.getItem('currentfName');
                    var lastName = sessionStorage.getItem('currentlName');
                    var email = sessionStorage.getItem('currentemail');
                    var userName = sessionStorage.getItem('currentuName');

                    fetch("http://localhost:7474/employees/"+eID)
                    .then(response => response.json())
                    .then(responseJson => {

                        let userForm   =  `<div class="container">
                                <form>
                                    <div class="mb-3 mt-3">
                                    <label for="eID" class="form-label">Employee ID:</label>
                                    <input type="text" class="form-control" style="width:400px" id="empID"  name="employeeId">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="FirstName" class="form-label">Firstname:</label>
                                        <input type="text" class="form-control" style="width:400px" id="Firstname" placeholder="First Name" name="firstName">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="LastName" class="form-label">Lastname:</label>
                                        <input type="text" class="form-control" style="width:400px" id="Lastname" placeholder="Last Name" name="lastName">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="Email" class="form-label">Email</label>
                                        <input type="text" class="form-control" style="width:400px" id="Email" placeholder="Email" name="email">
                                    </div>
                                    <div class="mb-3 mt-3">
                                        <label for="Username" class="form-label">Username:</label>
                                        <input type="text" class="form-control" style="width:400px" id="Username" placeholder="username" name="userName"> 
                                    </div>
                                        <button type="button" class="btn btn-primary" onclick="updateProfile()">Update Profile</button>
                                </form>
                            </div>`;

                        
                    document.getElementById("content").innerHTML = userForm;
                    document.getElementById("Firstname").value=firstName;
                    document.getElementById("Lastname").value=lastName;
                    document.getElementById("Email").value=email;
                    document.getElementById("Username").value=userName;
                    })
                }


                function updateProfile(){

                    var empId = sessionStorage.getItem('currentUser');  
                    let updateRequest = {
                        employeeId: document.getElementById("empID").value=empId,
                        firstName: document.getElementById("Firstname").value,
                        lastName: document.getElementById("Lastname").value,
                        email: document.getElementById("Email").value,
                        userName: document.getElementById("Username").value,
                    }
                    fetch("http://localhost:7474/employees/profile", {
                        method: 'post',
                        body: JSON.stringify(updateRequest) // converts JS object to JSON 
                    })
                    
                 }

                 function clearSession(){
                    sessionStorage.clear;
                 }