package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        // special offers
        // A = 50, 3A for 130 -> 150 - 130 = 20, (20/150)x100 = 13.333333% decrease
        // B = 30, 2B for 45 --> 60 - 45 = 15, (15/60)x100 = 25% decrease
        // steps:
        // validate illegal input
        if (skus.contains("A") | skus.contains("B") | skus.contains("C") | skus.contains("D")) {
            // create a list of items to use Collections to manage the list of items
            // identify the frequency of items with offer (A and B)
            // calculate the frequency of items without offer
            // obtain the total price by item
            // calculate the total price of basket

        }
        return -1;


    }
}
