package Pages.ProjectManager;

import ExtensionPage.CommonMethod;
import ExtensionPage.ExcelHelpers;
import Locators.Common.Login_UI;
import Pages.Common.Login_Page;
import net.serenitybdd.core.pages.PageObject;

public class ProfileCreation_Page extends PageObject {
    Login_Page login_page;
    Login_UI login_ui;
    CommonMethod method;

    public ExcelHelpers excel = new ExcelHelpers();
    public void setExcel() throws Exception {
        excel.setExcelFile("src/test/resources/data/TestData.xlsx", "LoginData");
    }
    public void openProfileCreationPage() throws Exception {
        setExcel();
        login_page.openLoginPage();
        login_page.enterAllFields(
                excel.getCellData(20, 1),
                excel.getCellData(20, 2));
        method.click(login_ui.btnLogin);
    }
}
