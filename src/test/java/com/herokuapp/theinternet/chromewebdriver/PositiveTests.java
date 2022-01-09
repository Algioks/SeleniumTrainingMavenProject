package com.herokuapp.theinternet.chromewebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        //sleep(3000);

        //maximize browser window
        //driver.manage().window().maximize();

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:
        //  new url
        //sleep(3000);
        String expectedURL = "http://the-internet.herokuapp.com/secure";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Actual page url is not the same as expected");

        //  logout button is visible
        WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "The logout button is not visible");

        //  successful login message
        WebElement successfulMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successfulMessage.getText();
        //Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not correct");
        Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message is not correct. \nActual Message: " + actualMessage + "\nExpected message: " + expectedMessage);
        
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
