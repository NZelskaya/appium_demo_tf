package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public CalculatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    protected WebElement numeralBtn(String number) {
        return driver.findElement(By.xpath("//*[@text='" + number + "']"));
    }

    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/op_add']")
    protected WebElement additionBtn;

    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/eq']")
    protected WebElement equalsBtn;

    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/formula']")
    protected WebElement equalsValue;
}
