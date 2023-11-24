package testcases;

import com.opencart.base.DriverBaseClass;
import com.opencart.pages.LoginPage;
import com.opencart.readutilityfiles.ReadExcelFile;
import com.opencart.webelementInteract.GetText;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTestCases extends DriverBaseClass {
    private DriverBaseClass driverBaseClass;
    private LoginPage objLoginPage;
    private WebDriver webDriver;
    private GetText objGetText;
    private boolean status;


    @BeforeMethod
    public void setup() throws IOException {

        driverBaseClass = new DriverBaseClass();
        webDriver = getDriver();
        objLoginPage = new LoginPage(webDriver);
        objGetText = new GetText(webDriver);
    }

    @AfterMethod
    public void tearDown() {
        driverBaseClass.tearDown();
    }

    @Test(description = "Verify title of the page", priority = 1)
    public void verifyTitle() {
        status = objLoginPage.verifyTitleOfLoginPage();
        Assert.assertEquals(status, true);
    }

    @Test(dataProviderClass = ReadExcelFile.class, dataProvider = "excelTestData",
            description = "Verify New customer Registry", priority = 2)
    @Description("Verify the New Customer Registry")
//    @Epic("Epic001")
//    @Feature("Feature 001: Login Page")
//    @Story("Verify customer demographics")
//    @Step("New customer Registry")
//    @Severity(SeverityLevel.MINOR)
    public void verifyNewCustomerRegistry(String testCaseNumber, String firstName, String lastName, String eMail, String telePhone, String passWord) {

    }

    @Test(priority = 3)
    @Description("Verify telephone number on login page")
    public void verifyTelephoneNumberOnLoginPage() {
        status = objLoginPage.verifyTelephoneNumberOnLoginPage();

        Assert.assertEquals(status, true);
    }

    @Test(priority = 4)
    @Description("Verify mouse hover action on My account ->> Login Link on Login Page")
    public void verifyLoginLinkOnLoginPage() {

        objLoginPage.verifyLoginLinkOnLoginPage();
    }
}
