package ru.netology;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_web {

    private WebDriver driver;

    @BeforeAll
    //Запускается перед всеми тестами.
    public static void setupAll() {

    }

    @BeforeEach
    //Запускается перед каждым тестовым методом.
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    //Закрываем все окна браузера.
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void test() {
        driver.findElement(By.cssSelector("[data-test-id='name']input")).sendKeys("Александр Скударнов");
        driver.findElement(By.cssSelector("[data-test-id='phone']input")).sendKeys("+79226099999");

        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.tagName("button")).click();

        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Мы вам обязательно перезвоним, но это не точно.",text.trim());


    }


}
