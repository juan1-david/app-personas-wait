package co.com.bancolombia.apppersonas.waits.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

/**
 * An example implementation of the Serenity {@link Interaction}
 * that wraps the use of {@link net.serenitybdd.core.pages.WebElementFacade#withTimeoutOf(Duration)}
 * This is an EXPLICIT WAIT. It's usage is recommended when expecting an element to achieve the defined conditions.
 *
 * This class must be used ONLY as an example.
 *
 * Refer to class JAVADOC for more usages.
 *
 * The polling timeout is defined by default as 0.1 SECONDS.
 **/

public class WaitForVisibility implements Interaction {

    private final Target target;
    private final int time;
    private final TemporalUnit timeUnit;

    private WaitForVisibility(Target target, int time, TemporalUnit timeUnit) {
        this.target = target;
        this.time = time;
        this.timeUnit = timeUnit;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).withTimeoutOf(time, timeUnit).waitUntilVisible();
    }

    public static class WaitForBuilder {

        private final Target target;

        WaitForBuilder(Target target) {
            this.target = target;
        }

        public WaitForVisibility andStopIn(int time, TemporalUnit timeUnit) {
            return new WaitForVisibility(target, time, timeUnit);
        }
    }
}
