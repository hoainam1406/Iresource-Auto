package Steps.Developer.MyProfile_Step;

import ExtensionPage.CommonMethod;
import Locators.Developer.MyProfile_UI.WorkExperience_UI;
import Pages.Developer.MyProfile_Page.WorkExperience_Section;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;

public class WorkExperience_Step extends PageObject {

    CommonMethod method;
    WorkExperience_UI workExper_ui;
    WorkExperience_Section workExper_section;


    @When("^I go to Work experience section and click on Add more button$")
    public void iGoToWorkExperienceSectionAndClickOnAddMoreButton()  throws InterruptedException {
        method.scrollDown(workExper_ui.btnAddMore);
        Thread.sleep(1000);
        method.click(workExper_ui.btnAddMore);
    }

    @Then("^The popup shows \"([^\"]*)\"$")
    public void thePopupShows(String title) {
        method.compareEqual(title, method.getText(workExper_ui.title));
    }

    @When("^I go to Work experience section$")
    public void iGoToWorkExperienceSection() {
        method.scrollDown(workExper_ui.message);
    }

    @Then("^The \"([^\"]*)\" shows correctly$")
    public void theShowsCorrectly(String message){
        method.compareEqual(message, method.getText(workExper_ui.message));
    }

    @And("^I click on 'Finish' button$")
    public void iClickOnFinishButton() {
        method.click(workExper_ui.btnFinish);
    }

    @Then("^The error message should show under that fields \"([^\"]*)\"$")
    public void theErrorMessageShouldShowUnderThatFields(String error) {
        method.compareEqual(error, method.getText(workExper_ui.errors));
    }

    @And("^I enter space characters in employer, business type, position and experience field$")
    public void iEnterSpaceCharactersInEmployerBusinessTypePositionAndExperienceField() {
        method.enterData(workExper_ui.txbEmployer, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbFrom, "01/12/2021");
        method.enterData(workExper_ui.txbTo, "31/03/2022");
        method.enterData(workExper_ui.txbBusinessType, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbPosition, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbExperience, String.valueOf(Keys.SPACE));
    }

    @And("^I enter space characters in From & To date field$")
    public void iEnterSpaceCharactersInFromToDateField() {
        method.enterData(workExper_ui.txbEmployer, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbFrom, "01/12/2021");
        method.enterData(workExper_ui.txbTo, "31/03/2022");
        method.enterData(workExper_ui.txbBusinessType, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbPosition, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbExperience, String.valueOf(Keys.SPACE));
    }

    @And("^I enter in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" fields and space characters with From & To date field$")
    public void iEnterInFieldsAndSpaceCharactersWithFromToDateField(String employer, String businessType, String position, String experience) {
        method.enterData(workExper_ui.txbEmployer, employer);
        method.enterData(workExper_ui.txbFrom, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbTo, String.valueOf(Keys.SPACE));
        method.enterData(workExper_ui.txbBusinessType, businessType);
        method.enterData(workExper_ui.txbPosition, position);
        method.enterData(workExper_ui.txbExperience, experience);
    }

    @And("^I enter in \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" fields$")
    public void iEnterInFields(String employer, String fromDate, String toDate, String businessType, String position, String experience) {
        workExper_section.enterAllFields(employer,fromDate,toDate,businessType,position,experience);
    }

    @Then("^The \"([^\"]*)\" should show correctly$")
    public void theShouldShowCorrectly(String message1) {
        method.compareEqual(message1, method.getText(workExper_ui.message1));
    }

    @When("^I go to Work experience section and click on Edit button$")
    public void iGoToWorkExperienceSectionAndClickOnEditButton() throws InterruptedException {
        method.scrollDown(workExper_ui.editIcon);
        Thread.sleep(1000);
        method.click(workExper_ui.editIcon);
    }

    @And("^I edit \"([^\"]*)\" and \"([^\"]*)\" with text$")
    public void iEditAndWithText(String fromDate, String toDate) throws InterruptedException {
        method.clear(workExper_ui.txbFrom);
        //method.enterData(workExper_ui.txbFrom, fromDate);

        method.clear(workExper_ui.txbTo);
        //method.enterData(workExper_ui.txbTo, toDate);

        Thread.sleep(50000);
    }

    @Then("^The date automatically changed according to the correct format$")
    public void theDateAutomaticallyChangedAccordingToTheCorrectFormat() throws InterruptedException {
        method.compareEqual(workExper_section.getFromDate(),method.getText(workExper_ui.txbFrom));
    }

}
