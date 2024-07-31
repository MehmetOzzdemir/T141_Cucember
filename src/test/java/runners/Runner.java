package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;



@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/feautures/wip")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "stepdefinitions")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@wip")

public class Runner {
    /*
        Cucumber da istenen feature/scenerio lari calistirmak icin kullandigimiz
        Runner class i BOS bir class dir

        Istedigimiz classlari belirlemek
        calisan class lara rapor eklemek
        ve feature dosyalari ile stepdefinitions class larini irtibatlandirmak icin
        notasyonlar kullanacagiz

     */
}
