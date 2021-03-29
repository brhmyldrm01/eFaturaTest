package com.project.efaturatest.Controller;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.efaturatest.Data.UserDataRepository;
import com.project.efaturatest.Entities.ErrorClass;
import com.project.efaturatest.Entities.Success;
import com.project.efaturatest.Entities.User;

@RestController
@RequestMapping("user")
public class RegistrationController {

	@Autowired
	UserDataRepository repository;
	
	
	
	@RequestMapping("/")
	public String user(){
		return"register->/user/register \n login->/user/login ";
	}
	
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestParam("tckn_vkn")String tckn_vkn ,
									@RequestParam("email") String email,
									@RequestParam("username") String username,
									@RequestParam("password") String password) {
		
		
		User user=new User(tckn_vkn,email,username,password);
		int isExists=repository.isExists(email);
		
		if(isExists>0) {
			ErrorClass error=new ErrorClass(HttpStatus.CONFLICT.value(),"Girdiğiniz E-mail adresi zaten kayıtlı.");
			return  ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(error);
		}
		else {
			repository.save(user);
			Success success=new Success(HttpStatus.OK.value(), "Kayıt Başarılı. Giriş Yapabilirsiniz.");
			return  ResponseEntity
					.status(HttpStatus.OK)
					.body(success);
		}
	
	}
	
	
	
}
