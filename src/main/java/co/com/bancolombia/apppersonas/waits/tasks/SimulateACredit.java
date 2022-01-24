package co.com.bancolombia.apppersonas.waits.tasks;

import co.com.bancolombia.apppersonas.waits.interactions.ShouldWait;
import co.com.bancolombia.apppersonas.waits.interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static co.com.bancolombia.apppersonas.waits.userinterfaces.HomeProducts.SIMULATOR;
import static co.com.bancolombia.apppersonas.waits.userinterfaces.Menu.CASA;
import static co.com.bancolombia.apppersonas.waits.userinterfaces.Menu.NECESIDADES;
import static co.com.bancolombia.apppersonas.waits.userinterfaces.Simulator.*;
import static java.time.Duration.ofSeconds;
import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SimulateACredit implements Task {

    private final String creditValue;

    public SimulateACredit(Integer creditValue) {
        this.creditValue = creditValue.toString();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NECESIDADES),
                Click.on(CASA),
                ShouldWait.forTarget(SIMULATOR).noMoreThan(10).seconds().retryingEvery(1).seconds().ignoring(NoSuchElementException.class),
                Click.on(SIMULATOR),
                WaitFor.visibilityOf(TITLE).andStopIn(9, SECONDS),
                WaitUntil.the(MORTGAGE_CREDIT_OPTION, isVisible()).forNoMoreThan(8).seconds(),
                Click.on(MORTGAGE_CREDIT_OPTION),
                Click.on(APARTMENT_OPTION),
                Click.on(DEPENDS_ON_THE_PROPERTY_VALUE_OPTION),
                Click.on(FIXED_FEE_OPTION),
                Enter.theValue("5").into(TERM),
                Enter.theValue("1991-07-28").into(BIRTHDAY),
                Click.on(ANTIOQUIA_OPTION),
                Enter.theValue(creditValue).into(PROPERTY_VALUE),
                Ensure.that(SIMULATE_BUTTON.waitingForNoMoreThan(ofSeconds(10))).isDisplayed(),
                Click.on(SIMULATE_BUTTON)
        );
    }

    public static Performable worth(Integer creditValue) {
        return instrumented(SimulateACredit.class, creditValue);
    }
}
