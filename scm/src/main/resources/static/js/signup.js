function signup_validate() {
    var fullname = document.getElementById('fullname').value;
    // var fullNameRE=/^[A-Za-z]+$/;
    var email = document.getElementById('email').value;
    var emailRE = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var password = document.getElementById('password').value;
    var pwdRE = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,25}$/;
    var confirm_password = document.getElementById('confirm_password').value;
    var x = 0;

    // If all the fields are empty 
    if (fullname == "" && email == "" && password == "" && confirm_password == "") {
		document.getElementById("msg").innerHTML = "Fields are missing!";
		return false;
	} else {
		document.getElementById("msg").innerHTML = "";
	}

    // fullname validation
    if(fullname == ""){
        document.getElementById("fn").innerHTML = "*please enter fullname";
		//return false;
		x = 1;
    } else if(fullname.length < 5){
        document.getElementById("fn").innerHTML = "fullname must be 5 characters long, try again!";
        //return false;
        x = 1;
    } else{
        document.getElementById("fn").innerHTML = "";
    }

    // email validation 
    if (email == "") {
		document.getElementById("mail").innerHTML = "Please Enter Email!";
		//return false;
		x = 1;
	} else if (!emailRE.test(email)) {
	    document.getElementById("mail").innerHTML = "Please enter valid email address!";
		//return false;
		x = 1;
	} else {
		document.getElementById("mail").innerHTML = "";
	}

    // password validation
    if(password == ""){
        document.getElementById("pwd").innerHTML = "Please enter password!";
        //return false;
        x = 1;
    } else if(!pwdRE.test(password)){
        document.getElementById("pwd").innerHTML = "Contain atleast one number & special character";
        //return false;
        x = 1;
    } else{
        document.getElementById("pwd").innerHTML = "";
    }

    // confirm password validation 
    if (confirm_password == "") {
		document.getElementById("cpwd").innerHTML = "Please confirm password!";
		//return false;
		x = 1;
	}
	else if (password != confirm_password) {
		document.getElementById("cpwd").innerHTML = "Password not matched!";
		//return false;
		x = 1;
	} else {
		document.getElementById("cpwd").innerHTML = "";
	}
    if(x ==  1){ return false; }
    else{
        alert("Your account created successfully! Welcome to SCMXPertLite!");
        return true;
    }
}

/*
// function to validate email address 
function ValidateEmail(inputText) {
    var mailRE = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!inputText.value.match(mailRE)) {
    	document.getElementById("mail").innerHTML = "Invalid email address!";
    	return false;
    }
}
*/

