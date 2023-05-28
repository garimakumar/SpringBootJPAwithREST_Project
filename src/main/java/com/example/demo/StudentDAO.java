package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {

@Autowired
	StudentRepo repo;


 	public Student insert(Student s) {
	return repo.save(s);
	}
	
	public List<Student> getAll() {
	return repo.findAll();
	}
	
	public void delete(int id) {
	 repo.deleteById(id);
	}
	public Student deletebyid(int id) {
	repo.deleteById(id);
	return deletebyid(id);
	}
	
	public Student update(Student s) {
	/*Go to the specific id from the student record
	 *Store the details of the particular record to the object of the database student say ss.
	 *Change the value u want to change.
	 *perform the insertion
	 *Get the results on the specific mentioned port no.(localhost).
	 * DB table: 1 garima g@c.c  ---ss
	 * changes we want : 1 prasad   ----s
	 * */	
		
		Student ss=repo.findById(s.getId()).orElse(null);
		ss.setName(s.getName());
		ss.setEmail(s.getEmail());
		return repo.save(ss);
	}
	
	public List<Student> insertall(List<Student> s) {
		return repo.saveAll(s);
	}
	public Optional<Student> getbyId(int id) {
		return repo.findById(id);
	}
	public List<Student> getbyname(String name) {
		return repo.findbyname(name);
		
	}
	
}
