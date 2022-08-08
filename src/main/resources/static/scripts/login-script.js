function verifyInputs(){
	var array_inputs = document.getElementsByClassName("field");
	var is_valid = true;
	
	Array.from(array_inputs).forEach(input => {
		if(input.value == ""){
			input.classList.add("is-invalid");
			is_valid = false;
		}else{
			input.classList.remove("is-invalid");
		}
	});
	
	return is_valid;
}
