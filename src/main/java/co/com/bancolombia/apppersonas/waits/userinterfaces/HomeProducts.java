package co.com.bancolombia.apppersonas.waits.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeProducts {

    public static Target SIMULATOR = Target.the("Simulator button").located(By.xpath("//*[@id=\"wizard1\"]/div/div[1]/div/div/div[1]/div[3]/a"));
}
