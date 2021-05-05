package com.Student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.Student.POJO.StudentPOJO;
import com.Student.requests.RequestFactory;
import com.github.javafaker.Faker;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
@Story("This is a CRUD testing story")
public class CrudTest extends TestBase{
	
	RequestFactory req=new RequestFactory();
	@Story("This is a CRUD testing story")
	@DisplayName("Get all student names")
	@Test
	public void getAllStudents() {

		req.getAllStudents().then().statusCode(200);
		
	}
	@Test
	public void createNewStudent() {
		Faker fake=new Faker();
		StudentPOJO ob=new StudentPOJO();
		List<String> course=new ArrayList<>();
		course.add("C");
		course.add("CPP");
		ob.setFirstName(fake.name().firstName());
		ob.setEmail(fake.internet().emailAddress());
		ob.setProgramme(fake.educator().course());
		ob.setLastName(fake.name().lastName());
		ob.setCourses(course);
		
		req.createNewStudent("", ob.getFirstName(), ob.getlastName(), ob.getEmail(), ob.getProgramme(), ob.getCourses());
	}
}
