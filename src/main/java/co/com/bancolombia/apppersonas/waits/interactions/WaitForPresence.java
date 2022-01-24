package co.com.bancolombia.apppersonas.waits.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WithTimeUnits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * An implementation of the Serenity Screenplay {@link Interaction}
 * that wraps the use of {@link WebDriverWait}
 * This is an EXPLICIT WAIT and more specifically, an specialization of FLUENT WAIT. It's usage is
 * recommended when expecting an element to achieve the defined conditions.
 *
 * This class must be used ONLY as an example.
 *
 * As said in the {@link WebDriverWait} JAVADOC:
 * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
 * the 'until' condition, and immediately propagate all others. You can add more to the ignore
 * list by calling ignoring(exceptions to add).
 *
 * {@link WebDriverWait} constructors are overloaded. See documentation
 * for more examples.
 * A polling timeout can be defined. If not, default will be 0.5 SECONDS.
 **/

public class WaitForPresence implements Interaction {

    private final Target target;
    private final int time;

    private WaitForPresence(Target target, int time) {
        this.target = target;
        this.time = time;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        /*time must be in seconds*/
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(presenceOfElementLocated(By.xpath(target.resolveFor(actor).toString().split(" ")[1])));
    }

    public static class WaitForBuilder implements WithTimeUnits {

        private final Target target;
        private int time;

        WaitForBuilder(Target target) {
            this.target = target;
        }

        public WaitForBuilder noMoreThan(int time) {
            this.time = time;
            return this;
        }

        @Override
        public Performable seconds() {
            return new WaitForPresence(target, time);
        }

        @Override
        public Performable milliseconds() {
            return new WaitForPresence(target, time/1000);
        }
    }
}
