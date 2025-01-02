import java.util.Scanner;

public class UI {

public void start() {
	Scanner input = new Scanner(System.in);
	while (true) {
		System.out.println("What city would you like to see? for common names enter a common and two digit country. IE; London,CA");
		String entry = input.nextLine();
		String city = entry.replace(' ', '+');
		if (city.isEmpty()) {
			break;
		}

		Weather weather = new Weather(city);
		TempConversion tc = new TempConversion();
		double temp = weather.getTemp();

		//TODO: Reimplement the conversion to Celsius?
		//System.out.println("What UOM would you like to see? C/F");
		//String uom = input.nextLine();
		//if(uom.equalsIgnoreCase("C")) {
		//	System.out.println("Current temperature in " + city + ": " + tc.ktoC(temp) + "°C");
		//} else if (uom.equalsIgnoreCase("F")) {
		System.out.println("The Current temperature in " + city + " is " + tc.ktoF(temp) + "°F, and they are experiencing " + weather.getCondition() + ".");
		System.out.println(" ");
		//} else if (uom.equalsIgnoreCase("end")) {
		//	break;
		//} else {
		//	System.out.println("Invalid UOM");
	}
}
}
