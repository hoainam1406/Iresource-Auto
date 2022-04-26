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
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class SignUp_Step extends PageObject {

    CommonMethod method;
    SignUp_UI signUp_ui;
    SignUp_Page signUp_page;
    VerifyEmail_UI verifyEmail_ui;

    @Given("^I want to open sign up page$")
    public void iWantToOpenSignUpPage() {
        signUp_page.openSignUpPage();
    }

    @When("^I want to enter all fields$")
    public void iWantToEnterAllFields() throws Exception {
        signUp_page.enterDataFromDataset(1);
    }

    @And("^I click Sign Up button$")
    public void iClickSignUpButton() {
        method.click(signUp_ui.btnSignUpButton);
    }

    @Then("^The verify email page should show$")
    public void theVerifyEmailPageShouldShow(){
        method.implicitlyWait(8);
        method.checkIsDisplay(verifyEmail_ui.txtVerifyEmail);
    }

    @When("^I leave all fields blank$")
    public void iLeaveAllFieldsBlank() {
    }

    @Then("^The error messages should show \"([^\"]*)\"$")
    public void theErrorMessagesShouldShow(String message)  {
        method.compareList(message,signUp_ui.errErrors,5);
    }

    @When("^I enter all data \"([^\"]*)\" into all fields$")
    public void iEnterAllDataIntoAllFields(String data){
        signUp_page.enterAllFields(data,data,data,data,data);
    }

    @And("^I press backspace or delete keys in password and email fields$")
    public void iPressBackspaceOrDeleteKeysInPasswordAndEmailFields(){
        signUp_page.pressDeleteOrBackspace();
    }

    @Then("^The data should be removed normally \"([^\"]*)\"$")
    public void theDataShouldBeRemovedNormally(String newdata){
        signUp_page.compareData (newdata);
    }

    @When("^I want to enter Firstname \"([^\"]*)\" and Lastname \"([^\"]*)\"$")
    public void iWantToEnterFirstnameAndLastname(String firstname, String lastname){
        signUp_page.enterNameFields(firstname, lastname);
    }

    @Then("^The data should be added normally \"([^\"]*)\"$")
    public void theDataShouldBeAddedNormally(String size){
        method.compareEqual(size,method.getSize(signUp_ui.errErrors));
    }

    @Then("^The error message should be shown$")
    public void theErrorMessageShouldBeShown() {
        method.compareTrue(method.checkIsDisplay(signUp_ui.errFirebase));
    }

    @Then("^The error message \"([^\"]*)\" should be shown below \"([^\"]*)\" field$")
    public void theErrorMessageShouldBeShownBelowField(String message, String field){
        method.compareList(message,signUp_ui.errErrors,2);
    }

    @When("^I want to leave Firstname and Lastname fields blank$")
    public void iWantToLeaveFirstnameAndLastnameFieldsBlank() {}

    @When("^I want to enter email \"([^\"]*)\" \"([^\"]*)\"$")
    public void iWantToEnterEmail(String email, String text){
        signUp_page.enterEmailField(email);
    }

    @When("^I want to enter an example email$")
    public void iWantToEnterAnExampleEmail() {
        method.enterData(signUp_ui.tbxEmail,"a@b");
        iClickSignUpButton();
        method.clear(signUp_ui.tbxEmail);
    }

    @When("^I want to enter all fields with an already registered email$")
    public void iWantToEnterAllFieldsWithAnAlreadyRegisteredEmail() throws Exception {
        signUp_page.enterDataFromDataset(2);
    }

    @Then("^The error message \"([^\"]*)\" should be shown below field$")
    public void theErrorMessageShouldBeShownBelowField(String message){
        method.compareEqual(message,method.getText(signUp_ui.errErrors.get(2)));
    }

    @When("^I want to enter a correct email with contains multiple dots$")
    public void iWantToEnterACorrectEmailWithContainsMultipleDots() throws Exception {
        signUp_page.enterDataFromDataset(3);
    }

    @When("^I want to leave the email field blank$")
    public void iWantToLeaveTheEmailFieldBlank() {
    }

    @When("^I want to enter password data \"([^\"]*)\"$")
    public void iWantToEnterPasswordData(String data){
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
        signUp_page.enterDataFromDataset(4);
    }

    @Then("^The error message \"([^\"]*)\" should be shown below \"([^\"]*)\" field \"([^\"]*)\"$")
    public void theErrorMessageShouldBeShownBelowField(String message, String field, int index){
        method.compareEqual(message,method.getText(signUp_ui.errErrors.get(index)));
    }

    @When("^I want to enter password missing (\\d+) of (\\d+) characters uppercase, number, special \"([^\"]*)\"$")
    public void iWantToEnterPasswordMissingOfCharactersUppercaseNumberSpecial(int one, int three, String data)  {
        method.enterData(signUp_ui.tbxPassword,data);
    }

    @When("^I want to enter password \"([^\"]*)\" and confirm password \"([^\"]*)\"$")
    public void iWantToEnterPasswordAndConfirmPassword(String password, String confirmpassword){
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
    public void iWantToEnterConfirmPassword(String confirmpw){
        method.enterData(signUp_ui.tbxConfirmPassword,confirmpw);
    }

    @When("^I click 'Log In Here' hyperlink$")
    public void iClickLogInHereHyperlink(){
        method.click(signUp_ui.btnLogInHere.get(1));
    }

    @Then("^The user should be navigate to page \"([^\"]*)\" with url \"([^\"]*)\"$")
    public void theUserShouldBeNavigateToPageWithUrl(String page, String url){
        method.compareEqual(url,method.getUrl());
    }

    @When("^I click Project Manager button$")
    public void iClickProjectManagerButton() {
        method.click(signUp_ui.cbxProjectCreator);
    }


}
