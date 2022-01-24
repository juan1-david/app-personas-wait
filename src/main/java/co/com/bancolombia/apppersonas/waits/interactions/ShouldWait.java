package co.com.bancolombia.apppersonas.waits.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

/**
 * An implementation of the Serenity Screenplay {@link Interaction}
 * that wraps the use of {@link FluentWait}
 * This is a FLUENT WAIT. Its usage is recommended when expecting an element to achieve some conditions
 * after an amount of time.
 *
 * This class must be used ONLY as an example.
 * More parameters can be added, as a message for an exception, for example.
 *
 * For Fluent Waits:
 * DEFAULT WAIT TIME = 0.5 seconds
 * DEFAULT RETRY TIME = 0.5 seconds
 **/

 public class ShouldWait implements Interaction {

    private final Target target;
    private final int secondsOfWaiting;
    private final int secondsOfRetry;
    private final Class<? extends Throwable> exceptionToIgnore;

    private ShouldWait(Target target, int secondsOfWaiting, int secondsOfRetry, Class<? extends Throwable> exceptionToIgnore) {
        this.target = target;
        this.secondsOfWaiting = secondsOfWaiting;
        this.secondsOfRetry = secondsOfRetry;
        this.exceptionToIgnore = exceptionToIgnore;
    }

    public static ShouldWaitBuilder forTarget(Target target) {
        return new ShouldWaitBuilder(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(secondsOfWaiting))
                .pollingEvery(Duration.ofSeconds(secondsOfRetry)).ignoring(exceptionToIgnore);

        wait.until(driver1 -> driver1.findElement(By.xpath(target.resolveFor(actor).toString().split(" ")[1])));
    }

    public static class ShouldWaitBuilder {

        private final Target target;
        private int secondsOfWaiting;
        private int secondsOfRetry;

        ShouldWaitBuilder(Target target) {
            this.target = target;
        }

        public ShouldWaitBuilder retryingEvery(int secondsOfRetry) {
            this.secondsOfRetry = secondsOfRetry;
            return this;
        }

        public ShouldWaitBuilder noMoreThan(int secondsOfWaiting) {
            this.secondsOfWaiting = secondsOfWaiting;
            return this;
        }

        public ShouldWaitBuilder seconds() {
            return this;
        }

        public ShouldWait ignoring(Class<? extends Throwable> exceptionType) {
            return new ShouldWait(target, secondsOfWaiting, secondsOfRetry, exceptionType);
        }
    }

}
