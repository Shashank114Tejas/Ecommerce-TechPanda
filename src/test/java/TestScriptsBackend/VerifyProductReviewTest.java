package TestScriptsBackend;//import java.util.*;

import Base.PredefinedActions;
import Pages.Backend.BackendDashboardPage;
import Pages.Backend.LoginPage;
import Pages.DashboardPage;
import Pages.MobileDetailPage;
import Pages.MobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductReviewTest {
    String reviewerName = "Kallu Ustad".toUpperCase();
    @Test(priority = -1)
    public void doReview()
    {
        PredefinedActions.initializeBrowser("http://live.techpanda.org/","chrome");
        DashboardPage dashboardPage = DashboardPage.getDashboardPage();
        dashboardPage.clickOnMobileSection();
        MobilePage mobilePage = MobilePage.getMobilePage();
        mobilePage.clickOnMobile("Sony Xperia");

        MobileDetailPage mobileDetailPage = MobileDetailPage.getMobileDetailPage();
        mobileDetailPage.clickOnAddYourReview();
        mobileDetailPage.fillRating("5","Great Phone","A Must buy",reviewerName);
        mobileDetailPage.clickOnSubmitBtn();
        Assert.assertEquals(mobileDetailPage.getReviewConfirmation(),"Your review has been accepted for moderation.");
    }

    @Test
    public void reviewOnWebsite() {
        PredefinedActions.initializeBrowser("http://live.techpanda.org/index.php/backendlogin","chrome");
        LoginPage loginPage = LoginPage.getLoginPage();
        loginPage.doLogin("user01","guru99com");
        loginPage.clickOnLoginBtn();
        BackendDashboardPage backendDashboardPage = BackendDashboardPage.getBackendDashboardPage();
        backendDashboardPage.clickOnCloseBtn();
        backendDashboardPage.goToPendingReviews();
        backendDashboardPage.sortTableByIdInPendingReviews();
        backendDashboardPage.selectFirstCommentInPendingReviews();
        backendDashboardPage.clickOnEditBtnInPendingReviews();
        backendDashboardPage.selectStatus("Approved");
        backendDashboardPage.saveReviewInEditReviews();

        PredefinedActions.navigateToUrl("http://live.techpanda.org/");
        DashboardPage dashboardPage = DashboardPage.getDashboardPage();
        dashboardPage.clickOnMobileSection();
        MobilePage mobilePage = MobilePage.getMobilePage();
        mobilePage.clickOnMobile("Sony Xperia");

        MobileDetailPage mobileDetailPage = MobileDetailPage.getMobileDetailPage();
        mobileDetailPage.clickOnReviews();
        System.out.println(mobileDetailPage.isReviewVisible(reviewerName));
        //Assert.assertTrue(mobileDetailPage.isReviewVisible(reviewerName));


    }
}
