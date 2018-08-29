package subscriberListTests;

import org.junit.Before;
import org.junit.Test;
import pages.NewListPage;
import parentTest.Tests;

public class AddNewSubscriberListTests extends Tests {
    String listName = "qwerty";

    @Before
    public void goToPage() {
        loginpage.login();
        pages.openContactDropDown();
        pages.goToSubscriberListPageButton();
    }

    @Test
    public void addNewSubscriberList() {
        subscriberListPage.openCreateNewListPopUp()
                .inputListName(listName)
                .submitNewListCreation();
        checkAC("Can't find new added list in grid", subscriberListPage.isNewListInGrid(), true);
        subscriberListPage.goToNewListPage();
        newListPage.deleteList();
    }

    @Test
    public void deleteNewAddedList() {
        NewListPage newListPage = subscriberListPage.openCreateNewListPopUp()
                .inputListName(listName)
                .submitNewListCreation()
                .goToNewListPage();
        newListPage.deleteList();
        checkAC("Can't find new added list in grid", subscriberListPage.isNewListInGrid(), false);
    }
}