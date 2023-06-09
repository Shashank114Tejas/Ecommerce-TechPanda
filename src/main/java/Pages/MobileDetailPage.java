package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;
import org.apache.log4j.Logger;

public class MobileDetailPage extends PredefinedActions {
    private static MobileDetailPage mobileDetailPage;
    private final PropertyReading mobileDetailPageProp;
    private static Logger log = Logger.getLogger(MobileDetailPage.class);

    private MobileDetailPage() {
        //Private Constructor for Singleton Design Pattern
        mobileDetailPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "MobileDetailPageProp.properties");
    }

    public static MobileDetailPage getMobileDetailPage() {
        if (mobileDetailPage == null)
            mobileDetailPage = new MobileDetailPage();
        return mobileDetailPage;
    }

    public String getMobilePrice() {
        return getElementText(getElement(mobileDetailPageProp.getValue("productPriceInPage"), true));
    }

    public void clickOnAddYourReview() {
        clickOnElement(mobileDetailPageProp.getValue("addYourReviewBtn"), true);
    }

    public void fillRating(String starsInNumber, String thoughts, String summary, String nickname) {
        if (Integer.parseInt(starsInNumber) <= 5) {
            String rating = String.format(mobileDetailPageProp.getValue("qualityRating"), starsInNumber);
            clickOnElement(rating, true);
        } else
            throw new RuntimeException("You have entered more than 5 stars");
        enterText(getElement(mobileDetailPageProp.getValue("reviewBox"), true), thoughts);
        enterText(getElement(mobileDetailPageProp.getValue("summaryBox"), true), summary);
        enterText(getElement(mobileDetailPageProp.getValue("nicknameBox"), true), nickname);
    }

    public String getReviewConfirmation() {
        return getElementText(getElement(mobileDetailPageProp.getValue("reviewConfirmation"), true));
    }

    public void clickOnSubmitBtn() {
        clickOnElement(mobileDetailPageProp.getValue("reviewSubmitBtn"), true);
    }

    public void clickOnReviews() {
        clickOnElement(mobileDetailPageProp.getValue("reviewBtn"), true);
    }

    public boolean isReviewVisible(String name) {
        return getElementText(getElement(mobileDetailPageProp.getValue("firstReview"), true)).contains(name);

    }
}
