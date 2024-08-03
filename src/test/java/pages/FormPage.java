package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAdressInput = $("#currentAddress");
    private final SelenideElement permanentAdressInput = $("#permanentAddress");
    private final SelenideElement submit = $("#submit");
    private final SelenideElement outputUserName = $("#output").$("#name");
    private final SelenideElement outputEmail = $("#output").$("#email");
    private final SelenideElement outputCurrentAdress = $("#output").$("#currentAddress");
    private final SelenideElement outputPermanentAdress = $("#output").$("#permanentAddress");

    public FormPage openPage() {
        open("/text-box");
        $("h1").shouldHave(text("Text Box"));

        return this;
    }

    public FormPage removeBan() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public FormPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public FormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public FormPage setCurrentAdress(String value) {
        currentAdressInput.setValue(value);

        return this;
    }

    public FormPage setPermanentAdress(String value) {
        permanentAdressInput.setValue(value);

        return this;
    }

    public FormPage submit() {
        submit.click();

        return this;
    }

    public FormPage checkOutputName(String value) {
        outputUserName.shouldHave(text(value));

        return this;
    }

    public FormPage checkOutputEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public FormPage checkOutputCurrentAdress(String value) {
        outputCurrentAdress.shouldHave(text(value));

        return this;
    }

    public FormPage checkOutputPermanenrAdress(String value) {
        outputPermanentAdress.shouldHave(text(value));

        return this;
    }
}