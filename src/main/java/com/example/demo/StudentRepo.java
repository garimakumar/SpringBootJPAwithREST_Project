package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepo extends JpaRepository<Student,Integer>{
                                                //<Pojo,Datatype of id i.e primary key>
	
	
	/*If we want to write our own set of queries and
	 *we want to get findbyname method(which is not there in the JPA repository)
	 * so we can create our own method findbyname ---->Here we use JPQL Java Persistance query language
	 */
	
	@Query("select student from Student student where student.name=?1" )
	public List<Student> findbyname(String name); 
	
}
