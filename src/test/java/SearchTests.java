import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

public class SearchTests extends BaseTest {


    @Test
    public void firstReference() {
        GooglePage google = new GooglePage(driver);
        String refer = "yandex.ru";
        google.findBySearchName(refer);
        Assert.assertTrue(google.isFirstAdLeadingTo(refer));
    }
}
