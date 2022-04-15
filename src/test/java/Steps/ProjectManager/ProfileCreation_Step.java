package Steps.ProjectManager;

import ExtensionPage.CommonMethod;
import Locators.ProjectManager.ManageProject_UI;
import Locators.ProjectManager.ProfileCreation_UI;
import Pages.ProjectManager.ProfileCreation_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;

public class ProfileCreation_Step extends PageObject {
    ProfileCreation_Page profileCreation_page;
    ManageProject_UI manageProject_ui;
    ProfileCreation_UI profileCreation_ui;
    CommonMethod method;

    @Given("^I want to open Profile Creation page after initial login$")
    public void iWantToOpenProfileCreationPageAfterInitialLogin() throws Exception {
        profileCreation_page.openProfileCreationPage();
    }

    @When("^I click the Finish button on Profile Creation page$")
    public void iClickTheFinishButtonOnProfileCreationPage() {
        method.click(profileCreation_ui.btnFinish);
    }

    @Then("^The error \"([^\"]*)\" and \"([^\"]*)\" are shown below the name fields$")
    public void theErrorAndAreShownBelowTheNameFields(String message1, String message2) {
        method.compareEqual(message1, method.getText(profileCreation_ui.errFirstName));
        method.compareEqual(message2, method.getText(profileCreation_ui.errLastName));
    }

    @When("^I enter spaces in Firstname field$")
    public void iEnterSpacesInFirstnameField() {
        method.enterData(profileCreation_ui.tbxFirstName, Keys.chord(Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE));
    }


    @Then("^The error message is shown below the Firstname field$")
    public void theErrorMessageIsShownBelowTheFirstnameField() throws Exception {
        //  System.out.println(method.checkIsDisplay(profileCreation_ui.errFirstName));
        //  Assert.assertTrue("Assertion Failed: Message", method.checkIsDisplay(profileCreation_ui.errFirstName));
        // method.compareTrue(method.checkIsDisplay(profileCreation_ui.errFirstName));
        if (profileCreation_ui.errFirstName.isDisplayed() == true) {
            System.out.println("Pass");
            System.out.println(profileCreation_ui.errFirstName.getText());
        } else
            System.out.println("Failed");
//        try {
//            profileCreation_ui.errFirstName.isDisplayed();
//            System.out.println("Pass");
//            System.out.println(profileCreation_ui.errFirstName.getText());
//        }
//        catch (NoSuchElementException e) {
//            throw new RuntimeException("This is where you put the message");
//        }
    }
    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\" on Profile Creation page$")
    public void iEnterAndOnProfileCreationPage(String firstName, String lastName) {
        method.enterData(profileCreation_ui.tbxFirstName, firstName);
        method.enterData(profileCreation_ui.tbxLastName, lastName);
    }

    @And("^I select Position$")
    public void iSelectPosition(){
        method.click(profileCreation_ui.ddlPosition);
        method.click(profileCreation_ui.productOwner);
    }

    @And("^I select Contractual Term$")
    public void iSelectContractualTerm() {
        method.click(profileCreation_ui.ddlContractualTerm);
        method.click(profileCreation_ui.fullTimeEmployee);
    }

    @And("^I select Division$")
    public void iSelectDivision() {
        method.click(profileCreation_ui.ddlDivision);
        method.click(profileCreation_ui.smdVietNam);
    }

    @And("^I select Location$")
    public void iSelectLocation(){
        method.click(profileCreation_ui.ddlLocation);
        method.click(profileCreation_ui.daNang);
    }

    @Then("^The Manage Project page is shown with \"([^\"]*)\"$")
    public void theManageProjectPageIsShownWith(String title) {
        method.compareEqual(title, method.getText(manageProject_ui.titleManageProjects));
    }


    @Then("^The \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" are displayed correctly in box$")
    public void theAreDisplayedCorrectlyInBox(String position, String contractualTerm, String division, String location) {
        method.compareEqual(position, method.getText(profileCreation_ui.productOwner));
        method.compareEqual(contractualTerm, method.getText(profileCreation_ui.fullTimeEmployee));
        method.compareEqual(division, method.getText(profileCreation_ui.smdVietNam));
        method.compareEqual(location, method.getText(profileCreation_ui.daNang));

    }

    @Then("^The error \"([^\"]*)\" is shown below the Position field$")
    public void theErrorIsShownBelowThePositionField(String message) {
        method.compareEqual(message, method.getText(profileCreation_ui.errPosition));
    }

    @Then("^The error \"([^\"]*)\" is shown below the Contractual Term field$")
    public void theErrorIsShownBelowTheContractualTermField(String message) {
        method.compareEqual(message, method.getText(profileCreation_ui.errContractualTerm));
    }

    @Then("^The error \"([^\"]*)\" is shown below the Division field$")
    public void theErrorIsShownBelowTheDivisionField(String message){
        method.compareEqual(message, method.getText(profileCreation_ui.errDivision));
    }

    @Then("^The error \"([^\"]*)\" is shown below the Location field$")
    public void theErrorIsShownBelowTheLocationField(String message)  {
        method.compareEqual(message, method.getText(profileCreation_ui.errLocation));
    }

    @And("^I select Product Owner$")
    public void iSelectProductOwner() {
        method.click(profileCreation_ui.ddlPosition);
        method.click(profileCreation_ui.productOwner);

    }

    @And("^I reselect Scrum Master$")
    public void iReselectScrumMaster()  {
        method.click(profileCreation_ui.ddlPosition);
        method.click(profileCreation_ui.scrumMaster);
    }

    @Then("^The Scrum Master is displayed correctly in the box$")
    public void theScrumMasterIsDisplayedCorrectlyInTheBox() {
        method.compareEqual("Scrum Master", method.getText(profileCreation_ui.scrumMaster));
    }

    @And("^I select SmartDev England division$")
    public void iSelectSmartDevEnglandDivision() {
        method.click(profileCreation_ui.ddlDivision);
        method.click(profileCreation_ui.smdEndland);
    }

    @And("^The London location is shown in the Location box$")
    public void theLondonLocationIsShownInTheLocationBox() {

    }


}
