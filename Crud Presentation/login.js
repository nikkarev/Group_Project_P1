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
    })
    .then(response => response.json())
    //.then(sessionStorage.setItem('currentUser',jsonResponse.employeeId))
    .then(jsonResponse =>
        {
    if (jsonResponse.employeeId == 0){
        alert("Invalid information");
        return;
    } else if(jsonResponse.employeeId != 0 && jsonResponse.managerType == true){
        sessionStorage.setItem('currentUser',jsonResponse.employeeId);
        
        window.location.replace("/ManagerHome.html");
    }
      else{
        sessionStorage.setItem('currentUser',jsonResponse.employeeId);
        sessionStorage.setItem('currentfName',jsonResponse.firstName);
        sessionStorage.setItem('currentlName',jsonResponse.lastName);
        sessionStorage.setItem('currentemail',jsonResponse.email);
        sessionStorage.setItem('currentuName',jsonResponse.userName);
        window.location.replace("/EmployeeHomePage.html");
    }
});

}
