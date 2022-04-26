package Pages.Common;

import ExtensionPage.CommonMethod;
import ExtensionPage.ExcelHelpers;
import Locators.Common.SignUp_UI;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

@DefaultUrl("https://iresource.smartdev.vn/signup")

public class SignUp_Page extends PageObject {

    SignUp_UI signUp_ui;
    CommonMethod method;

    public void openSignUpPage(){
        open();
    }
    public ExcelHelpers excel = new ExcelHelpers();
    public void setExcel() throws Exception {
        excel.setExcelFile("src/test/resources/data/TestData.xlsx", "SignUpData");
    }

    public void enterAllFields(String firstname, String lastname, String email, String password, String confirmpassword ){
        method.enterData(signUp_ui.tbxFirstName,firstname);
        method.enterData(signUp_ui.tbxLastName,lastname);
        method.enterData(signUp_ui.tbxEmail,email);
        method.enterData(signUp_ui.tbxPassword,password);
        method.enterData(signUp_ui.tbxConfirmPassword,confirmpassword);
    }

    public void enterEmailField(String email){
        method.enterData(signUp_ui.tbxEmail,email);
    }

    public void enterNameFields(String firstname, String lastname){
        method.enterData(signUp_ui.tbxFirstName,firstname);
        method.enterData(signUp_ui.tbxLastName,lastname);
    }

    public void pressDeleteOrBackspace(){
        method.pressBackspace(signUp_ui.tbxFirstName);
        method.pressBackspace(signUp_ui.tbxLastName);
        method.pressBackspace(signUp_ui.tbxEmail);
        method.pressBackspace(signUp_ui.tbxPassword);
        method.pressBackspace(signUp_ui.tbxConfirmPassword);
    }

    public void compareData(String data){
        method.compareEqual(data,method.getAttribute(signUp_ui.tbxFirstName,"value"));
        method.compareEqual(data,method.getAttribute(signUp_ui.tbxLastName,"value"));
        method.compareEqual(data,method.getAttribute(signUp_ui.tbxEmail,"value"));
        method.compareEqual(data,method.getAttribute(signUp_ui.tbxPassword,"value"));
        method.compareEqual(data,method.getAttribute(signUp_ui.tbxConfirmPassword,"value"));
    }

    public void enterDataFromDataset(int a) throws Exception {
        setExcel();
        enterAllFields(
                excel.getCellData(a, 1),
                excel.getCellData(a, 2),
                excel.getCellData(a, 3),
                excel.getCellData(a, 4),
                excel.getCellData(a, 5));

    }


}
