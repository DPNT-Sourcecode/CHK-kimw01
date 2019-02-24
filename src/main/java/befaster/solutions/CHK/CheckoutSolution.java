package befaster.solutions.CHK;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        // special offers
        // A = 50, 3A for 130
        // B = 30, 2B for 45
        // C = 20, D = 15
        // steps:

        // basic validations: if object null, return -1, if the basket if empty return 0
        if (skus == null) {
            return -1;
        }else if(skus.length()<=0){
            return 0;
        }

        // create a list of items to use Collections to manage the list of items
        List<String> items = Stream.of(skus.split("")).collect(Collectors.toList());

        // special validation for illegal inputs, illegal items
        // validate illegal entries cloning the list of items
        List<String> clone = items.stream().collect(Collectors.toList());
        // validate illegal input, if there is any illegal input return -1
        clone.removeIf(item -> item.equals("A") | item.equals("B") | item.equals("C") | item.equals("D"));
        // if the size of list is greater than 0 this means that the list contains illegal items or references
        if (clone.size() > 0) {
            return -1;
        }

        // price of A with offer
        int priceItemsA = ((Collections.frequency(items, "A") / 3) * 130) + ((Collections.frequency(items, "A") % 3) * 50);
        // price of B with offer
        int priceItemsB = ((Collections.frequency(items, "B") / 2) * 45) + ((Collections.frequency(items, "B") % 2) * 30);
        // price of C
        int priceC = Collections.frequency(items, "C") * 20;
        // price of D
        int priceD = Collections.frequency(items, "D") * 15;
        // return the total price of basket
        return priceItemsA + priceItemsB + priceC + priceD;


    }
}
