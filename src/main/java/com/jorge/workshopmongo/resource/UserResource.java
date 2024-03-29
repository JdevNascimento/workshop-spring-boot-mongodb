package com.jorge.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.workshopmongo.domain.User;
import com.jorge.workshopmongo.dto.UserDTO;
import com.jorge.workshopmongo.repository.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserRepository service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}

}
