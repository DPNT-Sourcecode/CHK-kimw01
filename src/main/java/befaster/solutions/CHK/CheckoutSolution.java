package befaster.solutions.CHK;

import befaster.solutions.CHK.utility.Product;
import befaster.solutions.CHK.utility.ProductFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutSolution {

    /*
     * final price
     */
    private int totalPrice;

    /*
     * method to sum the total price by item to final price
     */
    private void sumToTotalPrice(int price) {
        this.totalPrice = totalPrice + price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer checkout(String skus) {

        // RESET: the totalPrice every time that some call checkout
        setTotalPrice(0);
        // special offers 2E get one B free, 2F get one F free
        // offers 3A = 130, 5A = 200, 2B = 45
        // prices A = 50, B = 30, C = 20, D = 15, E = 40
        // steps:
        // basic validations: if object null, return -1, if the basket if empty return 0
        if (skus == null) {
            return -1;
        } else if (skus.length() <= 0) {
            return 0;
        }

        // create a list of items to use Collections to handle the list of items
        List<String> items = Stream.of(skus.split("")).collect(Collectors.toList());
        // special validation for illegal inputs, illegal items
        // validate illegal entries cloning the list of items
        List<String> clone = items.stream().collect(Collectors.toList());
        // validate illegal input, remove legal product ref from clone list
        for (item i : item.values()) {
            clone.removeIf(product -> product.equals(i.getItemRef()));
        }

        // if the size of list is greater than 0 this means that the list contains illegal items or references
        if (clone.size() > 0) {
            return -1;
        }

        // create product on runtime
        for(String prod : items){
            ProductFactory factory = new ProductFactory();
            Product product = factory.createProduct(ProductFactory.product.valueOf(prod));
            setTotalPrice(product.getPrice());
        }

        return getTotalPrice();
    }


}

