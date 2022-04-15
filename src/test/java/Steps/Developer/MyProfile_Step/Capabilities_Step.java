package Steps.Developer.MyProfile_Step;

import ExtensionPage.CommonMethod;
import Locators.Developer.MyProfile_UI.Capabilities_UI;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class Capabilities_Step extends PageObject {
    CommonMethod method;
    Capabilities_UI capabilities_ui;

    @When("^I click on Edit button$")
    public void iClickOnEditButton() throws InterruptedException {
        method.scrollDown(capabilities_ui.btnEdit);
        Thread.sleep(1000);
        method.click(capabilities_ui.btnEdit);
    }

    @Then("^The popup shows with \"([^\"]*)\"$")
    public void thePopupShowsWith(String title) {
        method.compareEqual(title, method.getText(capabilities_ui.titlePopup));
    }

    @When("^I click on Add more button$")
    public void iClickOnAddMoreButton() throws InterruptedException {
        method.scrollDown(capabilities_ui.btnAddMore);
        Thread.sleep(1000);
        method.click(capabilities_ui.btnAddMore);
    }

    @And("^Enter \"([^\"]*)\" into Search field$")
    public void enterIntoSearchField(String value) {
        method.enterData(capabilities_ui.txbSearch, value);
    }

    @Then("^The hashtag with \"([^\"]*)\" show correctly$")
    public void theHashtagWithShowCorrectly(String value) {
        method.getAttribute(capabilities_ui.hashtag, value);
    }

    @And("^I click on hashtag of capability$")
    public void iClickOnHashtagOfCapability() {
        method.click(capabilities_ui.hashtag);
    }

    @Then("^The hashtag is selected correctly$")
    public void theHashtagIsSelectedCorrectly() {
        method.checkIsDisplay(capabilities_ui.selectedHashtag);
        method.compareEqual("Automation Tester", method.getText(capabilities_ui.selectedHashtag));
    }

    @And("^I click on 'See more' button$")
    public void iClickOnSeeMoreButton() {
        method.click(capabilities_ui.btnSeeMore);
    }

    @Then("^All capabilities show correctly$")
    public void allCapabilitiesShowCorrectly() {
        method.checkIsDisplay(capabilities_ui.allHashtag);
    }

}
