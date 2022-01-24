package co.com.bancolombia.apppersonas.waits.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Simulator {

    public static Target TITLE = Target.the("Simulator title").located(By.xpath("//*[@id=\"for-detail\"]/div[1]/h1"));
    public static Target MORTGAGE_CREDIT_OPTION = Target.the("Mortgage credit option").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[2]/select/option[2]"));
    public static Target APARTMENT_OPTION = Target.the("Apartment credit destination option").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[3]/div[1]/select/option[2]"));
    public static Target DEPENDS_ON_THE_PROPERTY_VALUE_OPTION = Target.the("Depends on the property value option").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[3]/div[2]/select/option[2]"));
    public static Target FIXED_FEE_OPTION = Target.the("Fixed fee option").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[3]/div[3]/select/option[2]"));
    public static Target TERM = Target.the("Term input field").located(By.name("textPlazoAnios"));
    public static Target BIRTHDAY = Target.the("Birthday input field").located(By.name("dateFechaNacimiento"));
    public static Target ANTIOQUIA_OPTION = Target.the("Antioquia option").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[3]/div[4]/div[3]/select/option[3]"));
    public static Target PROPERTY_VALUE = Target.the("Property value input field").located(By.id("bieninmueble"));
    public static Target SIMULATE_BUTTON = Target.the("Simulate Button").located(By.xpath("//*[@id=\"sim-detail\"]/div/button"));
    public static Target VIDEO = Target.the("Video").located(By.id("video-section"));
}
