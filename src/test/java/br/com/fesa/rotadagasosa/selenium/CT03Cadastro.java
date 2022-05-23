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

public class CT03Cadastro {
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
  public void t3cadastro() {
    driver.get("http://fr-rota-da-gasosa-application.s3-website-sa-east-1.amazonaws.com/");
    driver.manage().window().setSize(new Dimension(1346, 700));
    driver.findElement(By.linkText("Cadastre-se")).click();
    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
    driver.findElement(By.cssSelector("input:nth-child(3)")).sendKeys("Maria");
    driver.findElement(By.cssSelector("input:nth-child(4)")).sendKeys("maria@email.com");
    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
    driver.findElement(By.cssSelector("input:nth-child(5)")).sendKeys("13960-000");
    driver.findElement(By.cssSelector("input:nth-child(6)")).sendKeys("Rua a");
    driver.findElement(By.cssSelector("input:nth-child(7)")).sendKeys("33");
    driver.findElement(By.cssSelector("input:nth-child(8)")).sendKeys("55999999999");
    driver.findElement(By.cssSelector("input:nth-child(9)")).click();
    driver.findElement(By.cssSelector("input:nth-child(9)")).sendKeys("Maria@123");
    driver.findElement(By.cssSelector(".Register_buttonRegister__Ybja5")).click();
    driver.findElement(By.cssSelector(".Register_buttonRegister__Ybja5")).click();
  }
}
