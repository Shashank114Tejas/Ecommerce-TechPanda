package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class CheckoutPage extends PredefinedActions {
    private static CheckoutPage checkoutPage;
    private final PropertyReading checkoutPageProp;


    private CheckoutPage() {
        //Private Constructor for Singleton Design Pattern
        checkoutPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "CheckoutPageProp.properties");
    }

    public static CheckoutPage getcheckoutPage() {
        if (checkoutPage == null)
            checkoutPage = new CheckoutPage();
        return checkoutPage;
    }

    public void fillBillingInformation(String address, String city, String state, String zip, String country, String telephone) {
        enterText(getElement(checkoutPageProp.getValue("addressBox"), true), address);
        enterText(getElement(checkoutPageProp.getValue("cityBox"), true), city);
        selectElementByVisibleText(getElement(checkoutPageProp.getValue("selectState"), true), state);
        enterText(getElement(checkoutPageProp.getValue("zipBox"), true), zip);
        selectElementByVisibleText(getElement(checkoutPageProp.getValue("selectCountry"), true), country);
        enterText(getElement(checkoutPageProp.getValue("telephoneBox"), true), telephone);
    }

    public void clickOnContinueBtn() {
        clickOnElement(checkoutPageProp.getValue("continueBtn"), true);
    }

    public void confirmShippingMethod() {
        clickOnElement(checkoutPageProp.getValue("shippingMethodContinueBtn"), true);
    }

    public void confirmPaymentMethod() {
        clickOnElement(checkoutPageProp.getValue("checkMoneyOrderRadioBtn"), true);
        clickOnElement(checkoutPageProp.getValue("paymentInfoContinueBtn"), true);

    }

    public void confirmOrder()
    {
        clickOnElement(checkoutPageProp.getValue("placeOrderBtn"),true);
    }

    public String getOrderConfirmation()
    {
        return getElementText(getElement(checkoutPageProp.getValue("purchaseVerify"),true));
    }

    public String getOrderId()
    {
        return getElementText(getElement(checkoutPageProp.getValue("orderId"),true));

    }
}
