
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.ExcelUtils;

import java.io.IOException;

public class TestClass {

    @Test
    public void loginTest() throws IOException {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(handlingSSL);

        // Read data from Excel
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "TestData";
        int row = 0;

        String username = ExcelUtils.getUsername(excelPath, sheetName, row);
        String password = ExcelUtils.getPassword(excelPath, sheetName, row);


        driver.get("https://192.168.3.70:1866/ObservabilityTraces/UserManagement");

        WebElement userNameField = driver.findElement(By.id("UserName"));
        WebElement passwordField = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("btn_Submit"));

        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        driver.quit();
    }
}
