package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "gLFyf")
    private WebElement searchField;

    @FindBy(className = "V0MxL")
    private WebElement firstAd;

    @FindBy(css = "div.r > a")
    private WebElement firstReference;

    public void findBySearchName(String searchName) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(searchName);
        searchField.sendKeys(Keys.ENTER);
    }

    public String getFirstAd() {
        try {
            return firstAd.getAttribute("data-preconnect-urls");
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getFirstReference() {
        try {
            return firstReference.getAttribute("href");
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isFirstAdLeadingTo (String reference) {
        return getFirstAd().contains(reference) || getFirstReference().contains(reference);
    }

}
