package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebElement username = driver.findElement(By.id("username"));

        //enter password
        WebElement password = driver.findElement(By.name("password"));

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        //verifications:
        //  new url
        sleep(3000);

        //  logout button is visible
        WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));

        //  successful login message
        WebElement successfulMessage = driver.findElement(By.cssSelector("div#flash"));

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
