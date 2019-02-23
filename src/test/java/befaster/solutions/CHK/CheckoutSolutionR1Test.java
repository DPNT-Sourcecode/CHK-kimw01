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

    // offers 3A = 130, 2B = 45
    // prices A = 50, B = 30, C = 20, D = 15
    // no decimals, only integers

    @Test
    public void simpleItemATest(){
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("AAAAAA"), equalTo(260));
        assertThat(checkout.checkout("AAAAA"), equalTo(230));
    }

    @Test
    public void simpleItemBTest(){
        assertThat(checkout.checkout("BB"), equalTo(45));
        assertThat(checkout.checkout("BBBB"), equalTo(90));
        assertThat(checkout.checkout("BBB"), equalTo(75));
    }

    @Test
    public void simpleItemCTest(){
        assertThat(checkout.checkout("CCC"), equalTo(60));
    }

    @Test
    public void simpleItemDTest(){
        assertThat(checkout.checkout("DD"), equalTo(30));
    }

    @Test
    public void combinationItemsTest(){
        assertThat(checkout.checkout("ADADABCCDDBBBAC"), equalTo(390));
    }

    @Test
    public void simpleIllegalInputTest(){
        assertThat(checkout.checkout("F"), equalTo(-1));
    }

    @Test
    public void combinationIllegalInputTest(){
        assertThat(checkout.checkout("FMGGTT"), equalTo(-1));
    }

    @Test
    public void combinationIllegalItemsAndCorrectItems(){
        // calculate only correct Items, ignore illegal items
        assertThat(checkout.checkout("FABBACCDDA"),equalTo(-1));
    }
}
