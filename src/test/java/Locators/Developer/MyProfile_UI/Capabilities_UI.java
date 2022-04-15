package Locators.Developer.MyProfile_UI;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Capabilities_UI extends PageObject {

    @FindBy (css = "div[class='capability'] button[class='button_top']")
    public WebElementFacade btnEdit;

    @FindBy (className = "button_bottom")
    public WebElementFacade btnAddMore;

    @FindBy (className = "close modal-capabilities-button-close")
    public WebElementFacade btnClose;

    @FindBy (className = "modal-capabilities-button")
    public WebElementFacade btnFinish;

    @FindBy (className = "col-11")
    public WebElementFacade titlePopup;

    @FindBy (css = "#capabilities")
    public WebElementFacade txbSearch;

    @FindBy (css = "label[for='Automation Tester']")
    public WebElementFacade hashtag;

    @FindBy (css = ".label-capability.col-sm-2")
    public WebElementFacade selectedHashtag;

    @FindBy (className = " css-1umpx16") // css-n9lsfx-menu
    public WebElementFacade allHashtag;

    @FindBy (className = "MultiSelectField_seeMoreBtn__3J1ds")
    public WebElementFacade btnSeeMore;

}
