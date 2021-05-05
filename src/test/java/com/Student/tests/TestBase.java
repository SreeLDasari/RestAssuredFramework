package com.Student.tests;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.Student.util.PropertyReader;

import io.restassured.RestAssured;

public class TestBase {
	public static PropertyReader prop;
	
	@Rule
	public TestRule Listener=new TestWatcher() {
		@Override
		protected void succeeded(Description desc) {
			
			System.out.println(desc.getMethodName().toUpperCase());
			
		}
		protected void failed(Throwable e,Description des) {
			
			System.out.println("-----Failed-------");
			System.out.println(des.getMethodName().toUpperCase());

		}
	};
	@BeforeClass
	public static void initUrl() throws NumberFormatException, IOException {
		prop=PropertyReader.getInstance();
		RestAssured.baseURI=prop.getProperty("baseUrl");
		RestAssured.port=Integer.valueOf((prop.getProperty("port")));
	}

}
