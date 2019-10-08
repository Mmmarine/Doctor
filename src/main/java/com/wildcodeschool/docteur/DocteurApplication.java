
package com.wildcodeschool.docteur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DocteurApplication {


	public static void main(String[] args) {

		SpringApplication.run(DocteurApplication.class, args);
	}

	@RequestMapping("/doctor/{number}")
	@ResponseBody

	public String doctor(@PathVariable int number) {
		if (number == 13) {
			return "number : " + number + " name : Jodie Whittaker";
		} else if (number == 12) {
			return "number : " + number + " name : Peter Capaldi";
		} else if (number == 11) {
			return "number : " + number + " name : Matt Smith";
		} else if (number == 10) {
			return "number : " + number + " name : David Tennant";
		} else if (number == 9) {
			return "number : " + number + " name : Christopher Eccleston";
		} else if (number <= 0 || number > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number + ".");
		} else {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER);
		}
	}
}