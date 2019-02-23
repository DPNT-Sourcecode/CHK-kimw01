package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        // special offers
        // A = 50, 3A for 130 -> 150 - 130 = 20, (20/150)x100 = 13.333333% decrease
        // B = 30, 2B for 45 --> 60 - 45 = 15, (15/60)x100 = 25% decrease
        // steps:
        // validate illegal input
        if (skus.contains("A") | skus.contains("B") | skus.contains("C") | skus.contains("D")) {
            // create a list of items to use Collections to manage the list of items
            List<String> items = Stream.of(skus.split("")).collect(Collectors.toList());
            // identify the frequency of items with offer (A and B)
            int freqA = Collections.frequency(items,"A");
            int freqB = Collections.frequency(items, "B");
            // calculate the frequency of items without offer
            int freqC = Collections.frequency(items, "C");
            int freqD = Collections.frequency(items, "D");
            // groups of number of items * price to calculate offer for A and B
            int offersA = freqA/3 * 130;
            int offersB = freqB/2 * 45;
            // price for individual items A and B out of offer
            // obtain the total price by item
            // calculate the total price of basket

        }
        return -1;


    }
}

