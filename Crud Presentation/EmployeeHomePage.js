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

   // construct a java script object whose properties match the bookpojo object's properties
       // of the back end application
       var empId = sessionStorage.getItem('currentUser');

       let submitRequest = {
       reimbursementId: 0,
       employeeId: document.getElementById("eID").value=empId ,
       //employeeId: JSON.parse(sessionStorage.getItem('currentUser')),
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