package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkout;

    @Before
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    // special offers 2E get one B free, 2F get one F free
    // offers 3A = 130, 5A = 200, 2B = 45
    // prices A = 50, B = 30, C = 20, D = 15, E = 40, F = 10
    // no decimals, only integers
    @Test
    public void bigTest() {
        assertThat(checkout.checkout("NNNMM"), equalTo(135));
        assertThat(checkout.checkout("RRRQQ"), equalTo(180));
        assertThat(checkout.checkout("UUUU"), equalTo(120));
        assertThat(checkout.checkout("KK"), equalTo(150));
        assertThat(checkout.checkout("HHHHHHHHHH"), equalTo(80));
        assertThat(checkout.checkout("HHHHHHHHHHHHHHH"), equalTo(125));
        assertThat(checkout.checkout("P"), equalTo(50));
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(965));
        assertThat(checkout.checkout("P"), equalTo(50));
    }

    @Test
    public void oneTest() {
        assertThat(checkout.checkout("ABCDEF"), equalTo(165));
        assertThat(checkout.checkout("ABCDEFABCDEF"), equalTo(300));
        assertThat(checkout.checkout("CDFFAECBDEAB"), equalTo(300));
    }

    @Test
    public void simpleTest() {
        assertThat(checkout.checkout("A"), equalTo(50));
        assertThat(checkout.checkout("B"), equalTo(30));
        assertThat(checkout.checkout("C"), equalTo(20));
        assertThat(checkout.checkout("D"), equalTo(15));
        assertThat(checkout.checkout("E"), equalTo(40));
        assertThat(checkout.checkout("F"), equalTo(10));
    }

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
    public void simpleItem2BTest() {
        assertThat(checkout.checkout("BB"), equalTo(45));
    }

    @Test
    public void simpleItemCTest() {
        assertThat(checkout.checkout("CCC"), equalTo(60));
    }

    @Test
    public void simpleItemDTest() {
        assertThat(checkout.checkout("DDDD"), equalTo(60));
    }

    @Test
    public void simpleItemETest() {
        assertThat(checkout.checkout("EEE"), equalTo(120));
    }

    @Test
    public void simpleItemFTest() {
        assertThat(checkout.checkout("FF"), equalTo(20));
        assertThat(checkout.checkout("FFFF"), equalTo(30));
        assertThat(checkout.checkout("FFFFFF"), equalTo(40));
        assertThat(checkout.checkout("FFFFFFF"), equalTo(50));
        assertThat(checkout.checkout("FFFFFFFF"), equalTo(60));
        assertThat(checkout.checkout("FFFFFFFFF"), equalTo(60));
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
    public void simpleCombinationSpecialOfferBFreeTest() {
        assertThat(checkout.checkout("BBEE"), equalTo(110));
    }

    @Test
    public void combinationSpecialOfferBFreeTest() {
        assertThat(checkout.checkout("AABCDDEECDE"), equalTo(305));
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
        assertThat(checkout.checkout("_MGGTT"), equalTo(-1));
    }

    @Test
    public void combinationIllegalItemsAndCorrectItems() {
        // calculate only correct Items, ignore illegal items
        assertThat(checkout.checkout("FABBACxCDDAE@F"), equalTo(-1));
    }
}




