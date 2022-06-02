function login(){

}

function auth(event) {
    event.preventDefault();

    //construct the object to be sent in the request body
    let loginUser = {
        email: document.getElementById("email").value,
        password:  document.getElementById("password").value
    }

    // use fetch api to consume the endpoint for login validation
    fetch("http://localhost:7474/employees/login", {
        method: 'post',
        body: JSON.stringify(loginUser)
    }).then(response => response.json())
    .then(jsonResponse =>
        {

    if (jsonResponse.employeeId == 0){
        alert("Invalid information");
        return;
    } else if(jsonResponse.employeeId != 0 && jsonResponse.managerType == true){
        window.location.replace("/Crud%20Presentation/ManagerHome.html");
    }
      else{
        window.location.replace("/Crud%20Presentation/EmployeeHomePage.html");
    }
});

    // fetch("expense-reimbursement-system.cvjcx3y0oyxm.ca-central-1.rds.amazonaws.com/ers")
    //     .then(response => response.json())
    //     .then(responseJson => {

    //         var email = document.getElementById("email").value;
    //         var password = document.getElementById("password").value;

    //         if (email ===  && password === "user") {
    //             window.location.replace("/upload.html");
    //        } else {
    //            alert("Invalid information");
    //            return;
    //        }

    //     })
    //    .catch(error => console.log(error));  
}