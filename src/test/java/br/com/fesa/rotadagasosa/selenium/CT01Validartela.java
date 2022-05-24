package br.com.fesa.rotadagasosa.selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
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
public class CT01Validartela {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (3)");
    driver = new ChromeDriver();
    //System.setProperty("webdriver.gecko.driver","C:\\Users\\Lenovo\\Downloads\\geckodriver-v0.31.0-win64");
    //driver = new FirefoxDriver();

    //System.setProperty("webdriver.edge.driver", "C:\\Users\\Lenovo\\Downloads\\edgedriver_win64");
    //WebDriver driver = new EdgeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testeN2() {
    driver.get("http://fr-rota-da-gasosa-application.s3-website-sa-east-1.amazonaws.com/");
    driver.manage().window().setSize(new Dimension(1382, 736));
    driver.findElement(By.cssSelector("input:nth-child(1)")).click();
    driver.findElement(By.cssSelector("input:nth-child(1)")).sendKeys("luis.gustavo.ss@hotmail.com");
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    driver.findElement(By.cssSelector("input:nth-child(2)")).sendKeys("1");
    driver.findElement(By.cssSelector(".Login_buttonLogin__2kn\\+T")).click();
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    driver.findElement(By.cssSelector("input:nth-child(2)")).sendKeys("123456");
    driver.findElement(By.cssSelector(".Login_buttonLogin__2kn\\+T")).click();
    driver.findElement(By.linkText("Cadastre-se")).click();
    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
    driver.findElement(By.cssSelector("input:nth-child(3)")).sendKeys("Maria");
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(4)")).sendKeys("admSist@gmail.com");
    driver.findElement(By.cssSelector("input:nth-child(5)")).sendKeys("09846-045");
    driver.findElement(By.cssSelector("input:nth-child(8)")).sendKeys("55999999999");
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("input:nth-child(4)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector("input:nth-child(4)")).click();
    driver.findElement(By.cssSelector("input:nth-child(4)")).sendKeys("maria@email.com");
    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("input:nth-child(5)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
    driver.findElement(By.cssSelector("input:nth-child(5)")).click();
    driver.findElement(By.cssSelector("input:nth-child(5)")).sendKeys("13960-000");
    driver.findElement(By.cssSelector("input:nth-child(6)")).sendKeys("Rua a");
    driver.findElement(By.cssSelector("input:nth-child(7)")).sendKeys("33");
    driver.findElement(By.cssSelector("input:nth-child(8)")).click();
    driver.findElement(By.cssSelector("input:nth-child(9)")).sendKeys("Maria@123");
    driver.findElement(By.cssSelector(".Register_buttonRegister__Ybja5")).click();
  }
}
