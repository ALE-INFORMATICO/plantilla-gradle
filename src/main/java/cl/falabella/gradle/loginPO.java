package cl.falabella.gradle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page Object que permite identificar elementos de la página Detalle de un cliente, luego de apretán botón "ver Detalle"
 * @URL: url de la página
 * @author: Nombre Autor
 * @date: Fecha
 * @version: Versión
 */
public class loginPO {

    @FindBy(how = How.NAME, using = "q")
    private WebElement campoDeBusqueda;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement btnBusqueda;

    // Getter y Setter de los elementos

    public WebElement getCampoDeBusqueda() {
        return campoDeBusqueda;
    }

    public WebElement getBtnBusqueda() {
        return btnBusqueda;
    }
}
