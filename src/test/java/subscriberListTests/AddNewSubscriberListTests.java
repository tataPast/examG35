package subscriberListTests;

import org.junit.Before;
import org.junit.Test;
import pages.NewListPage;
import parentTest.ParentTest;

public class AddNewSubscriberListTests extends ParentTest {
    String listName = "qwerty";

    @Before
    public void goToPage(){
        loginpage.login();
        parentPage.openContactDropDown();
        parentPage.goToSubscriberListPageButton();
    }

    @Test
    public void addNewSubscriberList(){
        subscriberListPage.openCreateNewListPopUp();
        subscriberListPage.inputListName(listName);
        subscriberListPage.submitNewListCreation();

        checkAC("Can't find new added list in grid", subscriberListPage.isNewListInGrid(), true);
        String id = subscriberListPage.getId();
        id = id.replace("ID: ","");
        NewListPage newListPage = new NewListPage(webDriver, "/ru/subscriber/list/2766313/"+id);
        newListPage.deleteList();


    }

    @Test
    public void deleteNewAddedList(){
        subscriberListPage.openCreateNewListPopUp();
        subscriberListPage.inputListName(listName);
        subscriberListPage.submitNewListCreation();

        String id = subscriberListPage.getId();
        id = id.replace("ID: ","");
        NewListPage newListPage = new NewListPage(webDriver, "/ru/subscriber/list/2766313/"+id);
        newListPage.deleteList();

        checkAC("Can't find new added list in grid", subscriberListPage.isNewListInGrid(), false);

    }


}