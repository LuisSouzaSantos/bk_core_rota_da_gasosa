package br.com.fesa.rotadagasosa.selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CT05Login02 {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  @Before
  public void setUp() {
        
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (3)");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void r2() {
    driver.get("http://fr-rota-da-gasosa-application.s3-website-sa-east-1.amazonaws.com/");
    driver.manage().window().setSize(new Dimension(1346, 700));
    driver.findElement(By.cssSelector("input:nth-child(1)")).click();
    driver.findElement(By.cssSelector("input:nth-child(1)")).sendKeys("luis.gustavo.ss@hotmail");
    driver.findElement(By.cssSelector(".Login_buttonLogin__2kn\\+T")).click();
    driver.findElement(By.cssSelector(".Login_buttonLogin__2kn\\+T")).click();
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    driver.findElement(By.cssSelector("input:nth-child(2)")).sendKeys("12");
    driver.findElement(By.cssSelector(".Login_buttonLogin__2kn\\+T")).click();
    driver.findElement(By.cssSelector("input:nth-child(1)")).click();
    driver.findElement(By.cssSelector("input:nth-child(1)")).click();
    driver.findElement(By.cssSelector("input:nth-child(1)")).sendKeys("luis.gustavo.ss@hotmail.com");
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("input:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector("input:nth-child(2)")).sendKeys("123456");
    driver.findElement(By.cssSelector(".Login_buttonLogin__2kn\\+T")).click();
  }
}
