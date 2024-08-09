package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelStepdefinitions {

    Sheet sayfa1;
    String istenenHucredekiBilgi;

    static Map<String, Map<String, String>> ulkelerMapi;


    @Given("kullanici baskentler exceline ulasir")
    public void kullanici_baskentler_exceline_ulasir() throws IOException {
        String filepath = "src/test/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("Sayfa1");
    }

    @Then("{int}.satir {int}.hucredeki datayi yazdirir")
    public void satirHucredekiDatayiYazdirir(int rowNumber, int cellNumber) {
        istenenHucredekiBilgi = sayfa1
                .getRow(rowNumber - 1)
                .getCell(cellNumber - 1).toString();
        System.out.println(istenenHucredekiBilgi);

    }

    @And("{int}.satir {int}.hucredeki datayi bir string degiskene kaydeder")
    public void satirHucredekiDatayiBirStringDegiskeneKaydeder(Integer rowNumber, Integer cellNumber) {
        istenenHucredekiBilgi = sayfa1
                .getRow(rowNumber - 1)
                .getCell(cellNumber - 1).toString();
    }

    @And("kaydedilen datanin {string} oldugunu test eder")
    public void kaydedilenDataninOldugunuTestEder(String expectedHucre) {
        Assertions.assertEquals(expectedHucre, istenenHucredekiBilgi);
    }

    @Then("baskenti Jakarta olan ulkenin Turkce isminin {string} oldugunu test eder")
    public void baskentiJakartaOlanUlkeninTurkceIsmininOldugunuTestEder(String expectedTurkceUlkeIsmi) {


        String satirdakiBaskentName;
        String satirdakiTurkceUlkeName;

        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {
            satirdakiBaskentName = sayfa1.getRow(i)
                    .getCell(1).toString();

            if (satirdakiBaskentName.equalsIgnoreCase("Jakarta")) {
                satirdakiTurkceUlkeName = sayfa1.getRow(i).getCell(2).toString();
                Assertions.assertEquals(expectedTurkceUlkeIsmi, satirdakiTurkceUlkeName);
            }
        }
    }

    @And("excelde kayitli ulke sayisinin {int} oldugunu test eder")
    public void exceldeKayitliUlkeSayisininOldugunuTestEder(int expectedCountryNumber) {
        int actualCountryNumber = sayfa1.getLastRowNum(); //son satirin index i
        //index den kullanilan satir sayisina gecmek icin +1 yapmaliyiz
        //baslik satiri ulke olmadigi ndan onu cikarmaliyiz -1
        Assertions.assertEquals(expectedCountryNumber, actualCountryNumber);
    }

    @And("excelde kullanilan fiziki satir sayisinin {int} oldugunu test eder")
    public void exceldeKullanilanFizikiSatirSayisininOldugunuTestEder(int expectedKullanilanSatirSayisi) {
        //int actualKullanilanSatirSayisi =sayfa1.getLastRowNum()+1;
        int actualKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi, actualKullanilanSatirSayisi);

    }

    @When("Tum bilgileri map olarak kaydedip")
    public void tumBilgileriMapOlarakKaydedip() {

        /*Map'i Nested Map olarak olusturmaya karar verdik

            { ulkeIsmiIngilizce = geriyeKalanBilgilerMapi }

            icerdeki map ise
            { "Başkent (İngilizce)"="Baku", "Ülke (Türkçe)"="Azerbaycan",  "Başkent (Türkçe)"="Baku"}

         {
            Afghanistan={baskentIng=Kabul, baskentTurkce=Kabil, ulkeTurkce=Afganistan},
            Albania={baskentIng=Tirana, baskentTurkce=Tiran, ulkeTurkce=Arnavutluk},
            Algeria={baskentIng=Aljiers, baskentTurkce=Cezayir, ulkeTurkce=Cezayir},
            Andorra={baskentIng=Andorra la Vella, baskentTurkce=Andorra la Vella, ulkeTurkce=Andorra}


         */

        ulkelerMapi = new TreeMap<>();
        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {
            Map<String, String> geriyeKalanBilgilerMapi = new TreeMap<>();
            String englishCountryName = sayfa1.getRow(i).getCell(0).toString();
            String englishCenterName = sayfa1.getRow(i).getCell(1).toString();
            String turkishCountryName = sayfa1.getRow(i).getCell(2).toString();
            String turkishCenterName = sayfa1.getRow(i).getCell(3).toString();

            geriyeKalanBilgilerMapi.put("centerEng", englishCenterName);
            geriyeKalanBilgilerMapi.put("countryTurkish", turkishCountryName);
            geriyeKalanBilgilerMapi.put("centerTurkish", turkishCenterName);

            ulkelerMapi.put(englishCountryName, geriyeKalanBilgilerMapi);

        }
        //System.out.println(ulkelerMapi);


    }

    @Then("baskenti Jakarta olan ulkenin tum bilgilerini yazdirir")
    public void baskentiJakartaOlanUlkeninTumBilgileriniYazdirir() {

        //map yapisi geregi key ve valuleri ayri ayri bize getirir

        ulkelerMapi.keySet(); //key leri Set olarak getirir
        ulkelerMapi.values(); //value leri bir Collection olarak getirir
        ulkelerMapi.entrySet(); //key ve value leri birlestirip Entry olarak getirir

        //baskent ismi jakarta olan ulkenin tum bilgilerini yazdirmak icin
        //key ve vale ye ihtiyacimiz var

        Set<String> ulkelerMapiKeySeti = ulkelerMapi.keySet();
        // [Afghanistan, Albania, Algeria, Andorra, Angola,......]

        for (String ulkeIsmi : ulkelerMapiKeySeti
        ) {

            // ulkeIsminin value'sundeki ingilizce baskent ismi jakarta mi diye bakalim
            String ulkeninIngilizceBaskenti = ulkelerMapi.get(ulkeIsmi).get("centerEng");

            if (ulkeninIngilizceBaskenti.equalsIgnoreCase("Jakarta")) {

                System.out.println(
                        "ulke ingilizce ismi  : " + ulkeIsmi +
                                "\nulke ingilizce baskenti : " + ulkeninIngilizceBaskenti +
                                "\nulke turkce ismi : " + ulkelerMapi.get(ulkeIsmi).get("countryTurkish") +
                                "\nulke turkce baskent : " + ulkelerMapi.get(ulkeIsmi).get("centerTurkish")

                );
            }

        }

    }

    @And("mapi kullanarak turkce ismi Hollanda olan bir ulke bulundugunu test eder")
    public void mapiKullanarakTurkceIsmiHollandaOlanBirUlkeBulundugunuTestEder() {
        // sadece var olup olmadigi bilgisine ihtiyac var
        // turkce ulke ismi value'lerde oldugu icin sadece value'lere odaklanabiliriz

        Collection<Map<String, String>> valuesCollection = ulkelerMapi.values();

        /*

            [
               {baskentIng=Kabul, baskentTurkce=Kabil, ulkeTurkce=Afganistan},
               {baskentIng=Tirana, baskentTurkce=Tiran, ulkeTurkce=Arnavutluk},
               {baskentIng=Aljiers, baskentTurkce=Cezayir, ulkeTurkce=Cezayir}
         */

        boolean hollandaVarMi = false;

        for (Map<String, String> eachUlkeMapi : valuesCollection
        ) {

            if (eachUlkeMapi.containsValue("Hollanda")) {
                hollandaVarMi = true;
            }
        }

        Assertions.assertTrue(hollandaVarMi);

    }
}
