package com.springrest.springrest.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Courses;

@Service
public class CourseServicesImpl implements CourseService {
 
	ArrayList<Courses> list;
	
	public CourseServicesImpl()
	{
		list=new ArrayList<>();
		list.add(new Courses(1225,"Core Java","Basics of Java"));
		list.add(new Courses(1144,"Spring Boot","Building web app using spring boot"));
	}

	@Override
	public ArrayList<Courses> getCourses() {
		return list;
	}

	@Override
	public Courses getCourseById(long courseId) {
		Courses cs=null;
		for(Courses c:list)
		{
			if(c.getId()==courseId) {
				cs=c;
				break;
			}
		}
		return cs;
	}

	@Override
	public Courses addCourse(Courses course) {
		if(course !=null)
			list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		for(Courses c:list)
		{
			if(c.getId()== course.getId()) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
			}
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		for(Courses c:list)
		{
			if(c.getId()==courseId)
			{
				list.remove(c);
			}
		}
	}
}
	


