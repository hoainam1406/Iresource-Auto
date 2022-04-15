package Locators.ProjectManager;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProfileCreation_UI extends PageObject {
    //textbox
    @FindBy (name = "firstName")
    public WebElementFacade tbxFirstName;

    @FindBy (name = "lastName")
    public WebElementFacade tbxLastName;

    //button
    @FindBy (css = "button[class='btn btn-md my-3 modal-info-person-button'][type = 'submit'")
    public WebElementFacade btnFinish;

    //error message
    @FindBy (css = "div[class='align-items-end row'] div:nth-child(1) div:nth-child(1)")
    public WebElementFacade errFirstName;

    @FindBy (css = "div[class='align-items-end row'] div:nth-child(2) div:nth-child(1)")
    public WebElementFacade errLastName;

    @FindBy (css = "#position+.errors")
    public WebElementFacade errPosition;

    @FindBy (css = "#contractualTerm+.errors")
    public WebElementFacade errContractualTerm;

    @FindBy (css = "#location+.errors")
    public WebElementFacade errLocation;

    @FindBy (css = "#division+.errors")
    public WebElementFacade errDivision;

    @FindBy (css = ".create-persona-title")
    public  WebElementFacade titleProfile;





    //dropdown
    @FindBy (css = "#position")
    public WebElementFacade ddlPosition;


    @FindBy (css = "div[id='contractualTerm'] div[class='custom-select__control css-yk16xz-control']")
    public WebElementFacade ddlContractualTerm;

    @FindBy (css = "#division")
    public WebElementFacade ddlDivision;

    @FindBy (css = "#location")
    public WebElementFacade ddlLocation;

    //items
    @FindBy (xpath = "//div[contains(text(),'Product Owner')]")
    public WebElementFacade productOwner;

    @FindBy (xpath = "//div[contains(text(),'Scrum Master')]")
    public WebElementFacade scrumMaster;

    @FindBy (xpath = "//div[contains(text(),'Project Management')]")
    public WebElementFacade projectManagement;

    @FindBy (xpath = "//div[contains(text(),'Fulltime employee')]")
    public WebElementFacade fullTimeEmployee;

    @FindBy (xpath = "//div[contains(text(),'Parttime employee')]")
    public WebElementFacade partTimeEmployee;

    @FindBy (xpath = "//div[contains(text(),'Contract employee')]")
    public WebElementFacade contractEmployee;


    @FindBy (xpath = "//div[contains(text(),'SmartDev Vietnam')]")
    public WebElementFacade smdVietNam;

    @FindBy (xpath = "//div[contains(text(),'SmartDev England')]")
    public WebElementFacade smdEndland;

    @FindBy (xpath = "//div[contains(text(),'Da Nang')]")
    public WebElementFacade daNang;

    @FindBy (xpath = "//div[contains(text(),'Ha Noi')]")
    public WebElementFacade haNoi;

    @FindBy (xpath = "//div[contains(text(),'London')]")
    public WebElementFacade london;

    @FindBy (css= "div[class='Toastify__toast-body'][role='alert']")
    public WebElementFacade msgSuccess;


}
