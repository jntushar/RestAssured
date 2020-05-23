import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Tests_POST {

	@Test
	public void test_01() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Tushar");
		map.put("job", "Intern");
		
		System.out.println(map);
		
		//JSONObject request = new JSONObject(map);
		JSONObject request = new JSONObject();
		request.put("name", "Tushar");
		request.put("job", "Intern");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}
}
