package TestScriptsBackend;//import java.util.*;

import Base.PredefinedActions;
import Pages.Backend.BackendDashboardPage;
import Pages.Backend.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyBackendTest extends TestBase {

    @Test
    public void VerifyInvoiceCanBePrinted() throws InterruptedException {
        //1.Go to http://live.techpanda.org/index.php/backendlogin
        LoginPage loginPage = getLoginPageObj();
        // 2.Login the credentials provided
        loginPage.doLogin("user01","guru99com");
        loginPage.clickOnLoginBtn();
        // 3.Go to Sales-> Orders menu
        BackendDashboardPage backendDashboardPage = getBackendDashboardPageObj();
        backendDashboardPage.clickOnCloseBtn();
        backendDashboardPage.clickOnSales();
        backendDashboardPage.clickOnOrders();
        //4.In the status field select "Canceled". Click Search
        backendDashboardPage.selectMenu("Canceled");
        backendDashboardPage.clickOnSearch();
        //5.Select the checkbox next to first order
        Thread.sleep(1000);
        backendDashboardPage.clickOnFirstItem();
        backendDashboardPage.selectAction("Print Invoices");
        backendDashboardPage.clickOnSubmitBtn();
        String actualText = backendDashboardPage.getErrorText();
        Assert.assertEquals(actualText,"There are no printable documents related to selected orders.");

        backendDashboardPage.selectMenu("Complete");
        backendDashboardPage.clickOnSearch();
        Thread.sleep(500);
        backendDashboardPage.clickOnFirstItem();
        backendDashboardPage.selectAction("Print Invoices");
        backendDashboardPage.clickOnSubmitBtn();
        PredefinedActions.clickEnter();





    }
}
