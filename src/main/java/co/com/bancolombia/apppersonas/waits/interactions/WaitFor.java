package co.com.bancolombia.apppersonas.waits.interactions;

import net.serenitybdd.screenplay.targets.Target;

public class WaitFor {

    public static WaitForPresence.WaitForBuilder presenceOf(Target target) {
        return new WaitForPresence.WaitForBuilder(target);
    }

    public static WaitForVisibility.WaitForBuilder visibilityOf(Target target) {
        return new WaitForVisibility.WaitForBuilder(target);
    }

}
