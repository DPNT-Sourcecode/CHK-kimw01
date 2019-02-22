package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionR1Test {
    private CheckoutSolution checkout;

    @Before
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void checkout(){
        assertThat(checkout.checkout("3A"), equalTo(130));
        assertThat(checkout.checkout("2B"), equalTo(45));
        assertThat(checkout.checkout("6A"), equalTo(260));
        assertThat(checkout.checkout("4B"), equalTo(90));
        assertThat(checkout.checkout("5A"), equalTo(230));
        assertThat(checkout.checkout("3B"), equalTo(75));
    }
}


