package demo;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class DataDrivenExample extends DataForTests{
	
	

	//@Test(dataProvider = "DataForPost")
	public void test_post(String fname, String lname, int subId) {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", fname);
		request.put("lastName", lname);
		request.put("sunjectId", subId);
		
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
	

	
	@Test(dataProvider = "DataForDelete")
	public void test_delete(int userId) {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userId).
		then().
			statusCode(200);
	}
	
	@Parameters({"userId"})
	@Test()
	public void test_delete2(int userId) {
		
		System.out.println("Value for userId is : " + userId);
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userId).
		then().
			statusCode(200);
	}
}
