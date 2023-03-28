package pages;

import data.CustomUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ModalDialogPage {

    private WebDriver driver;

    public ModalDialogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "create-user")
    private WebElement createNewUserButton;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Create an account')]")
    private WebElement createNewAccountButton;

    @FindBy(css = "#users > tbody > tr")
    private List<WebElement> listOfAddedUsers;

    public ModalDialogPage clickCreateNewUserButton() {
        createNewUserButton.click();
        return this;
    }

    public ModalDialogPage fillCreateNewUserForm(CustomUser customUser) {
        return fillCreateNewUserForm(customUser.name(), customUser.email(), customUser.password());
    }

    public ModalDialogPage fillCreateNewUserForm(String name, String email, String password) {
        clearAndFillField(nameField, name);
        clearAndFillField(emailField, email);
        clearAndFillField(passwordField, password);
        return this;
    }

    public ModalDialogPage clickCreateNewAccountButton() {
        createNewAccountButton.click();
        return this;
    }

    public List<WebElement> getListOfAddedUsers() {
        return listOfAddedUsers;
    }

    private void clearAndFillField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
