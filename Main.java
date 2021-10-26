import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
   private static String url1 = "https://www.pandagifts.ru/catalog/bryuki-i-shorty/";
   private static String url2 = "https://www.adverti.ru/textile/scarfs-logo/?order=popularity";

    public static void main(String[] args) throws IOException {

    PandaGifts.parser(url1);
    //Adverti.parser(url2);

    }


}
