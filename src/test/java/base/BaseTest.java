package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import util.WebDriverUtil;

public class BaseTest {

    private Logger log = Logger.getLogger(BaseTest.class);
    private String currentScenarioName = "";


    @BeforeScenario
    public void setup(ExecutionContext context){
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
        currentScenarioName = context.getCurrentScenario().getName().toUpperCase();
        log.info(String.format("**************** %s Senaryosu Başladı ****************", currentScenarioName));
        startTheTest();
    }


    @AfterScenario
    public void tearDown(){
        try {
            WebDriverUtil.getInstance().getWebDriver().close();
            WebDriverUtil.getInstance().getWebDriver().quit();
            log.info(String.format("**************** %s Senaryosu Bitti ****************", currentScenarioName));
        }catch (Exception e){
            log.error(String.format("Driver kapatılırken hata oluştu! '%s'", currentScenarioName));
        }
    }


    public void startTheTest(){
        WebDriverUtil
                .getInstance()
                .startTheTest();
    }
}
