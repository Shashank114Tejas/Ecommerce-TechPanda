package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class TVPage extends PredefinedActions {
    private static TVPage tvPage;
    private final PropertyReading tvPageProp;


    private TVPage() {
        //Private Constructor for Singleton Design Pattern
        tvPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "TvPageProp.properties");
    }

    public static TVPage  getTvPage() {
        if (tvPage == null)
            tvPage = new TVPage();
        return tvPage;
    }
    public void addToWishlist(String brand) {
        String element = String.format(tvPageProp.getValue("addToWishListBtn"), brand);
        clickOnElement(element, true);
    }
}
