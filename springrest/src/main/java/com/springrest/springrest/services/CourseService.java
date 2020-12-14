package com.springrest.springrest.services;

import java.util.ArrayList;

import com.springrest.springrest.entities.Courses;

public interface CourseService {
	
	public ArrayList<Courses> getCourses();
	public Courses getCourseById(long courseId);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course);
	public void deleteCourse(long courseId);
	

}
