package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class ShoppingCartPage extends PredefinedActions {
    private static ShoppingCartPage shoppingCartPage;
    private final PropertyReading shoppingCartPageProp;


    private ShoppingCartPage() {
        //Private Constructor for Singleton Design Pattern
        shoppingCartPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "ShoppingCartPageProp.properties");
    }

    public static ShoppingCartPage getShoppingCartPage() {
        if (shoppingCartPage == null)
            shoppingCartPage = new ShoppingCartPage();
        return shoppingCartPage;
    }

    public void fillShippingInformation(String country, String state, String zipCode) {
        selectElementByVisibleText(getElement(shoppingCartPageProp.getValue("selectByCountry"), true), country);
        selectElementByVisibleText(getElement(shoppingCartPageProp.getValue("selectByState"), true), state);
        enterText(getElement(shoppingCartPageProp.getValue("zipCodeBox"), true), zipCode);
    }

    public void clickOnEstimateBtn() {
        clickOnElement(shoppingCartPageProp.getValue("estimateBtn"), true);
    }

    public double getFlatRate() {
        clickOnElement(shoppingCartPageProp.getValue("flatRateRadio"), true);
        clickOnElement(shoppingCartPageProp.getValue("flatRateUpdateBtn"),true);
        return Double.parseDouble(getElementText(getElement(shoppingCartPageProp.getValue("flatRateInDollar"), true)).replace("$", ""));
    }

    public Double getSubTotal() {
        return Double.parseDouble(getElementText(getElement(shoppingCartPageProp.getValue("subTotal"), true)).replace("$", "").replace(",", ""));
    }

    public double getGrandTotal() {
        return Double.parseDouble(getElementText(getElement(shoppingCartPageProp.getValue("grandTotal"), true)).replace("$", "").replace(",", ""));
    }

    public void clickOnCheckOutBtn() {
        clickOnElement(shoppingCartPageProp.getValue("proceedToCheckOutBtn"), true);
    }

    public int getItemPrice(String productName)
    {
        String s = String.format(shoppingCartPageProp.getValue("itemPrice"),productName);
       return Integer.parseInt(getElementText(getElement(s,true)).replace("$","").replace(".00",""));
    }
    public void updateQuantityOfProduct(String productName, String quantity)
    {
        String s = String.format(shoppingCartPageProp.getValue("updateQuantity"),productName);
        clickOnElement(s,true);
        clearElementField(s,true);
        enterText(getElement(s,true),quantity);
        clickOnElement(shoppingCartPageProp.getValue("updateBtn"),true);
    }
    public void enterDiscountCode(String discountName)
    {
        enterText(getElement(shoppingCartPageProp.getValue("discountBox"),true),discountName);
        clickOnElement(shoppingCartPageProp.getValue("applyBtn"),true);
    }
    public Double getDiscountValue()
    {
        return Double.parseDouble(getElementText(getElement(shoppingCartPageProp.getValue("discountPrice"),true)).replace("-$",""));
    }
}
