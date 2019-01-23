package W2A;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupMethod {

	public static void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		
	}
}
