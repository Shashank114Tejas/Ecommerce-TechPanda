package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class MobileCartPage extends PredefinedActions {
    private static MobileCartPage mobileCartPage;
    private final PropertyReading mobileCartPageProp;


    private MobileCartPage() {
        //Private Constructor for Singleton Design Pattern
        mobileCartPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "MobileCartPageProp.properties");
    }

    public static MobileCartPage getMobileCartPage() {
        if (mobileCartPage == null)
            mobileCartPage = new MobileCartPage();
        return mobileCartPage;
    }

    public void updateCartValue(String quantity)
    {
        clickOnElement(mobileCartPageProp.getValue("quantityBox"),true);
        clearElementField(mobileCartPageProp.getValue("quantityBox"),true);
        enterText(getElement(mobileCartPageProp.getValue("cartUpdateBox"),true),quantity);
        clickOnElement(mobileCartPageProp.getValue("updateBtn"),true);
    }
    public String getErrorMsg()
    {
       return getElementText(getElement(mobileCartPageProp.getValue("errorMsg"),true));
    }
    public void clickOnEmptyCart()
    {
        clickOnElement(mobileCartPageProp.getValue("emptyCartBtn"),true);
    }
    public String getEmptyCartMsg()
    {

        return getElementText(getElement(mobileCartPageProp.getValue("emptyCartMsg"),true));
    }
}
