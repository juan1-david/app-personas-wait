package co.com.bancolombia.apppersonas.waits.stepdefinitions;

import co.com.bancolombia.apppersonas.waits.tasks.SimulateACredit;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.bancolombia.apppersonas.waits.userinterfaces.Simulator.VIDEO;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CreditSimulatorStepDefinitions {

    private final String JENN = "Jenn";

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Jenn simulate a mortgage loan worth {int}")
    public void actorSimulateAMortgageLoan(Integer creditValue) {

        theActorCalled(JENN).attemptsTo(
                Open.url("https://www.grupobancolombia.com/personas"),
                SimulateACredit.worth(creditValue)
        );
    }

    @Then("she should see a video with the simulation detail")
    public void actorShouldSeeAVideoWithTheSimulationDetail() {
        theActorInTheSpotlight().should(eventually(seeThat(the(VIDEO), isVisible())).waitingForNoLongerThan(5).seconds());
    }

}
