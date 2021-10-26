import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Adverti {
    private static final String itemTitle = "//div[@class='promo-product__title']";
    private static final String priceId = "//span[@class='promo-product__price__price_value']";
    private static final String articleNumber = "//span[text()[contains(.,'Арт.')]]";
    private static final String nextButton = "//a[@class='paginator__next']";

    public static List<String> key;
    public static List<String> value;
    public static List<String> name;

    //Adverti.ru parser


    public static void parser(String page) throws NoSuchElementException, IOException {
        boolean switcher = true;

        ParseBase.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ParseBase.driver.manage().window().maximize();
        ParseBase.navigation(page);
        while (switcher) {
            key = ParseBase.finder(articleNumber);
            value = ParseBase.finder(priceId);
            name = ParseBase.finder(itemTitle);

            if (ParseBase.elementIsPresented(nextButton)) {
                WebElement button = ParseBase.driver.findElement(By.xpath(nextButton));
                button.click();
            } else {
                ParseBase.driver.quit();
                switcher=false;

            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1 to write results into file or press 2 to send result into console:");
        int interact = Integer.parseInt(reader.readLine());
        switch (interact){
            case 1:
                System.out.println("Enter file name (xxxxx.csv):");
                String fileName = reader.readLine();
                new csvWriter(fileName,key,value,name);

                break;
            case 2:
                for(int i=0;i< name.size();i++){
                    System.out.println(key.get(i)+": "+ name.get(i)+ ": "+ value.get(i));
                }
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }


    }
}
