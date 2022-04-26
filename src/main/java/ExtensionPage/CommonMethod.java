package ExtensionPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethod extends PageObject {

    public void click(WebElement element) {
        element.click();
    }

    public void enterData(WebElement element, String content){
        element.sendKeys(content);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void clear(WebElement element){
        element.clear();
    }

    public boolean checkSelected(WebElement element){
       return element.isSelected();
    }

    public boolean checkIsDisplay(WebElement element) {
        return element.isDisplayed();
    }

    public void checkIsEnable(WebElement element){
        element.isEnabled();
    }

    public String getAttribute( WebElement element, String value){
      return element.getAttribute(value);
    }

    public void RefreshPage() {
        getDriver().navigate().refresh();
    }

    public String getUrl(){
        return getDriver().getCurrentUrl();
    }

    public void compareEqual(String expected, String actual) {
        Assert.assertEquals(expected,actual);
    }

    public boolean compareFalse(boolean conditionF) {
        Assert.assertFalse(conditionF);
        return false;
    }

    public boolean compareTrue(boolean conditionT) {
        Assert.assertTrue(conditionT);
        return true;
    }

    public String getTextValue(WebElement element){
        return element.getText();
    }

    public String getFile(){
        return new File("files/photo-1541963463532-d68292c34b19.jpeg").getAbsolutePath();
    }

    public void scrollDown(WebElement element){
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    public void scrollUp(){
        ((JavascriptExecutor)
                getDriver()).executeScript("window.scrollTo(0, document.body.scrollTop);");
    }

    public void pressBackspaceKeyUsingRobot() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    public void pressBackspace(WebElement element){
        element.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }

    public void pressSpace(WebElement element, int a){
        for (int i = 0; i < a ; i++) {
            element.sendKeys(Keys.chord(Keys.SPACE));
        }
    }

    public String getSize(List<WebElementFacade> elementFacades){
       return String.valueOf(elementFacades.size());
    }

    public void waitElementVisibility(WebElement element, int a){
        WebDriverWait wait = new WebDriverWait(getDriver(),a );
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitlyWait(int a){
        getDriver().manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
    }

    public void compareList(String message, List <WebElementFacade> elementFacade, int a){
        for (int i = 0; i < a ; i++) {
            compareEqual(message,getText(elementFacade.get(i)));
        }
    }


}