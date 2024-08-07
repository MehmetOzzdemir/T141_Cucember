package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Guru99Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class Guru99StepDefinitions {

    Guru99Page guru99Page = new Guru99Page();

    @Given("{string} , sutunundaki degerleri yazdirir")
    public void sutunundaki_degerleri_yazdirir(String istenenSutunBasligi) {

        List<String> basliklarList = ReusableMethods.stringListChange(guru99Page.baslikElementleriList);

        int sutunIndex = basliklarList.indexOf(istenenSutunBasligi);

        //tablodaki sutunlarin dinamik xpath ini bulamaliyiz
        //(//tbody)[2]/tr/td[ ]

        String dinamikXpath = "(//tbody)[2]/tr/td[" + (sutunIndex + 1) + "]";

        List<WebElement> istenenSutundakiWebElementListesi =
                Driver.getDriver().findElements(By.xpath(dinamikXpath));

        System.out.println(ReusableMethods.stringListChange(istenenSutundakiWebElementListesi));

    }

    @Given("tum sayfa screenshot alip {string} ismi ile kaydeder")
    public void tum_sayfa_screenshot_alip_ismi_ile_kaydeder(String raporAdiStr) throws IOException {
        ReusableMethods.allPageScreenshot(Driver.getDriver(), raporAdiStr);
    }

}
