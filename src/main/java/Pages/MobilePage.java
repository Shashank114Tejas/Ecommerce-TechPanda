package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

import java.util.*;

public class MobilePage extends PredefinedActions {
    private static MobilePage mobilePage;
    private final PropertyReading mobilePageProp;
    private String parentWindow;


    private MobilePage() {
        //Private Constructor for Singleton Design Pattern
        mobilePageProp = new PropertyReading(ConstantPaths.PROP_PATH + "MobilePageProp.properties");
    }

    public static MobilePage getMobilePage() {
        if (mobilePage == null)
            mobilePage = new MobilePage();
        return mobilePage;
    }

    public String getTitle() {
        return getWebpageTitle();
    }

    public boolean isHeadingVisible() {
        return getElementText(getElement(mobilePageProp.getValue("pageHeading"), true)).contains("MOBILE");
    }

    public void productSortByName() {
        clickOnElement(mobilePageProp.getValue("sortBy"), true);
        selectElementByValue(getElement(mobilePageProp.getValue("sortBy"), true),
                mobilePageProp.getValue("selectByValue"));

    }

    public boolean isListSortedByName() {
        List<String> productList = getWebElementListInString(mobilePageProp.getValue("productList"), true);
        List<String> tempList = new ArrayList<>(productList);
        Collections.sort(tempList);
        return productList.equals(tempList);
    }

    public String productValueInMobileListPage() {
        return getElementText(getElement(mobilePageProp.getValue("productPrice"), true));
    }

    public void clickOnMobile(String mobileName) {
        String s = String.format(mobilePageProp.getValue("mobileBrand"), mobileName);
        clickOnElement(s, true);
    }

    public void addToCartBtn() {
        clickOnElement(mobilePageProp.getValue("addToCartBtn"), true);
    }

    public void clickOnAddToCompare(String brandName) {
        String s = String.format(mobilePageProp.getValue("addToCompareBtn"),brandName);
        clickOnElement(s, true);
    }

    public void clickOnCompareProduct() {
        clickOnElement(mobilePageProp.getValue("viewCompare"), true);
        Set<String> handles = getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        parentWindow = iterator.next();
        String childWindow = iterator.next();
        switchToWindow(childWindow);
    }
    public void afterAct()
    {
        closeBrowser();
        switchToWindow(parentWindow);
    }

    public String getHeadingOfCompareWindow() {
        return getElementText(mobilePage.getElement(mobilePageProp.getValue("childWinHeading"), true));
    }

    public String getFirstCompareProductName()
    {
       return getElementText(getElement(mobilePageProp.getValue("productOne"),true));
    }
    public String getSecondCompareProductName()
    {
        return getElementText(getElement(mobilePageProp.getValue("productTwo"),true));
    }

    public void addToCartBtn(String productName) {
        String s = String.format(mobilePageProp.getValue("addToCartBtn"),productName);
        clickOnElement(s, true);
    }
}
