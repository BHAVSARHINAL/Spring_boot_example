package com.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.ApiResponse;
import com.api.entity.Person;
import com.api.service.PersonService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	ApiResponse api = new ApiResponse();

	@PostMapping("/createid")
	public ResponseEntity<ApiResponse> postMethodName(@Valid @RequestBody Person per, BindingResult bs) {
		if (bs.hasErrors()) {
			api.setMsg("Bad request");
			api.setStatus(400);

			Map<String, String> map = new HashMap<String, String>();
			bs.getFieldErrors().forEach((fieldError) -> {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
				// System.out.println(map);
			});
			api.setData(map);
			return ResponseEntity.badRequest().body(api);
		} else {
			api.setMsg("Record inserted sucesfully");
			api.setStatus(200);
			per.setCreateDate(new Date());
			Person p = service.Create(per);
			api.setData(p);
			return ResponseEntity.ok(api);
		}
	}

	@GetMapping("/get")
	public ResponseEntity<?> getpersonDetails() {
		api.setMsg("Fetch All record sucessfully");
		api.setStatus(200);

		List<Person> pe = (List<Person>) service.getPerson();
		api.setData(pe);
		return ResponseEntity.ok(api);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ApiResponse> updatepersonDetails(@Valid @PathVariable("id") int id,
			@RequestBody Person person, BindingResult br) {
		if (br.hasErrors()) {
			api.setStatus(400);
			api.setMsg("Bad request");
			Map<String, String> map = new HashMap<String, String>();
			br.getFieldErrors().forEach((fieldError) -> {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			});

			api.setData(map);
			return ResponseEntity.badRequest().body(api);
		} else {
			api.setMsg("Record updated sucessfully");
			api.setStatus(200);
			person.setId(id);
			person.setUpdateDate(new Date());
			Person pr = service.updatePerson(person);
			api.setData(pr);
			return ResponseEntity.ok(api);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> detelePerson(@Valid @PathVariable("id") int id,Person per){
		api.setMsg("Delete recoed sucessfully");
		api.setStatus(200);
		 service.deletePerson(id);
		return ResponseEntity.ok(api);
	}
	
}
