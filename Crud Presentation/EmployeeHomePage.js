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

    fetch("http://localhost:7474/books")
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

