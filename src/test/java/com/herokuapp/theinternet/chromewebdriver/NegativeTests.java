package com.herokuapp.theinternet.chromewebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test
    public void incorrectUsernameLoginTest (){

        //Create driver
        System.out.println("Starting login test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\projects\\SeleniumTrainingMavenProject\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUsername");

        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:
        //  new url
        //sleep(3000);
        String expectedURL = "http://the-internet.herokuapp.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Actual page url is not correct");

        //  login button is visible
        loginButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
        Assert.assertTrue(loginButton.isDisplayed(), "The login button is not visible");

        //  failure login message
        WebElement failureMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
        String expectedMessage = "Your username is invalid!";
        String actualMessage = failureMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message is not correct. \nActual Message: " + actualMessage + "\nExpected message: " + expectedMessage);

        //close browser
        driver.quit();
    }

    @Test
    public void incorrectPasswordLoginTest (){

        //Create driver
        System.out.println("Starting login test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\projects\\SeleniumTrainingMavenProject\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPasswor");

        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        //verifications:
        //  new url
        //sleep(3000);
        String expectedURL = "http://the-internet.herokuapp.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Actual page url is not correct");

        //  login button is visible
        loginButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
        Assert.assertTrue(loginButton.isDisplayed(), "The login button is not visible");

        //  failure login message
        WebElement failureMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
        String expectedMessage = "Your password is invalid!";
        String actualMessage = failureMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message is not correct. \nActual Message: " + actualMessage + "\nExpected message: " + expectedMessage);

        //close browser
        driver.quit();
    }

}
