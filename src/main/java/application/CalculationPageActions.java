package application;

import org.openqa.selenium.WebDriver;

public class CalculationPageActions extends CalculatorPage {
    public CalculationPageActions(WebDriver driver) {
        super(driver);
    }

    public void clickAtNumeral(String number) {
        numeralBtn(number).click();
    }

    public void clickAddition() {
        additionBtn.click();
    }

    public void clickEquals() {
        equalsBtn.click();
    }

    public String getOperationResult() {
        return equalsValue.getText();
    }
}
