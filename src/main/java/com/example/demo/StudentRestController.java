package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	
@Autowired
	StudentDAO dao;

	
@PostMapping("/insert")
public Student insert(@RequestBody Student s) {
	return dao.insert(s);
}

@PostMapping("/insertall")
public List<Student> insertall(@RequestBody List<Student> s) {
	return dao.insertall(s);
}

@GetMapping("/getAll")
public List<Student> getAll() {
	return dao.getAll();
	}

@GetMapping("/getbyId/{id}")      //{id} is used as a PATH VARIABLE in the URL
public Student getbyId(@PathVariable("id")  int id) throws ResourceNotFoundException {
	return dao.getbyId(id).orElseThrow(()->new ResourceNotFoundException("id value is not found"));
	// Throwing a user-defined exception i.e created by user.
	//This exception will get displayed on the console
}


@PutMapping("/update")
public Student update(@RequestBody Student s) {
	return dao.update(s);
	}


@DeleteMapping("/deletebyid/{id}")
public Student deletebyid(@PathVariable("id") int id) throws Exception  {

	Student student=dao.deletebyid(id);
	if(student==null) {
		throw new DeleteNotDoneByIdException("Delete not done by id");
	}
	return student;
	
}


@GetMapping("/getbyname/{name}")
public List<Student> getbyname(@PathVariable("name") String name) throws Exception{
	List<Student> student=dao.getbyname(name);
	if(student.size()==0) {
		throw new Exception("name is not found");  //this exception will get displayed on the POSTMAN
	}
	
	return student;	
	
}

}
