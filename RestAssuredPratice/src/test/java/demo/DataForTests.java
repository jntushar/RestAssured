package demo;
import org.testng.annotations.DataProvider;

public class DataForTests {


	@DataProvider(name= "DataForPost")
	public Object[][] dataForPost() {

		//		Object[][] data = new Object[2][3];
		//		
		//		data[0][0] = "John";
		//		data[0][1] = "Doe";
		//		data[0][2] = 1;
		//		
		//		data[1][0] = "Joey";
		//		data[1][1] = "Walker";
		//		data[1][2] = 2;
		//		
		//		return data;

		return new Object[][] {
			{"Hitesh", "Sharma", 1},
			{"Aman", "Jain", 2}
		};
	}

	@DataProvider(name="DataForDelete")
	public Object[] dataForDelete() {
		return new Object[] {
				105,107	
		};
	}

}
