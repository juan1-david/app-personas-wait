package co.com.bancolombia.apppersonas.waits.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Menu {

    public static Target NECESIDADES = Target.the("Needs option menu").located(By.id("menu-necesidades"));
    public static Target CASA = Target.the("Home option").located(By.id("header-necesidades-casa"));
}
