package subscriberFieldTest;

import org.junit.Before;
import org.junit.Test;
import parentTest.Tests;

public class SubscriberFieldTest extends Tests {
    String fieldName = "qwerty";
    String fieldTag = "zxcv";

    @Before
    public void goToPage() {
        loginpage.login();
        pages.openContactDropDown();
        pages.goToSubscriberListPageButton();
        subscriberListPage.goToSubscriberFieldPage();
    }

    @Test
    public void addNewField() {
        subscriberFieldPage.clickCreateNewFeildButton()
                .inputFieldName(fieldName)
                .inputFieldTag(fieldTag)
                .clickSubmitCreateFieldButton();
        checkAC("Can't find new field in grid",
                subscriberFieldPage.isNewAddedFieldVisible(fieldTag), true);
        subscriberFieldPage.deleteAddedField();
    }

    @Test
    public void deleteField() {
        subscriberFieldPage.clickCreateNewFeildButton()
                .inputFieldName(fieldName)
                .inputFieldTag(fieldTag)
                .clickSubmitCreateFieldButton()
                .deleteAddedField();
        checkAC("Can't find new field in grid",
                subscriberFieldPage.isNewAddedFieldVisible(fieldName), false);
    }
}