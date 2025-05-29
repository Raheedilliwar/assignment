
package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UserE2ETest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenPage() {
        driver.get("http://example.com");  // Replace with actual UI path
        Assertions.assertTrue(driver.getTitle().contains("Example"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
