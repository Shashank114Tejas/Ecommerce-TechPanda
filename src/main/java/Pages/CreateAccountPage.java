package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class CreateAccountPage extends PredefinedActions {
    private static CreateAccountPage createAccountPage;
    private final PropertyReading createAccountPageProp;

    private CreateAccountPage() {
        //Private Constructor for Singleton Design Pattern
        createAccountPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "CreateAccountPageProp.properties");
    }

    public static CreateAccountPage getCreateAccountPage() {
        if (createAccountPage == null)
            createAccountPage = new CreateAccountPage();
        return createAccountPage;
    }

    public void enterRegistrationDetail(String firsName,String lastName,String email,String password)
    {
        enterText(getElement(createAccountPageProp.getValue("firstName"),true),firsName);
        enterText(getElement(createAccountPageProp.getValue("lastName"),true),lastName);
        enterText(getElement(createAccountPageProp.getValue("email"),true),email);
        enterText(getElement(createAccountPageProp.getValue("password"),true),password);
        enterText(getElement(createAccountPageProp.getValue("passwordConfirm"),true),password);
        clickOnElement(createAccountPageProp.getValue("registerButton"), true);
    }

}
