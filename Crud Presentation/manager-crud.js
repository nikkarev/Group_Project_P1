//When Employees is clicked in the navbar, a get request is run to the employee table, fetching all records that arent a manager, and populates a table with their information
function getAllEmployees() {
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
            for (let employee of responseJson) {
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
//WHen Pending requests is selected from the reimbursement drop down, a get request is ran to the database, and all records in the reimbursement table with a status = pending will be retrived, populating a table with the records. Buttons for approve and deny are also added to the end of each record.
function viewAllRequests() {
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
//When resolved requests is selected from the drop down menu, a get request is ran to the database, selecting all records from the reimbursement table where the status = approve or deny, and populates a table in the content containing each record
function viewAllResolvedRequests() {
    fetch("http://localhost:7474/resolvedreimbursement")
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
                                    `;
            }
            reimbursementTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = reimbursementTableData;
        })
        .catch(error => console.log(error));
}
//When the approve button is pressed, an onclick event invokes this method, changing the status for the record in the reimbursement table in the database from pending to approve. This also removes the record from the pending reimbursements table in the window
function approveRequestStatus(reimbursementId, employeeId, managerId, amount, reason) {

    let approveRequest = {
        reimbursementId,
        employeeId,
        managerId,
        status: "Approve",
        amount,
        reason,
    };
    console.log(approveRequest);
    fetch("http://localhost:7474/reimbursement/changestatus", {
        method: 'post',
        body: JSON.stringify(approveRequest) // converts JS object to JSON 
    }).then(response => {
        console.log(response);
        viewAllRequests();
    });

};
//When the deny button is pressed, the onclick event invokes this method, changing the status for ther record in the reimbursement table in the database from pending to deny. THis also removes the record from the pending reimbursement table in the window
function denyRequestStatus(reimbursementId, employeeId, managerId, amount, reason) {

    let approveRequest = {
        reimbursementId,
        employeeId,
        managerId,
        status: "Deny",
        amount,
        reason,

    };
    console.log(approveRequest);
    fetch("http://localhost:7474/reimbursement/changestatus", {
        method: 'post',
        body: JSON.stringify(approveRequest) // converts JS object to JSON 
    }).then(response => {
        console.log(response);
        viewAllRequests();
    });

};
//When the view a employee request is selected from the dropdown in the navbar, a form populates the content of the window. This form contains a single field where your able to enter the desired employees empID
function displayReimbursementsForEmployee() {
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
//When the submit button is pressed in form, it invokes this method, creating a get request to the reimbursement table in the database. It selects all record where the empID matches what was passed in the form, and populates a table in the content with all their reimbursements
function displayEmployeeRequest(eID) {
    fetch("http://localhost:7474/reimbursement/" + eID)
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
