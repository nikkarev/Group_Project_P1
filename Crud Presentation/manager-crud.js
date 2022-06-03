//here contains javascript functions that will consume endpoints
function printData(){
    document.write("Data printed on the document...")
    console.log("data printed on the console...")
}

function getAllEmployees(){
fetch("http://localhost:7474/employees")
.then(response => response.json())
.then(responseJson => {
    let employeeTableData = `<table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Manager Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>User Name</th>
                        <th>Password</th>
                        <th>Manager Type</th>
                    </tr>
                    </thead>
                    <tbody>`;
    for(let employee of responseJson){
        employeeTableData += `<tr>
                            <td>${employee.employeeId}</td>
                            <td>${employee.managerId}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.email}</td>
                            <td>${employee.userName}</td>
                            <td>${employee.password}</td>
                            <td>${employee.managerType}</td>
                           </tr>`;
    }
    employeeTableData += `</tbody></table>`;
    document.getElementById("content").innerHTML = employeeTableData;
})
.catch(error => console.log(error));
}

function viewAllRequests(){
    fetch("http://localhost:7474/reimbursement")
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson)
        let reimbursementTableData = ` <table class = "table table-striped">
                                    <thead> 
                                    <tr>
                                        <th>Reimbursement Id</th>
                                        <th>Employee Id</th>
                                        <th>Manager Id</th>
                                        <th>Status</th>
                                        <th>Amount</th>
                                        <th>Reason</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    `;
        for (let reimbursement of responseJson) {
            reimbursementTableData += ` <tr>
                                    <td>${reimbursement.reimbursementId}</td>
                                    <td>${reimbursement.employeeId}</td>
                                    <td>${reimbursement.managerId}</td>
                                    <td>${reimbursement.status}</td>
                                    <td>${reimbursement.amount}</td>
                                    <td>${reimbursement.reason}</td>
                                    </tr>`;
        }
        reimbursementTableData += `</tbody></table>`;
        document.getElementById("content").innerHTML = reimbursementTableData;
    })
    .catch(error => console.log(error));
}

function displayReimbursementsForEmployee(){
    let employeeIdForm = `<div class="container">
                       <form>
                            <div class="mb-3 mt-3">
                               <label for="eID" class="form-label">Employee ID:</label>
                               <input type="text" class="form-control" id="eID" placeholder="Enter employee Id" name="employeeId">
                            </div>
                            <button type="button" class="btn btn-primary" onclick="displayEmployeeRequest("eID")">Submit</button>
                        </form>
                    </div>
                           `;
    document.getElementById("content").innerHTML = employeeIdForm;
}

function displayEmployeeRequest(employeeIdRequest){
    let empId = {
        employeeId: document.getElementById("eID").value
    }
    fetch("http://localhost:7474/reimbursement/"+employeeIdRequest, {
        method: "get",
        body: JSON.stringify(empId)})
    .then(response => response.json())
    .then(responseJson => {

        let requestTableData = ` <table class = "table table-striped">
                                    <thead> 
                                    <tr>
                                        <th>Reimbursement Id</th>
                                        <th>Employee Id</th>
                                        <th>Manager Id</th>
                                        <th>Status</th>
                                        <th>Amount</th>
                                        <th>Reason</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    `;
        for (let reimbursement of responseJson) {
            requestTableData += ` <tr>
                                    <td>${reimbursement.reimbursemtextentId}</td>
                                    <td>${reimbursement.employeeId}</td>
                                    <td>${reimbursement.managerId}</td>
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