//here contains javascript functions that will consume endpoints
function printData(){
    document.write("Data printed on the document...")
    console.log("data printed on the console...")
}
function getAllEmployees(){
fetch("http://localhost:7474/employees")
.then(response => response.json())
.then(responseJson => {
    console.log(responseJson)
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

// continues with code here if we had any
}