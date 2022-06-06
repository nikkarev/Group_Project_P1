//New User Registration

function register(){
    //event.preventDefault();

    let registerUser = {
        //employeeId: 0,
        firstName: document.getElementById("fname").value,
        lastName: document.getElementById("lname").value,
        email: document.getElementById("email").value,
        userName: document.getElementById("userName").value,
        password: document.getElementById("password").value,
        managerId: document.getElementById("managerID").value,
        managerType: document.getElementById("managerType").value,
    }  
    fetch("http://localhost:7474/employees/register", {
        method: 'post',
        body: JSON.stringify(registerUser) // converts JS object to JSON 
    })
    .then(response => response.json())
    //.then(sessionStorage.setItem('currentUser',jsonResponse.employeeId))
    .then(jsonResponse =>
        {
    if (jsonResponse.employeeId != 0){
        window.location.replace("/Login.html");
    }
});
}