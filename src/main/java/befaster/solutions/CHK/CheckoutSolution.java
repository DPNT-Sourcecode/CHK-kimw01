package befaster.solutions.CHK;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Enums constants to represent the items and the attributes of these items such as offers and special offers
 */

enum item {

}

enum 
public class CheckoutSolution {
    public Integer checkout(String skus) {

        // special offers 2E get one B free
        // offers 3A = 130, 5A = 200, 2B = 45
        // prices A = 50, B = 30, C = 20, D = 15, E = 40
        // steps:

        // basic validations: if object null, return -1, if the basket if empty return 0
        if (skus == null) {
            return -1;
        } else if (skus.length() <= 0) {
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
        return -1;
    }
}


