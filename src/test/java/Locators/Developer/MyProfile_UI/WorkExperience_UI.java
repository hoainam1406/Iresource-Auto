package Locators.Developer.MyProfile_UI;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class WorkExperience_UI extends PageObject {

    @FindBy (css = "button[type='button']")
    public WebElementFacade btnAddMore;

    //@FindBy (className = "button_top")
    @FindBy (xpath = "//div[contains(@class,'work-exper-parent')]//div[1]//button[1]")
    public WebElementFacade editIcon;

    @FindBy (className = "workexperiences-title")
    public WebElementFacade title;

    @FindBy (className = "work-exper-none-text")
    public WebElementFacade message;

    @FindBy (className = "Toastify__toast-body")
    public WebElementFacade message1;

    @FindBy (className = "errors")
    public WebElementFacade errors;

    @FindBy (className = "workexperiences-close")
    public WebElementFacade btnClose;

    @FindBy (id = "employer")
    public WebElementFacade txbEmployer;

    @FindBy (name = "startAt")
    public WebElementFacade txbFrom;

    @FindBy (name = "endAt")
    public WebElementFacade txbTo;

    @FindBy (id = "businessType")
    public WebElementFacade txbBusinessType;

    @FindBy (id = "position")
    public WebElementFacade txbPosition;

    @FindBy (id = "description")
    public WebElementFacade txbExperience;

    @FindBy (className = "workexperiences-btn__next")
    public WebElementFacade btnFinish;

}
