package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PropertiesPracticeExample {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;
    WebDriver driver;

    public void readProperties() throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("src/test/resources/User.properties");
        prop.load(fis);
        fis.close();
        setUsername(prop.getProperty("username"));
        setPassword(prop.getProperty("password"));
    }
    @BeforeTest
    public void Setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void Test() throws IOException {
        readProperties();
        driver.findElement(By.name("username")).sendKeys(getUsername());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
