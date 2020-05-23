import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Tests_PATCH {

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
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200).log().all();
	}
}
