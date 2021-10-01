
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    private static String url = "https://onlinesim.ru/price-list";
    private static String path = "/Users/roman/Desktop/Keepcode.json";
    
    public static void main(String[] args) throws IOException {

        JSONObject listCountry = new JSONObject();
        Map<String, List<String>> jsonListPrice = new HashMap<>();
        Map<String, String> countryId = new HashMap<>();
        System.setProperty("webdriver.chrome.driver", "/Users/roman/Desktop/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> webElements = driver.findElements(By.cssSelector("a"));
        webElements.forEach(webElement -> {
            String id = webElement.getAttribute("id");
            String country = webElement.getText();
            String countryName = country.replaceAll("[A-z]", "");
            String numberCountry = id.replaceAll("\\D", "");
            numberCountry.trim();
            if (!numberCountry.equals("") && !countryName.equals("")) {
                countryId.put(countryName, numberCountry);
            }
        });
        for (String a : countryId.keySet()) {

            try {
                driver.findElement(By.cssSelector("#country-" + countryId.get(a))).click();
            } catch (Exception e) {
                JavascriptExecutor executor = driver;
                executor.executeScript("arguments[0].click();",
                        driver.findElement(By.cssSelector("#country-" + countryId.get(a))));
            }

            List<WebElement> webElements2 = driver.findElements(By.cssSelector("#country-service-" + countryId.get(a)));


            webElements2.forEach(webElement ->
            {
                String price = webElement.getText();
                String[] array = price.split("\n");
                List<String> listPrice = new ArrayList<>(Arrays.asList(array));
                listPrice.remove(0);
                jsonListPrice.put(a, listPrice);

            });
        }

        for (String c : jsonListPrice.keySet()) {
            ArrayList<String> nameOperator = new ArrayList<>();
            int b = 0;
            int d = 1;
            while (b < jsonListPrice.get(c).size())
            {
                    nameOperator.add(jsonListPrice.get(c).get(b));
                    b += 2;
            }


            JSONObject jsonObject = new JSONObject();
            for (int i = 0;i<nameOperator.size();i++)
            {
                if(jsonListPrice.get(c).size()>d) {
                    jsonObject.put(nameOperator.get(i),jsonListPrice.get(c).get(d));
                }
                    d += 2;

            }
            listCountry.put(c,jsonObject);
        }
            FileWriter file = new FileWriter(path);
            file.write(listCountry.toJSONString());
            file.flush();
            file.close();
        driver.quit();
    }
}

