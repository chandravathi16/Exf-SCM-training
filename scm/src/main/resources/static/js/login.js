function signin_validate() {
    let email = document.getElementById('email').value;
    const emailRE = /^\w+([.,-]?\w+)*@\w+([.,-]?\w+)*(\.\w{2,3})+$/;
    let password = document.getElementById('password').value;
    let pwdRE = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,25}$/;
    let submit_captcha = document.getElementById('submit_captcha').value;
    let x = 0;

    if (email === "" && password === "") {
		document.getElementById("msg").innerHTML = "Fields are Missing!";
		return false;
	} else{
	    document.getElementById('msg').innerHTML = "";
	}

    // email validation
    if (email === "") {
		document.getElementById("mailid").innerHTML = "Please Enter Email!";
		//return false;
		x = 1;
	} else if (!emailRE.test(email)) {
	    document.getElementById("mailid").innerHTML = "Please enter valid email address!";
		//return false;
		x = 1;
	} else {
		document.getElementById("mailid").innerHTML = "";
	}

    // password validation
    if(password === ""){
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


    // captcha validation
    if(submit_captcha === ""){
        document.getElementById("captcha").innerHTML = "*please enter captcha!";
        x = 1;
    } else if(submit_captcha !== captcha_image.innerHTML) {
    	document.getElementById("captcha").innerHTML = "Captha Not Matched!";
    	//display_captcha();
    	x = 1;
    }
    else{
        document.getElementById("captcha").innerHTML = "";
    }

    if(x === 1){ return false; }
    else{
        alert("Welcome to SCMXPertLite!");
        return true;
    }
}

// captcha generation - if refresh happen
function display_captcha() {
	document.getElementById("submit_captcha").value = "";
    let captcha = document.getElementById("captcha_image");
    let unique_char = "";
    // captcha includes some random letters either capital/small and numbers
	const random_char = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	// length of captcha is 6, with random characters/numbers
	for (let i = 1; i < 7; i++) {
		unique_char += random_char.charAt(Math.random() * random_char.length)
	}
	// generated captcha = unique char
	captcha.innerHTML = unique_char;
}
