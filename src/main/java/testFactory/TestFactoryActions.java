package testFactory;

import application.CalculationPageActions;
import driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.b2b.testfactory.TestFactoryUtils;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class TestFactoryActions extends BaseTestFactoryActions {
    CalculationPageActions calculationPageActions;

    @BeforeMethod
    public void before() {
        calculationPageActions = new CalculationPageActions(DriverSetup.getDriver());
    }

    @Test
    @TestFactoryMethod(value = "Press numeral button", description = "Should be from 0 to 9", group = "Calculator")
    @Parameters("numeral")
    public void pressNumeral(String numeral) {
        calculationPageActions.clickAtNumeral(numeral);
    }

    @Test
    @TestFactoryMethod(value = "Press Addition button", description = "Press + button", group = "Calculator")
    public void pressAddition() {
        calculationPageActions.clickAddition();
    }

    @Test
    @TestFactoryMethod(value = "Press Equals button", description = "Press = button", group = "Calculator")
    public void pressEquals() {
        calculationPageActions.clickEquals();
    }

    @Test
    @TestFactoryMethod(value = "Verify addition result", description = "Verify that addition was calculated properly", group = "Calculator")
    @Parameters("expectedAdditionResult")
    public void verifyAdditionResult(String expectedAdditionResult) {
        Assert.assertEquals(calculationPageActions.getOperationResult(), expectedAdditionResult, "Calculation is wrong");
    }
}
