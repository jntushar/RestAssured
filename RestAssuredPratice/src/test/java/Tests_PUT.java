import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Tests_PUT {
	
	@Test
	public void test_01() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Tushar");
		request.put("job", "Intern");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).log().all();
	}

}
