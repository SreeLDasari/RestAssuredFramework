package com.Student.requests;

import java.util.ArrayList;
import java.util.List;

import com.Student.POJO.StudentPOJO;
import com.Student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestFactory extends TestBase{

	
	RestClient restClient=new RestClient();
	public Response getAllStudents() {

		Response response=restClient.doGetReq("/list");
		return response;
		
	}
	public Response createNewStudent(String uri,String fname,String lname,String email,
										String programme,List<String> course) {
		StudentPOJO body=new StudentPOJO();
		body.setFirstName(fname);
		body.setLastName(lname);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(course);
		
		Response res=restClient.doPostreq(uri, body);
		return res;
	}
	
}
