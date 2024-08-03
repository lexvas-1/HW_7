package tests;

import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormPageTests extends TestBase {
    FormPage formPage = new FormPage();

    @Test
    void formPageFillTest() {
        formPage.openPage()
                .removeBan()
                .setUserName("Alex")
                .setEmail("my@email.ru")
                .setCurrentAdress("Current, 12")
                .setPermanentAdress("Permanent. 14")
                .submit()
                .checkOutputName("Alex")
                .checkOutputEmail("my@email.ru")
                .setCurrentAdress("Current, 12")
                .checkOutputPermanenrAdress("Permanent. 14");

    }

}




