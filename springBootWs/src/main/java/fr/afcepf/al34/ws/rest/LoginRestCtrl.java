package fr.afcepf.al34.ws.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/devise-api/public/login" , headers="Accept=application/json")
public class LoginRestCtrl {
	
	//coder une chose qui va verifier username,password
	//et retourner "message" + "token" + ...

}
