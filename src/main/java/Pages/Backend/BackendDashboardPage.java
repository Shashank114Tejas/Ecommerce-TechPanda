package Pages.Backend;//import java.util.*;

import Base.PredefinedActions;
import Utils.PropertyReading;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BackendDashboardPage extends PredefinedActions {
    private final PropertyReading backendDashboardPageProp;
    private static BackendDashboardPage backendDashboardPage;

    private BackendDashboardPage() {
        backendDashboardPageProp = new PropertyReading("src/main/resources/BackendConfig/BackendDashboardPage.properties");
    }

    public static BackendDashboardPage getBackendDashboardPage() {
        if (backendDashboardPage == null)
            backendDashboardPage = new BackendDashboardPage();
        return backendDashboardPage;
    }

    public void clickOnCloseBtn() {
        clickOnElement(backendDashboardPageProp.getValue("closeBtn"), true);
    }

    public void clickOnSales() {
        clickOnElement(backendDashboardPageProp.getValue("salesMenu"), true);
    }

    public void clickOnOrders() {
        clickOnElement(backendDashboardPageProp.getValue("ordersMenu"), true);
    }

    public void selectMenu(String menu) {
        selectElementByVisibleText(getElement(backendDashboardPageProp.getValue("statusMenu"), true), menu);
    }

    public void clickOnSearch() {
        clickOnElement(backendDashboardPageProp.getValue("searchBtn"), true);
    }

    public void clickOnFirstItem() {
        clickOnElementWithJS(backendDashboardPageProp.getValue("firstRow"), true);
    }

    public void selectAction(String action) {
        selectElementByVisibleText(getElement(backendDashboardPageProp.getValue("actionsMenu"), true), action);
    }

    public void clickOnSubmitBtn() {
        clickOnElement(backendDashboardPageProp.getValue("submitBtn"), true);
    }

    public String getErrorText() {
        return getElementText(getElement(backendDashboardPageProp.getValue("errorMsg"), true));
    }

    public void goToPendingReviews() {
        clickOnElement(backendDashboardPageProp.getValue("catalogMenu"), true);
        clickOnElement(backendDashboardPageProp.getValue("reviewAndRating"), true);
        clickOnElement(backendDashboardPageProp.getValue("customerRating"), true);
        clickOnElement(backendDashboardPageProp.getValue("pendingReviews"), true);
    }

    public void sortTableByIdInPendingReviews() {
        clickOnElement(backendDashboardPageProp.getValue("sortByIdInPendingReviews"), true);
    }

    public void selectFirstCommentInPendingReviews() {
        try {
            clickOnElementWithJS(backendDashboardPageProp.getValue("selectCommentInPendingReviews"), true);
            throw new RuntimeException();
        } catch (RuntimeException re) {
            System.out.println("No Review found");
        }
    }

    public void clickOnEditBtnInPendingReviews() {
        clickOnElementWithJS(backendDashboardPageProp.getValue("editBtnInPendingReviews"), true);
    }

    public void selectStatus(String status) {
        selectElementByVisibleText(getElement(backendDashboardPageProp.getValue("selectStatusInEditReviews"), true), status);
    }

    public void saveReviewInEditReviews() {
        clickOnElement(backendDashboardPageProp.getValue("saveReviewBtnInEditReviews"), true);
    }

    public void clickOnInvoice() {
        clickOnElement(backendDashboardPageProp.getValue("invoicesMenu"), true);
    }

    public void clickOnInvoiceHeader() {
        clickOnElement(backendDashboardPageProp.getValue("invoiceHeader"), true);
    }

    public boolean isInvoiceDateInAscending() throws ParseException {
        List<Date> sortedList = getWebElementListInStringCustom(backendDashboardPageProp.getValue("invoiceListDate"), true);
        System.out.println(sortedList);
        List<Date> temp = new ArrayList<Date>(sortedList);
        System.out.println(temp);
        return sortedList.equals(temp);
    }

    public boolean isInvoiceDateInDescending() {
        List<String> sortedList = getWebElementListInString(backendDashboardPageProp.getValue("invoiceListDate"), true);
        List<String> temp = new ArrayList<>(sortedList);
        Collections.reverse(temp);
        return sortedList.equals(temp);
    }

}
