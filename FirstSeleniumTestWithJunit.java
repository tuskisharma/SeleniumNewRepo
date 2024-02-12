package dev.selenium;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class FirstSeleniumTestWithJunit {
    WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        //Scanner sc=new Scanner(System.in);
        System.out.println("Enter choice: ");
        int choice= 3;
        switch (choice){
            case 1: driver=new ChromeDriver();
                   break;
            case 2: driver=new FirefoxDriver();
                   break;
            case 3: driver=new EdgeDriver();
                   break;
            default:
                System.out.println("Driver not selected");

        }
        //driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void execution() throws InterruptedException {
            driver.findElement(By.name("q")).sendKeys("lionel messi");
            Thread.sleep(5000);
            WebElement wb=driver.findElement(By.xpath("//*[@id=\"jZ2SBf\"]/div[1]/span"));
            wb.submit();
            System.out.println(driver.getTitle());
            assertmethod();
        }

    public void assertmethod(){
        WebElement wl=driver.findElement(By.xpath("//div[@class='PZPZlf ssJ7i B5dxMb']"));
        String str=wl.getText();
        System.out.println(str);
       // String str="Lionel Messi";
        //System.out.println(str);
        Assert.assertTrue(str,true);

    }
    @After
    public void teardown(){
        driver.quit();
    }
}
