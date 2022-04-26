package Steps.Common;


import ExtensionPage.CommonMethod;
import ExtensionPage.ExcelHelpers;
import Locators.Common.Login_UI;
import Locators.Common.NavigationBar;
import Locators.Common.ResetPassword_UI;
import Pages.Common.Login_Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Login_Step extends PageObject {

    Login_UI login_ui;
    Login_Page login_Page;
    NavigationBar navigationBar;
    CommonMethod method;

    @Given("^I want to open login page$")
    public void iWantToOpenLoginPage() {
        login_Page.openLoginPage();
    }

    @When("^I enter valid Email and Password less than (\\d+) characters$")
    public void iEnterValidEmailAndPasswordLessThanCharacters(int four) throws Exception {
       login_Page.enterDataFromDataset(12);
    }

    @And("^I want to enter valid email and password \\(initial login\\)$")
    public void iWantToEnterValidEmailAndPasswordInitialLogin() throws Exception {
        login_Page.enterDataFromDataset(1);
    }

    @And("^I click Login button$")
    public void iClickLoginButton() {
        method.click(login_ui.btnLogin);
    }

    @Then("^The error message below \"([^\"]*)\" field should be shown \"([^\"]*)\"$")
    public void theErrorMessageBelowShouldBeShown(String field, String message) throws Throwable {
        method.compareEqual(message,method.getText(login_ui.errMessage.get(0)));
    }

    @And("^I want to enter valid email and password \\(subsequent login\\)$")
    public void iWantToEnterValidEmailAndPasswordSubsequentLogin() throws Exception {
        login_Page.enterDataFromDataset(2);
    }

    @When("^I enter valid Email and invalid Password$")
    public void iEnterValidEmailAndInvalidPassword() throws Exception {
        login_Page.enterDataFromDataset(13);
    }

    @Then("^The error message \"([^\"]*)\" should be shown$")
    public void theErrorMessageShouldBeShown(String message) throws Throwable {
        method.compareTrue(method.checkIsDisplay(login_ui.msgError));
    }

    @When("^I enter valid Email$")
    public void iEnterValidEmail() throws Exception {
        login_Page.enterDataFromDataset(14);
    }

    @When("^I only enter Password field$")
    public void iOnlyEnterPasswordField() throws Exception {
        login_Page.enterDataFromDataset(16);
    }

    @Then("^The data in password field should be visible as asterisk orr bullet signs$")
    public void theDataInPasswordFieldShouldBeVisibleAsAsteriskOrrBulletSigns() {
        method.compareTrue(method.getAttribute(login_ui.tbxPassword,"type").equals("password"));
    }

    @Then("^I click 'Eye' icon$")
    public void iClickEyeIcon() {
        method.click(login_ui.btnShowPassword);
    }

    @Then("^The data of the password field should be shown$")
    public void theDataOfThePasswordFieldShouldBeShown() {
        method.compareTrue(method.getAttribute(login_ui.tbxPassword,"type").equals("text"));
    }

    @When("^I want to enter data \"([^\"]*)\" into fields$")
    public void iWantToEnterDataIntoFields(String data) throws Throwable {
        login_Page.enterEmailPasswordField(data,data);
    }

    @And("^I want to remove data by using backspace or delete keys$")
    public void iWantToRemoveDataByUsingBackspaceOrDeleteKeys() throws AWTException {
        method.enterData(login_ui.tbxEmail,Keys.chord(Keys.BACK_SPACE));
//        method.pressBackspaceKeyUsingRobot();
        method.enterData(login_ui.tbxPassword,Keys.chord(Keys.BACK_SPACE));
//        method.pressBackspaceKeyUsingRobot();
    }

    @Then("^The data should be removed \"([^\"]*)\"$")
    public void theDataShouldBeRemoved(String newData) throws Throwable {
        method.compareEqual(newData,login_ui.tbxEmail.getAttribute("value"));
        method.compareEqual(newData,login_ui.tbxPassword.getAttribute("value"));
    }

    @When("^I want to enter invalid data into fields$")
    public void iWantToEnterInvalidDataIntoFields() throws Exception {
        login_Page.enterDataFromDataset(5);
    }

    @When("^I enter valid Email and Password$")
    public void iEnterValidEmailAndPassword() throws Exception {
        login_Page.enterDataFromDataset(18);
    }

    @And("^I click on 'Remember Me' checkbox$")
    public void iClickOnRememberMeCheckbox() {
        method.click(login_ui.btnRememberMe);
    }

    @And("^I click 'Log out' button$")
    public void iClickLogOutButton() {
        method.click(navigationBar.btnLogout);
    }

    @Then("^User should be redirected to Log in page and Username and Password should be saved$")
    public void userShouldBeRedirectedToLogInPageAndUsernameAndPasswordShouldBeSaved() throws Exception {
        method.compareEqual(login_Page.getCellData(18,1),method.getAttribute(login_ui.tbxEmail,"value"));
        method.compareEqual(login_Page.getCellData(18,2),method.getAttribute(login_ui.tbxPassword,"value"));
    }

    @And("^I enter Email field without domain$")
    public void iEnterEmailFieldWithoutDomain() throws Exception {
        login_Page.enterDataFromDataset(6);
    }
    @Then("^The error message \"([^\"]*)\" should be shown below each field$")
    public void theErrorMessageShouldBeShownBelowEachField(String message) throws Throwable {
        method.compareEqual(message,method.getText(login_ui.errMessage.get(0)));
        method.compareEqual(message,method.getText(login_ui.errMessage.get(1)));
    }

    @Then("^The error message should show$")
    public void theErrorMessageShouldShow() {
        System.out.println( getAlert().getText());
    }

    @And("^I want to enter email contains two @ sign and valid Password$")
    public void iWantToEnterEmailContainsTwoSignAndValidPassword() throws Exception {
        login_Page.enterDataFromDataset(7);
    }

    @Then("^The error message should show and user is stay in login page \"([^\"]*)\"$")
    public void theErrorMessageShouldShowAndUserIsStayInLoginPage(String url) throws Throwable {
        method.compareEqual(url,method.getUrl());
    }

    @And("^I want to enter email without @$")
    public void iWantToEnterEmailWithout() throws Exception {
        login_Page.enterDataFromDataset(8);

    }

    @And("^I leave the email field blank and enter valid password$")
    public void iLeaveTheEmailFieldBlankAndEnterValidPassword() throws Exception {
        login_Page.enterDataFromDataset(9);
    }

    @Then("^The user will be redirected to Profile creation page with url \"([^\"]*)\" if it is initial login$")
    public void theUserWillBeRedirectedToProfileCreationPageWithUrlIfItIsInitialLogin(String url) throws Throwable {
        method.compareEqual(url,method.getUrl());
    }

    @Then("^The user will be redirected to corresponding page \"([^\"]*)\" with url \"([^\"]*)\"$")
    public void theUserWillBeRedirectedToCorrespondingPageWithUrl(String page, String url){
        method.compareEqual(url,method.getUrl());
    }

    @And("^I want to enter the email contains multiple consecutive dots$")
    public void iWantToEnterTheEmailContainsMultipleConsecutiveDots() throws Exception {
        login_Page.enterDataFromDataset(10);
    }

    @And("^I want to enter an unregistered email$")
    public void iWantToEnterAnUnregisteredEmail() throws Exception {
        login_Page.enterDataFromDataset(11);
    }

    @When("^I click on ‘Forgot Password’ hyperlink$")
    public void iClickOnForgotPasswordHyperlink() {
        method.click(login_ui.linkForgotPassword);
    }

    @Then("^User should be redirected to \"([^\"]*)\" page with \"([^\"]*)\"$")
    public void userShouldBeRedirectedToPageWith(String page, String url) throws Throwable {
        method.compareEqual(url,method.getUrl());
    }

    @When("^I click on SignUp here hyperlink$")
    public void iClickOnSignUpHereHyperlink() {
        method.click(login_ui.btnSignUpHere);
    }

    @And("^I use the enter key$")
    public void iUseTheEnterKey() {
        method.enterData(login_ui.btnLogin,Keys.chord(Keys.ENTER));
    }

    @And("^I want to enter valid email and password \\(PM role initial login\\)$")
    public void iWantToEnterValidEmailAndPasswordPMRoleInitialLogin() throws Exception {
        login_Page.enterDataFromDataset(19);
    }

    @And("^I want to enter valid email and password \\(PM role subsequent login\\)$")
    public void iWantToEnterValidEmailAndPasswordPMRoleSubsequentLogin() throws Exception {
        login_Page.enterDataFromDataset(20);
    }

}

