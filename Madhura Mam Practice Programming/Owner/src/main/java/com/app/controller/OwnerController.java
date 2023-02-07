package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OwnerDTO;
import com.app.pojos.Owner;
import com.app.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
private OwnerService ownSer;
@GetMapping
private List<Owner> getAllOwners(){
	return ownSer.getAllOwner();
}

@PostMapping
public Owner addOwner1(@RequestBody Owner own) {
	return ownSer.addOwner(own);
}
@PostMapping("/login")
public void loginOwner(@RequestBody OwnerDTO dto) {
	ownSer.loginOwner(dto);
}
@DeleteMapping("/{id}")
public void deleteOwner(Long id) {
	ownSer.deleteOwner(id);
}
}
