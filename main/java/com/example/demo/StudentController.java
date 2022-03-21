package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class StudentController {
	@Autowired
	StudentRepository sr;
	@PostMapping(path="/students",consumes={MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Student> createStudent(@RequestBody Student s) {
		sr.save(s);
		return sr.findAll();
	}
	
	@GetMapping(path="/students",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Student> readStudent(){
		return sr.findAll();
	}
	@GetMapping(path="/students/{id}")
	public Optional<Student> readStudent(@PathVariable int id){
		return sr.findById(id);
	}
	@PutMapping(path="/students/{id}",produces= {MediaType.APPLICATION_XML_VALUE})
	 public Optional<Student> updateStudent(@PathVariable int id,@RequestBody Student stu) {
			sr.save(stu);
			return sr.findById(id);
	}
	@DeleteMapping(path="/students/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public Optional<Student> deleteStudents(@PathVariable int id) {
		Optional<Student> ab=null;
		ab=sr.findById(id);
		sr.deleteById(id);
		return ab;
	}
	@DeleteMapping(path="/students")
	public String deleteAll() {
		sr.deleteAll();
		return "All users deleted";
	}
}
