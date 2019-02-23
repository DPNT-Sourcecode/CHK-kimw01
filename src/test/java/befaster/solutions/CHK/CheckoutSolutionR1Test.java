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
        // offers 3A = 130, 2B = 45
        // prices A = 50, B = 30, C = 20, D = 15
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("BB"), equalTo(45));
        assertThat(checkout.checkout("AAAAAA"), equalTo(260));
        assertThat(checkout.checkout("BBBB"), equalTo(90));
        assertThat(checkout.checkout("AAAAA"), equalTo(230));
        assertThat(checkout.checkout("BBB"), equalTo(75));
        assertThat(checkout.checkout("CCC"), equalTo(60));
        assertThat(checkout.checkout("DD"), equalTo(30));
        assertThat(checkout.checkout("ADADABCCDDBBBAC"), equalTo(390));
    }
}


