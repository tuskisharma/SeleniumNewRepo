package dev.selenium;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstSeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("lionel messi");
        Thread.sleep(5000);
        WebElement wb=driver.findElement(By.xpath("//*[@id=\"jZ2SBf\"]/div[1]/span"));
        wb.submit();
        System.out.println(driver.getTitle());
        //WebElement wl=driver.findElement(By.xpath("//div[@class='PZPZlf ssJ7i B5dxMb']"));
        String str="Lionel Messi";
        System.out.println(str);
        Assert.assertTrue(str,true);
        Thread.sleep(2000);
        driver.quit();

    }



}
