import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

// Base class for parsing web-sites


public class ParseBase {
 public static WebDriver driver = new ChromeDriver();

//The method goes to the URL
 public static void navigation(String page) {

  driver.navigate().to(page);
 }

 //The method finds elements on the page
 public static List<String> finder(String xpathID) {
  List<WebElement> buffer = driver.findElements(By.xpath(xpathID));
  List<String> stringBuffer = new ArrayList<>();
  String value;
  for (WebElement i : buffer) {
   value = i.getText();
   stringBuffer.add(value);
  }
return stringBuffer;
 }

 //The method checks if the element presented on the page
 public static boolean elementIsPresented (String element){
  try {
   ParseBase.driver.findElement(By.xpath(element));
   return true;
  }catch (org.openqa.selenium.NoSuchElementException e){
   return false;
  }

 }

}
