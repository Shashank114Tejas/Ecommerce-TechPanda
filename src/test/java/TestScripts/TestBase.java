package TestScripts;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Pages.*;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    private DashboardPage dashboardPage;
    private MobilePage mobilePage;
    private MobileDetailPage mobileDetailPage;
    private MobileCartPage mobileCartPage;
    private LoginOrCreateAccountPage loginOrCreateAccountPage;
    private CreateAccountPage createAccountPage;
    private AccountDashboardPage accountDashboardPage;
    private TVPage tvPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;



    @BeforeClass
    public void beforeClass() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        System.setProperty("current.date.time", sdf.format(new Date()));

        PropertyConfigurator.configure(ConstantPaths.LOG4J_PATH);

    }

    @BeforeMethod
    public void openBrowser() {
        PredefinedActions.initializeBrowser("http://live.techpanda.org/index.php/", "chrome");
    }


    DashboardPage getDashboardObj() {
        if (dashboardPage == null)
            dashboardPage = DashboardPage.getDashboardPage();
        return dashboardPage;
    }

    MobilePage getMobilePageObj() {
        if (mobilePage == null)
            mobilePage = MobilePage.getMobilePage();
        return mobilePage;
    }

    MobileDetailPage getMobileDetailPageObj() {
        if (mobileDetailPage == null)
            mobileDetailPage = MobileDetailPage.getMobileDetailPage();
        return mobileDetailPage;
    }

    MobileCartPage getMobileCartPageObj() {
        if (mobileCartPage == null)
            mobileCartPage = MobileCartPage.getMobileCartPage();
        return mobileCartPage;
    }

    LoginOrCreateAccountPage getLoginOrCreatePageObj() {
        if (loginOrCreateAccountPage == null)
            loginOrCreateAccountPage = LoginOrCreateAccountPage.getLoginOrCreateAccountPage();
        return loginOrCreateAccountPage;
    }

    CreateAccountPage getCreateAccountObj() {
        if (createAccountPage == null)
            createAccountPage = CreateAccountPage.getCreateAccountPage();
        return createAccountPage;
    }

    AccountDashboardPage getAccountDashboardPageObj() {
        if (accountDashboardPage == null)
            accountDashboardPage = AccountDashboardPage.getAccountDashboardPage();
        return accountDashboardPage;
    }

    TVPage getTvPageObj() {
        if (tvPage == null)
            tvPage = TVPage.getTvPage();
        return tvPage;
    }

    ShoppingCartPage getShoppingCartPageObj() {
        if (shoppingCartPage == null)
            shoppingCartPage = ShoppingCartPage.getShoppingCartPage();
        return shoppingCartPage;
    }
    CheckoutPage getCheckoutPageObj() {
        if (checkoutPage == null)
            checkoutPage = CheckoutPage.getcheckoutPage();
        return checkoutPage;
    }


    // @AfterMethod
    public void closeBrowser(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            PredefinedActions.takeScreenshot(result.getName());
        PredefinedActions.closeBrowser();
    }
}
