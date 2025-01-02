import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
private final String apiUrl;
private JSONObject weatherData;

public Weather(String city) {
	String apiKey = "<APIKEY>";
	this.apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
	this.weatherData = null;
}

private void weatherQuery() throws IOException {
	URL url = new URL(this.apiUrl);
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	connection.setRequestMethod("GET");
	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	StringBuilder response = new StringBuilder();
	String line;
	while ((line = reader.readLine()) != null) {
		response.append(line);
	}
	reader.close();
	this.weatherData = new JSONObject(response.toString());
}

public double getTemp() {
	try {
		weatherQuery();
		JSONObject main = this.weatherData.getJSONObject("main");
		return main.getDouble("temp");
	} catch (Exception e) {
		//e.printStackTrace();
		System.out.print("City not found ");
	}
	return 0;
}


public String getCondition() {
	try {

		weatherQuery();
		JSONObject weather = this.weatherData.getJSONArray("weather").getJSONObject(0);
		return weather.getString("description");
	} catch (Exception e) {
		//e.printStackTrace();
		System.out.println("- Outputting filler data.");
	}
	return null;
}
}
