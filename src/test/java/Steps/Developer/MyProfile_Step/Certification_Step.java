package Steps.Developer.MyProfile_Step;

import ExtensionPage.CommonMethod;
import Locators.Developer.MyProfile_UI.Certification_UI;
import Pages.Developer.MyProfile_Page.Certification_Section;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;


public class Certification_Step extends PageObject {

    CommonMethod method;
    Certification_Section myProfile_page;
    Certification_UI certification_ui;

    @Given("^I want to open My Profile page$")
    public void iWantToOpenMyProfilePage() {
        myProfile_page.openMyProfilePage();
    }

    @When("^I click on Newcomer icon$")
    public void iClickOnNewcomerIcon() {
        method.click(certification_ui.communityIcon);
    }

    @Then("^The popup show with \"([^\"]*)\"$")
    public void thePopupShowWith(String title) {
        method.compareEqual(title,method.getText(certification_ui.title));
    }

    @And("^I click on X icon$")
    public void iClickOnXIcon() {
        method.click(certification_ui.closeIcon);
    }

    @Then("^The popup disappear and show \"([^\"]*)\" section$")
    public void thePopupDisappearAndShowSection(String header) {
        method.compareEqual(header,method.getText(certification_ui.badgeHeader));
    }

    @And("^I click on Finish button$")
    public void iClickOnFinishButton() {
        method.click(certification_ui.btnFinish);
    }

    @Then("^The error message should be shown with \"([^\"]*)\"$")
    public void theErrorMessageShouldBeShownWith(String error)  {
        method.compareEqual(error, method.getText(certification_ui.errors));
    }

    @And("^I enter certification name with space characters$")
    public void iEnterCertificationNameWithSpaceCharacters() {
        method.enterData(certification_ui.txbName, String.valueOf(Keys.SPACE));
    }

    @And("^I enter certification name with \"([^\"]*)\"$")
    public void iEnterCertificationNameWith(String text) {
        method.enterData(certification_ui.txbName,text);
    }

    @Then("^The \"([^\"]*)\" should be shown$")
    public void theShouldBeShown(String message) {
        method.compareEqual(message, method.getText(certification_ui.message));
    }

    @When("^I click on X icon beside$")
    public void iClickOnXIconBeside() {
        method.click(certification_ui.xIcon);
    }

    @And("^I click on Delete button$")
    public void iClickOnDeleteButton() {
        method.click(certification_ui.btnDelete);
    }

    @And("^I click on Cancel button$")
    public void iClickOnCancelButton() {
        method.click(certification_ui.btnCancel);
    }

    @Then("^The certification still shows$")
    public void theCertificationStillShows() {
        method.getAttribute(certification_ui.certiItem, "Information Technology");
    }
}
