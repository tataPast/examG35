package subscriberFieldTest;

import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class SubscriberFieldTest extends ParentTest {
    String fieldName = "qwerty";
    String fieldTag = "zxcv";

    @Before
    public void goToPage(){
        loginpage.login();
        parentPage.openContactDropDown();
        parentPage.goToSubscriberListPageButton();
        subscriberListPage.goToSubscriberFieldPage();
    }

    @Test
    public void addNewField(){
        subscriberFieldPage.clickCreateNewFeildButton();
        subscriberFieldPage.inputFieldName(fieldName);
        subscriberFieldPage.inputFieldTag(fieldTag);
        subscriberFieldPage.clickSubmitCreateFieldButton();
        checkAC("Can't find new field in grid",
                subscriberFieldPage.isNewAddedFieldVisible(fieldTag), true);
        subscriberFieldPage.deleteAddedField();
    }

    @Test
    public void deleteField(){
        subscriberFieldPage.clickCreateNewFeildButton();
        subscriberFieldPage.inputFieldName(fieldName);
        subscriberFieldPage.inputFieldTag(fieldTag);
        subscriberFieldPage.clickSubmitCreateFieldButton();
        subscriberFieldPage.deleteAddedField();
        checkAC("Can't find new field in grid",
                subscriberFieldPage.isNewAddedFieldVisible(fieldName), false);
    }
}