package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/feautures")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "stepdefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@smoke")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-report/CucumberReportJson2.json")


public class ParalelRunner2 {
    /*
        Cucumber da istenen feature/scenerio lari calistirmak icin kullandigimiz
        Runner class i BOS bir class dir

        Istedigimiz classlari belirlemek
        calisan class lara rapor eklemek
        ve feature dosyalari ile stepdefinitions class larini irtibatlandirmak icin
        notasyonlar kullanacagiz


         dry run = true secildiginde kodlari calistirmaya gayret etmez
                       SADECE eksik adim var mi diye kontrol eder
                       ve varsa eksik adimlari bizim icin olusturur
                       Eksik adim yoksa KODLARI CALISTIRMAZ,
                       eksik adim kalmadigini soylemek icin test passed yazdirir
     */
}
