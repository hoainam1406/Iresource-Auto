package Pages.Developer.MyProfile_Page;

import ExtensionPage.CommonMethod;
import Locators.Developer.MyProfile_UI.WorkExperience_UI;
import net.serenitybdd.core.pages.PageObject;

public class WorkExperience_Section extends PageObject {

    WorkExperience_UI workExper_ui;
    CommonMethod method;

    public void enterAllFields(String employer, String fromDate, String toDate, String businessType, String position, String experience ){
        method.enterData(workExper_ui.txbEmployer,employer);
        method.enterData(workExper_ui.txbFrom,fromDate);
        method.enterData(workExper_ui.txbTo,toDate);
        method.enterData(workExper_ui.txbBusinessType,businessType);
        method.enterData(workExper_ui.txbPosition,position);
        method.enterData(workExper_ui.txbExperience,experience);
    }

    public String getFromDate(){
      return method.getAttribute(workExper_ui.txbFrom,"value");
    }

    public String getToDate(){
        return method.getAttribute(workExper_ui.txbFrom,"value");
    }
}
