package tests;

import org.junit.jupiter.api.Test;
import pages.FormPage;
import utils.UsersFaker;


public class FormPageTests extends TestBase {
    FormPage formPage = new FormPage();
    UsersFaker usersFaker = new UsersFaker();
    @Test
    void formPageFillTest() {
        formPage.openPage()
                .removeBan()
                .setUserName(usersFaker.firstName + " " + usersFaker.lastName)
                .setEmail(usersFaker.userEmail)
                .setCurrentAdress(usersFaker.adress)
                .setPermanentAdress(usersFaker.adressPermanent)
                .submit()
                .checkOutputName(usersFaker.firstName + " " + usersFaker.lastName)
                .checkOutputEmail(usersFaker.userEmail)
                .setCurrentAdress(usersFaker.adress)
                .checkOutputPermanenrAdress(usersFaker.adressPermanent);

    }

}




