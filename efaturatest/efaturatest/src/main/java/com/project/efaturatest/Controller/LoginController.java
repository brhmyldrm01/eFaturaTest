package com.project.efaturatest.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.efaturatest.Data.UserDataRepository;
import com.project.efaturatest.Entities.ErrorClass;
import com.project.efaturatest.Entities.Success;
import com.project.efaturatest.Entities.User;

@RestController
@RequestMapping("user")
public class LoginController {



	@Autowired
	UserDataRepository repository;
	
		
	@PostMapping("/login")
	 public ResponseEntity login(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		User user=repository.findByEmail(email);
		int isexists=repository.isExists(email);
		
		if(isexists>0 && user.getUser_password().equals(password)) {
			
			 HttpHeaders headers = new HttpHeaders();
			List<Object> list =new ArrayList<Object>();
		
			 String token=encode(email, password);
			 Success success=new Success(HttpStatus.OK.value(),"Giriş Başarılı."); 
			 list.add(user);
			 list.add(success);
			 
		     headers.add(HttpHeaders.AUTHORIZATION, token);
		     
		     return ResponseEntity
		    		 .status(HttpStatus.OK)
		    		 .headers(headers)
		    		 .body(list);
		       
		}else {
			ErrorClass error=new ErrorClass(HttpStatus.UNAUTHORIZED.value(),"E-mail veya şifre hatalı.");
			return ResponseEntity
		            .status(HttpStatus.UNAUTHORIZED)
		            .body(error);
		}
	
	
	 }
		 


	public String encode(String email,String password) {
		String  auth= email + ":" + password;
		String token = Base64.getEncoder().encodeToString(auth.getBytes());
		String authHeader = "Basic " + token;
		return authHeader ;
	}
	
	 
	
	
	

}