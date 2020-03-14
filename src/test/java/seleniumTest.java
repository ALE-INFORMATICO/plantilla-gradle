import cl.falabella.gradle.loginPO;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static cl.falabella.Utils.testMethods.takeSnapShot;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class seleniumTest {

    WebDriver driver;
    loginPO loginPO;

    @BeforeAll
    public void SetUp() {
        PropertyConfigurator.configure("./src/test/resources/log4j.properties");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe"); //Chromedriver versión 79.0.3945.36
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        this.loginPO = PageFactory.initElements(driver, loginPO.class);
    }

    @AfterEach
    public void afterEach(TestInfo testinfo) throws Exception {
        takeSnapShot(this.driver, testinfo.getDisplayName());
    }

    @Test
    @Order(1)
    @DisplayName("Ingreso de datos en cuadro de búsqueda")
    public void IniciaChrome() {
        driver.get("https://www.google.cl");
        loginPO.getCampoDeBusqueda().sendKeys("Apple");
    }

    @Test
    @Order(2)
    @DisplayName("Hacer click en botón de búsqueda")
    public void haceClick() {
        loginPO.getBtnBusqueda().click();
    }

    @AfterAll
    public void cierraNavegador(){
        driver.close();
    }
}
