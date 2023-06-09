package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class AccountDashboardPage extends PredefinedActions {
    private static AccountDashboardPage accountDashboardPage;
    private final PropertyReading accountDashboardPageProp;
    static Logger log = Logger.getLogger(AccountDashboardPage.class);

    private AccountDashboardPage() {
        //Private Constructor for Singleton Design Pattern
        accountDashboardPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "AccountDashboardPageProp.properties");
    }

    public static AccountDashboardPage getAccountDashboardPage() {
        if (accountDashboardPage == null)
            accountDashboardPage = new AccountDashboardPage();
        return accountDashboardPage;
    }

    public String getSuccessMsg() {
        return getElementText(getElement(accountDashboardPageProp.getValue("msgElement"), true));
    }

    public void clickOnShareWishlist() {
        clickOnElement(accountDashboardPageProp.getValue("shareWishlistBtn"), true);
    }

    public String shareWishlist(String email, String msg) {
        enterText(getElement(accountDashboardPageProp.getValue("enterEmail"), true), email);
        enterText(getElement(accountDashboardPageProp.getValue("enterMsg"), true), msg);
        clickOnElement(accountDashboardPageProp.getValue("shareWishlistBtn2"), true);
        return getElementText(getElement(accountDashboardPageProp.getValue("successMsgWishlist"), true));
    }

    public void clickOnMyWishlist() {
        clickOnElement(accountDashboardPageProp.getValue("myWishlist"), true);
    }

    public void clickOnAddToCartBtn() {
        clickOnElement(accountDashboardPageProp.getValue("addToCartBtn"), true);
    }

    public void clickOnMyOrders() {
        clickOnElement(accountDashboardPageProp.getValue("myOrders"), true);
    }

    public void clickOnViewOrder(String orderId) {
        try {
            String format = String.format(accountDashboardPageProp.getValue("viewOrder"), orderId);
            clickOnElement(format, true);
        } catch (NoSuchElementException noSuchElementException) {
            log.info("Order ID not founnd");
        }
    }
    public boolean isOrderPending() {
        return getElementText(getElement(accountDashboardPageProp.getValue("orderStatus"), true)).contains("Pending");
    }
    public void clickOnPrintOrder()
    {
        clickOnElement(accountDashboardPageProp.getValue("printOrderBtn"),true);
    }

    public void verifyOrderIsSavedAsPDF() {
        String parentWindow = getWindowHandle();
        Set<String> handles = getWindowHandles();
        Iterator<String> winHandles = handles.iterator();
        while(winHandles.hasNext()){
            String childWindow = winHandles.next();
            if(!parentWindow.equals(childWindow)){
                switchToWindow(childWindow);
            }
        }
    }
    public void clickOnReorder()
    {
        clickOnElement(accountDashboardPageProp.getValue("reorderLink"),true);
    }

}
