function validateRegistration(form) {

//	alert("Welcome User Registration Validation");

	if (form.rating.value == "") {
		alert("Error: rating cannot be blank!");
		form.rating.focus();
		return false;
	}
	var e = document.getElementById("gender");
	var type = e.options[e.selectedIndex].value;
	if (type == 0) {
		alert("Please Select a gender");
		return false;
	}
	//
	var e = document.getElementById("university");
	var type = e.options[e.selectedIndex].value;
	if (type == 0) {
		alert("Please Select a university");
		return false;
	}
	var e = document.getElementById("qualification");
	var type = e.options[e.selectedIndex].value;
	if (type == 0) {
		alert("Please Select a qualification");
		return false;
	}
	

	if (form.technology.value == "") {
		alert("Error: technology cannot be blank!");
		form.technology.focus();
		return false;
	}
	if (form.total_experience.value == "") {
		alert("Error: Total Experience cannot be blank!");
		form.total_experience.focus();
		return false;
	}

	return true;
}
