package Pages.Common;

import ExtensionPage.CommonMethod;
import ExtensionPage.ExcelHelpers;
import Locators.Common.Login_UI;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://iresource.smartdev.vn/login")
public class Login_Page extends PageObject {

    Login_UI login_ui;
    CommonMethod method;

    public ExcelHelpers excel = new ExcelHelpers();

    public void setExcel() throws Exception {
        excel.setExcelFile("src/test/resources/data/TestData.xlsx","LoginData");
    }
    public void openLoginPage(){
        open();
    }

    public void enterEmailPasswordField(String email, String password){
        method.enterData(login_ui.tbxEmail,email);
        method.enterData(login_ui.tbxPassword,password);
    }

    public void enterEmail(String email){
        method.enterData(login_ui.tbxEmail,email);
    }

    public void enterPassword(String password){
        method.enterData(login_ui.tbxPassword,password);
    }

    public void enterAllFields(String email, String password){
        method.enterData(login_ui.tbxEmail,email);
        method.enterData(login_ui.tbxPassword,password);
    }

    public void enterDataFromDataset(int a) throws Exception {
        setExcel();
        enterAllFields(
                excel.getCellData(a, 1),
                excel.getCellData(a, 2));
    }

    public String getCellData(int a, int b) throws Exception {
        setExcel();
        return excel.getCellData(a, b);
    }

}

