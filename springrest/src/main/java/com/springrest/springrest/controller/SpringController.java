package com.springrest.springrest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class SpringController {
	
	@Autowired
	CourseService courseService;
	
	//get the courses
	@GetMapping("/courses")
	public ArrayList<Courses> getCourses(){
		return this.courseService.getCourses();
	}
	
	//get course by Id
	@GetMapping("/courses/{courseId}")
	public Courses getCourseById(@PathVariable String courseId){
		return this.courseService.getCourseById(Long.parseLong(courseId));
	}
	
	//add new Course
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
	}
	 
	//update course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course){
		return this.courseService.updateCourse(course);
	}
	
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
}
	
	
	
	
