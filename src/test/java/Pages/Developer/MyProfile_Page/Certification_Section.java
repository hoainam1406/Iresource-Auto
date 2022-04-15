package Pages.Developer.MyProfile_Page;

import ExtensionPage.CommonMethod;
import Locators.Common.Login_UI;
import Locators.Developer.MyProfile_UI.Certification_UI;
import Pages.Common.Login_Page;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://iresource.smartdev.vn/login")
public class Certification_Section extends PageObject {
    Login_Page login_page;
    Login_UI login_ui;
    CommonMethod method;
    Certification_UI certification_ui;

    public void openMyProfilePage() {
        login_page.openLoginPage();
        method.enterData(login_ui.tbxEmail,"vivian.le@mailsac.com");
        method.enterData(login_ui.tbxPassword,"Vivian@1234");
        method.click(login_ui.btnLogin);
        method.click(certification_ui.navigationBar);
    }
}
