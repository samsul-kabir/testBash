package room;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateThousandBooking {
	protected static Response response;
	protected static RequestSpecification request;

	@Test
	public void createThousand() {
		RestAssured.baseURI = "http://localhost:8080/";
		request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();

		JSONObject chechDate = new JSONObject();
		int month = 1;
		int day = 1;
		int roomId = 1;

		for (int i = 0; i < 1000; i++) {
			chechDate.put("checkin", "2019-" + month + "-" + day + "T11:59:29.215Z");
			chechDate.put("checkout", "2019-" + month + "-" + day + "T11:59:29.215Z");
			requestParams.put("bookingdates", chechDate);

			requestParams.put("bookingid", 0);
			requestParams.put("depositpaid", true);
			requestParams.put("email", "s"+i+"@gmail.com");
			requestParams.put("firstname", "sams" + i);
			requestParams.put("lastname", "kabir" + i);
			requestParams.put("phone", "44000234234234");
			requestParams.put("roomid", roomId);

			request.body(requestParams.toString());
			Response response = request.get("booking/");

			int statusCode = response.getStatusCode();
			
			day++;
			if(day==28) {
				month++;
				day=1;
			}
			
			if(month==12) {
				roomId++;
				month=1;
			}
			
			System.out.println("Day: " + day + "Month: " + month);		
			System.out.println("The status code recieved: " + statusCode + "for api number: " + i);
		}

	}
}
