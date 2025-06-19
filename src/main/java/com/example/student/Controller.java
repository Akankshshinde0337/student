package com.example.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/getStudentInfo/{id}")
	public String getStudentinfo(int id) {
		

		return "Amisha dhande";
	}
	
}
