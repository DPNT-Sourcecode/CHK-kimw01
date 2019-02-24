package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionR2Test {
    private CheckoutSolution checkout;

    @Before
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    // special offers 2E get one B free
    // offers 3A = 130, 5A = 200, 2B = 45
    // prices A = 50, B = 30, C = 20, D = 15, E = 40
    // no decimals, only integers

    @Test
    public void simpleATest() {
        assertThat(checkout.checkout("AA"), equalTo(100));
    }

    @Test
    public void simpleItem3ATest() {
        assertThat(checkout.checkout("AAA"), equalTo(130));
    }

    @Test
    public void simpleItem5ATest() {
        assertThat(checkout.checkout("AAAAA"), equalTo(200));
    }

    @Test
    public void simpleItemBTest() {
        assertThat(checkout.checkout("B"), equalTo(30));
    }

    @Test
    public void simpleItem2BTest() {
        assertThat(checkout.checkout("BB"), equalTo(45));
    }

    @Test
    public void simpleItemCTest() {
        assertThat(checkout.checkout("C"), equalTo(20));
    }

    @Test
    public void simpleItemDTest() {
        assertThat(checkout.checkout("D"), equalTo(15));
    }

    @Test
    public void simpleItemETest() {
        assertThat(checkout.checkout("EEE"), equalTo(120));
    }

    @Test
    public void simpleCombinationItemsTest() {
        assertThat(checkout.checkout("ABCDE"), equalTo(155));
    }

    @Test
    public void combinationItemsTest() {
        assertThat(checkout.checkout("ABAAEACDAABAAEA"), equalTo(525));
    }

    @Test
    public void simpleCombinationSpecialOfferBFreeTest(){
        assertThat(checkout.checkout("BBEE"), equalTo(110));
    }

    @Test
    public void combinationSpecialOfferBFreeTest(){
        assertThat(checkout.checkout("AABCDDEECDE"), equalTo(305));
    }

    @Test
    public void simpleIllegalInputTest() {
        assertThat(checkout.checkout("F"), equalTo(-1));
    }

    /*
    For empty basket we expected totalprice equals 0
     */
    @Test
    public void voidBasketInputTest() {
        assertThat(checkout.checkout(""), equalTo(0));
    }

    @Test
    public void nullInputTest() {
        assertThat(checkout.checkout(null), equalTo(-1));
    }

    @Test
    public void combinationIllegalInputTest() {
        assertThat(checkout.checkout("FMGGTT"), equalTo(-1));
    }

    @Test
    public void combinationIllegalItemsAndCorrectItems() {
        // calculate only correct Items, ignore illegal items
        assertThat(checkout.checkout("FABBACCDDA"), equalTo(-1));
    }
}

