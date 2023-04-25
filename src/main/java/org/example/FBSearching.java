package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FBSearching
{
    public static void main(String[] args) {

        // Creates an instance of ChromeOptions and adds options
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        /* This option opens the Chrome window with specified user profile.
        It is useful for when you wish to already be logged in.
        Replace the dir path with the path to your own user, and make sure to be logged in to facebook on your
        chrome user before executing the code. */
        options.addArguments("--user-data-dir=C:\\Users\\ruxia\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        String textToSearchFor = "Pulp Fiction";

        try {
            // Create an instance of ChromeDriver with the options
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            // Navigate to homepage
            driver.get("https://www.facebook.com/");
            Logback.navigationSuccess();
            // Find & click posting text field
            try {
                WebElement searchField = driver.findElement(By.cssSelector("[aria-label='Search Facebook']"));
                searchField.sendKeys(textToSearchFor);
                searchField.sendKeys(Keys.ENTER);
                Logback.searchInputSuccess();
                Thread.sleep(1000);
                try {
                    driver.findElement(By.xpath("//*[contains(text(), 'Search results')]"));
                    Logback.searchSuccess();
                    Logback.logURL(driver.getCurrentUrl());
                }
                catch(Exception all){
                    Logback.searchFailure();
                }
            }
            catch(Exception all){
                Logback.searchInputFailure();
            }




/*
            // Find & put down current time into text field
            String time = String.valueOf(LocalTime.now());
            WebElement active = driver.switchTo().activeElement();
            active.sendKeys("Current time is " + time);
            Thread.sleep(1000);

            // Could not locate the element for the post button, so this uses
            // TAB & ENTER keys to navigate to and push the button instead
            for (int i = 0; i < 10; i++) {
                active.sendKeys(Keys.TAB);
                active = driver.switchTo().activeElement();
            }
            active.sendKeys(Keys.ENTER);
            // Giving FB time to post after clicking
            Thread.sleep(3000);


            // Find the post, loggs the outcome
            try {
                // Creating temporary String containing the xpath expression + variable time.
                String xpathPath = "//*[contains(text(), '" + time + "')]";
                driver.findElement(By.xpath(xpathPath));
                Logback.postSuccess();
            } catch (Exception all) {
                Logback.postFailure();
            }

 */
        } catch (Exception all) {
            Logback.navigationFailure();
        }

    }
}