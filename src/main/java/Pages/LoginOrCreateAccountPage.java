package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

import java.util.ArrayList;
import java.util.List;

public class LoginOrCreateAccountPage extends PredefinedActions {
    private static LoginOrCreateAccountPage createAccountPage;
    private final PropertyReading loginOrCreatePageProp;
    private final PropertyReading credProp;

    private LoginOrCreateAccountPage() {
        //Private Constructor for Singleton Design Pattern
        loginOrCreatePageProp = new PropertyReading(ConstantPaths.PROP_PATH + "LoginOrCreatePageProp.properties");
        credProp = new PropertyReading(ConstantPaths.PROP_PATH + "CredProp.properties");
    }

    public static LoginOrCreateAccountPage getLoginOrCreateAccountPage() {
        if (createAccountPage == null)
            createAccountPage = new LoginOrCreateAccountPage();
        return createAccountPage;
    }

    public void clickOnCreateAccountBtn()
    {
        clickOnElement(loginOrCreatePageProp.getValue("createAccountBtn"),true);
    }

    public void loginIntoAccount(String email,String password)
    {
        enterText(getElement(loginOrCreatePageProp.getValue("loginEmail"),true),email);
        enterText(getElement(loginOrCreatePageProp.getValue("loginPassword"),true),password);
    }
    public void clickOnLoginBtn()
    {
        clickOnElement(loginOrCreatePageProp.getValue("loginBtn"),true);
    }
    public List<String>getCredList()
    {
        List<String> credList = new ArrayList<>();
        credList.add(credProp.getValue("email"));
        credList.add(credProp.getValue("password"));
        return credList;
    }

}
