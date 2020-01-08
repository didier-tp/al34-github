package fr.afcepf.al34.ws.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.ws.dto.LoginRequest;
import fr.afcepf.al34.ws.dto.LoginResponse;

@RestController
@RequestMapping(value="/devise-api/public/login" , headers="Accept=application/json")
public class LoginRestCtrl {
	

	//http://localhost:8080/springBootWs/devise-api/public/login
	//avec { "username" : "user1" , "password" : "pwd1" }
	//en retour { "message" :  "..." , "token" ; "..." , ...}
	@PostMapping("")
	public ResponseEntity<LoginResponse> postLogin(@RequestBody LoginRequest loginRequest){
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUsername(loginRequest.getUsername());
		if(loginRequest.getUsername().equals("user1") && 
				loginRequest.getPassword().equals("pwd1")) {
			loginResponse.setOk(true);
			loginResponse.setMessage("successful login");
			loginResponse.setToken("jeton_qui_va_bien");
		}else {
			loginResponse.setOk(false);
			loginResponse.setMessage("login failed");
			return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.OK);
	}

}
