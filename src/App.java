import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		

public class App {				
    		
    public static void main(String[] args) {									
        String baseUrl = "https://www.google.com/";					
        System.setProperty("webdriver.chrome.driver","src\\drivers\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        		
        driver.get(baseUrl);					
        //click on the "Facebook" logo on the upper left portion		
			driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]")).click();					

			//verify that we are now back on Facebook's homepage		
			if (driver.getTitle().equals("Facebook - log in or sign up")) {							
            System.out.println("We are back at Facebook's homepage");					
        } else {			
            System.out.println("We are NOT in Facebook's homepage");					
        }		
				driver.close();		

    }		
}