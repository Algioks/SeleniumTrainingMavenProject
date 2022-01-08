package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {

    @Test
    public void loginTest (){
        //Create driver
        System.out.println("Starting login test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\projects\\SeleniumTrainingMavenProject\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //sleep for 3 seconds
        sleep(3000);

        //maximize browser window
        driver.manage().window().maximize();

        //enter username
        //enter password
        //click login button
        //verifications:
        //  new url
        //  logout button is visible
        //  successful login message

        //close browser
        driver.quit();
    }

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
