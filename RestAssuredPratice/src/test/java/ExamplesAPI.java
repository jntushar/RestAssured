import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ExamplesAPI {
	
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		given().
			params("name", "Automation").
			get("/subjects").
		then().
			statusCode(200).
			and().log().all();
	}
	
	@Test
	public void test_post() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Vivek");
		request.put("lastName", "Parihar");
		request.put("sunjectId", "1");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
	
	@Test
	public void test_patch() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();		
		request.put("lastName", "Mathur");
				
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/104").
		then().
			statusCode(200).
			log().all();
	}

	
	@Test
	public void test_put(){
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Abhilash");
		request.put("lastName", "Sharma");
		request.put("sunjectId", "1");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/104").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/104").
		then().
			statusCode(200);
	}
}


