package Steps.Common;

import ExtensionPage.CommonMethod;
import ExtensionPage.ExcelHelpers;
import Locators.Common.SignUp_UI;
import Locators.Common.VerifyEmail_UI;
import Pages.Common.SignUp_Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SignUp_Step extends PageObject {

    CommonMethod method;
    SignUp_UI signUp_ui;
    SignUp_Page signUp_page;
    VerifyEmail_UI verifyEmail_ui;

    public ExcelHelpers excel = new ExcelHelpers();

    public void setExcel() throws Exception {
        excel.setExcelFile("src/test/resources/data/TestData.xlsx", "SignUpData");
    }

    @Given("^I want to open sign up page$")
    public void iWantToOpenSignUpPage() {
        signUp_page.openSignUpPage();
    }

    @When("^I want to enter all fields$")
    public void iWantToEnterAllFields() throws Exception {
        setExcel();
        signUp_page.enterAllFields(
                excel.getCellData(1, 1),
                excel.getCellData(1, 2),
                excel.getCellData(1, 3),
                excel.getCellData(1, 4),
                excel.getCellData(1, 5));
    }

    @And("^I click Sign Up button$")
    public void iClickSignUpButton() {
        method.click(signUp_ui.btnSignUpButton);
    }

    @Then("^The verify email page should show$")
    public void theVerifyEmailPageShouldShow() throws InterruptedException {
        Thread.sleep(8000);
        method.checkIsDisplay(verifyEmail_ui.txtVerifyEmail);
    }

    @When("^I leave all fields blank$")
    public void iLeaveAllFieldsBlank() {
    }

    @When("^I enter firstname and lastname contain blank space$")
    public void iEnterFirstnameAndLastnameContainBlankSpace() throws Exception {
        setExcel();
        signUp_page.enterNameFields(
                excel.getCellData(2, 1),
                excel.getCellData(2, 2));
    }

    @Then("^The error messages should show \"([^\"]*)\"$")
    public void theErrorMessagesShouldShow(String message) throws Throwable {
        method.compareEqual(message,method.getText(signUp_ui.errors.get(0)));
        method.compareEqual(message,method.getText(signUp_ui.errors.get(1)));
        method.compareEqual(message,method.getText(signUp_ui.errors.get(2)));
        method.compareEqual(message,method.getText(signUp_ui.errors.get(3)));
        method.compareEqual(message,method.getText(signUp_ui.errors.get(4)));
    }

    @Then("^The error message should be shown$")
    public void theErrorMessageShouldBeShown() {
        method.compareTrue(method.checkIsDisplay(signUp_ui.errFirebase));
    }

    @When("^I want to enter less than (\\d+) characters into Firstname and Lastname fields$")
    public void iWantToEnterLessThanCharactersIntoFirstnameAndLastnameFields(int two) throws Exception {
        setExcel();
        signUp_page.enterNameFields(
                excel.getCellData(3, 1),
                excel.getCellData(3, 2));
    }

    @Then("^That name fields's data should be added normally$")
    public void thatNameFieldsSDataShouldBeAddedNormally() {
        method.checkIsDisplay(signUp_ui.errMessageEmail);
        method.checkIsDisplay(signUp_ui.errMessagePassword);
        method.checkIsDisplay(signUp_ui.errMessageConfirmPassword);
    }

    @When("^I want to enter Firstname and Lastname contain special characters, numbers$")
    public void iWantToEnterFirstnameAndLastnameContainSpecialCharactersNumbers() throws Exception {
        setExcel();
        signUp_page.enterNameFields(
                excel.getCellData(4, 1),
                excel.getCellData(4, 2));
    }

    @Then("^The error message \"([^\"]*)\" should be shown below \"([^\"]*)\" field$")
    public void theErrorMessageShouldBeShownBelowField(String message, String field) throws Throwable {
        method.compareEqual(message,method.getText(signUp_ui.errors.get(0)));
        method.compareEqual(message,method.getText(signUp_ui.errors.get(1)));
    }

    @When("^I want to leave Firstname and Lastname fields blank$")
    public void iWantToLeaveFirstnameAndLastnameFieldsBlank() {}

    @When("^I want to enter Firstname and Lastname with (\\d+) characters$")
    public void iWantToEnterFirstnameAndLastnameWithCharacters(int arg0) throws Exception {
        setExcel();
        signUp_page.enterNameFields(
                excel.getCellData(5, 1),
                excel.getCellData(5, 2));
    }

    @When("^I want to enter Firstname and Lastname with more than (\\d+) characters$")
    public void iWantToEnterFirstnameAndLastnameWithMoreThanCharacters(int arg0) throws Exception {
        setExcel();
        signUp_page.enterNameFields(
                excel.getCellData(6, 1),
                excel.getCellData(6, 2));
    }

    @When("^I want to enter Firstname and Lastname with space characters$")
    public void iWantToEnterFirstnameAndLastnameWithSpaceCharacters() {
        method.enterData(signUp_ui.tbxFirstName, Keys.chord(Keys.SPACE,Keys.SPACE));
        method.enterData(signUp_ui.tbxLastName, Keys.chord(Keys.SPACE,Keys.SPACE));
    }

    @When("^I want to enter email contains blank space$")
    public void iWantToEnterEmailContainsBlankSpace() throws Exception {
        method.clear(signUp_ui.tbxEmail);
        setExcel();
        signUp_page.enterEmailField(excel.getCellData(7,3));
    }

    @When("^I want to enter all fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iWantToEnterAllFields(String firstname, String lastname, String email, String password, String confirmpassword) throws Throwable {
        signUp_page.enterAllFields(firstname,lastname,email,password,confirmpassword);
    }

    @When("^I want to enter an example email$")
    public void iWantToEnterAnExampleEmail() {
        method.enterData(signUp_ui.tbxEmail,"a@b");
        iClickSignUpButton();
        method.clear(signUp_ui.tbxEmail);
    }

    @Then("^The error message \"([^\"]*)\" should be shown below field$")
    public void theErrorMessageShouldBeShownBelowField(String message) throws Throwable {
        method.compareEqual(message,method.getText(signUp_ui.errors.get(2)));
    }

    @And("^I want to enter email without @ sign$")
    public void iWantToEnterEmailWithoutSign() throws Exception {
        setExcel();
        signUp_page.enterEmailField(excel.getCellData(9,3));
    }

    @When("^I want to enter a correct email with contains multiple dots$")
    public void iWantToEnterACorrectEmailWithContainsMultipleDots() throws Exception {
        setExcel();
        signUp_page.enterAllFields(
                excel.getCellData(10, 1),
                excel.getCellData(10, 2),
                excel.getCellData(10, 3),
                excel.getCellData(10, 4),
                excel.getCellData(10, 5));
    }

    @When("^I want to enter an email contains two @ sign$")
    public void iWantToEnterAnEmailContainsTwoSign() throws Exception {
        setExcel();
        signUp_page.enterEmailField(excel.getCellData(11,3));
    }

    @And("^I want to enter space charactes in Email field$")
    public void iWantToEnterSpaceCharactesInEmailField() {
        method.enterData(signUp_ui.tbxEmail,Keys.chord(Keys.SPACE,Keys.SPACE,Keys.SPACE));
    }

    @When("^I want to leave the email field blank$")
    public void iWantToLeaveTheEmailFieldBlank() {
    }

    @When("^I want to enter password data \"([^\"]*)\"$")
    public void iWantToEnterPasswordData(String data) throws Throwable {
        method.enterData(signUp_ui.tbxPassword,data);
    }

    @And("^I click 'Eye' icon to show password$")
    public void iClickEyeIconToShowPassword() {
        method.click(signUp_ui.btnShowPassword.get(0));
    }

    @And("^The data of the password field should be showed$")
    public void theDataOfThePasswordFieldShouldBeShowed() {
        method.compareTrue(method.getAttribute(signUp_ui.tbxPassword,"type").equals("text"));
    }

    @Then("^The data in password field is either visible as asterisk or bullet signs by default$")
    public void theDataInPasswordFieldIsEitherVisibleAsAsteriskOrBulletSignsByDefault() {
        method.compareTrue(method.getAttribute(signUp_ui.tbxPassword,"type").equals("password"));
    }

    @When("^I want to enter all fields except password field$")
    public void iWantToEnterAllFieldsExceptPasswordField() throws Exception {
        setExcel();
        signUp_page.enterAllFields(
                excel.getCellData(16, 1),
                excel.getCellData(16, 2),
                excel.getCellData(16, 3),
                excel.getCellData(16, 4),
                excel.getCellData(16, 5));
    }

    @Then("^The error message \"([^\"]*)\" should be shown below \"([^\"]*)\" field \"([^\"]*)\"$")
    public void theErrorMessageShouldBeShownBelowField(String message, String field, int index) throws Throwable {
        method.compareEqual(message,method.getText(signUp_ui.errors.get(index)));
    }

    @When("^I want to enter password missing (\\d+) of (\\d+) characters uppercase, number, special \"([^\"]*)\"$")
    public void iWantToEnterPasswordMissingOfCharactersUppercaseNumberSpecial(int one, int three, String data) throws Throwable {
        method.enterData(signUp_ui.tbxPassword,data);
    }

    @Then("^The error message \"([^\"]*)\" should show below Password field$")
    public void theErrorMessageShouldShowBelowPasswordField(String message,int a) throws Throwable {
        method.compareEqual(message,method.getText(signUp_ui.errors.get(3)));
    }

    @When("^I want to enter password \"([^\"]*)\" and confirm password \"([^\"]*)\"$")
    public void iWantToEnterPasswordAndConfirmPassword(String password, String confirmpassword) throws Throwable {
        method.enterData(signUp_ui.tbxPassword,password);
        method.enterData(signUp_ui.tbxConfirmPassword,confirmpassword);
    }

    @And("^I click 'Eye' icon of confirm password field$")
    public void iClickEyeIconOfConfirmPasswordField() {
        method.click(signUp_ui.btnShowPassword.get(1));
    }

    @Then("^The data of the confirm password field should be showed$")
    public void theDataOfTheConfirmPasswordFieldShouldBeShowed() {
        method.compareTrue(method.getAttribute(signUp_ui.tbxConfirmPassword,"type").equals("text"));
    }

    @When("^I want to enter confirm password \"([^\"]*)\"$")
    public void iWantToEnterConfirmPassword(String confirmpw) throws Throwable {
        method.enterData(signUp_ui.tbxConfirmPassword,confirmpw);
    }

    @Then("^The data in Confirm password field is either visible as asterisk or bullet signs by default$")
    public void theDataInConfirmPasswordFieldIsEitherVisibleAsAsteriskOrBulletSignsByDefault() {
        method.compareTrue(method.getAttribute(signUp_ui.tbxPassword,"type").equals("password"));
    }

    @When("^I click 'Log In Here' hyperlink$")
    public void iClickLogInHereHyperlink() throws InterruptedException {
        element(By.xpath("//a[contains(text(),'Log In Here')]")).click();
    }

    @Then("^The user should be navigate to page \"([^\"]*)\" with url \"([^\"]*)\"$")
    public void theUserShouldBeNavigateToPageWithUrl(String page, String url) throws Throwable {
        Thread.sleep(5000);
        method.compareEqual(url,method.getUrl());
    }

}
