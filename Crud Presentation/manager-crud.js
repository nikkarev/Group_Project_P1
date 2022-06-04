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
                                        <th for="rID">Reimbursement Id</th>
                                        <th for="eID">Employee Id</th>
                                        <th for="mID">Manager Id</th>
                                        <th for="status">Status</th>
                                        <th for="amount">Amount</th>
                                        <th for="reason">Reason</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    `;
        for (let reimbursement of responseJson) {
            reimbursementTableData += ` <tr>
                                    <td id="rID">${reimbursement.reimbursementId}</td>
                                    <td id="eID">${reimbursement.employeeId}</td>
                                    <td id="mID">${reimbursement.managerId}</td>
                                    <td id="status">${reimbursement.status}</td>
                                    <td id="amount">${reimbursement.amount}</td>
                                    <td id="reason">${reimbursement.reason}</td>
                                    <td><button 
                                            type="button" 
                                            class="btn btn-success"
                                            onclick="approveRequestStatus(${reimbursement.reimbursementId})">Approve</button></td>
                                    <td><button 
                                            type="button" 
                                            class="btn btn-danger"
                                            onclick="denyRequestStatus(${reimbursement.reimbursementId})">Deny</button></td>
                                    </tr>`;
        }
        reimbursementTableData += `</tbody></table>`;
        document.getElementById("content").innerHTML = reimbursementTableData;
    })
    .catch(error => console.log(error));
}

function approveRequestStatus(reimbursementId, employeeId, managerId, amount, reason){
    
        let approveRequest = {
            reimbursementId,
            employeeId,
            managerId,
            status: "Approve",
            amount,
            reason,
            
        };
    console.log(approveRequest);
    fetch("http://localhost:7474/reimbursement/approve", {
        method: 'post',
        body: JSON.stringify(approveRequest) // converts JS object to JSON 
    }).then(response => {
        console.log(response);
        viewAllRequests();
    });
 
};

function denyRequestStatus(reimbursementId, employeeId, managerId, amount, reason){
    
    let approveRequest = {
        reimbursementId,
        employeeId,
        managerId,
        status: "Deny",
        amount,
        reason,
        
    };
console.log(approveRequest);
fetch("http://localhost:7474/reimbursement/approve", {
    method: 'post',
    body: JSON.stringify(approveRequest) // converts JS object to JSON 
}).then(response => {
    console.log(response);
    viewAllRequests();
});

};

function displayReimbursementsForEmployee(){
    let employeeIdForm = `<div class="container">
                       <form>
                            <div class="mb-3 mt-3">
                               <label for="eID" class="form-label">Employee ID:</label>
                               <input type="text" class="form-control" id="eID" placeholder="Enter employee Id" name="employeeId">
                            </div>
                            <button type="button" class="btn btn-primary" onclick="displayEmployeeRequest(document.getElementById('eID').value)">Submit</button>
                        </form>
                    </div>
                           `;
    document.getElementById("content").innerHTML = employeeIdForm;
}

function displayEmployeeRequest(eID){
    fetch("http://localhost:7474/reimbursement/"+eID)
    .then(response => response.json())
    .then(responseJson => {

        let requestTableData = ` <table class = "table table-striped">
                                    <thead> 
                                    <tr>
                                        <th>Reimbursement Id</th>
                                        <th>Employee Id</th>
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
                                    <td>${reimbursement.employeeId}</td>
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
