package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Enums constants to represent the items and the attributes of these items such as offers and special offers
 */

// item representation
enum item {
    // itemRef, price, haveOffer, haveSpecialOffer
    A("A", 50, true, false), B("B", 30, true, false), C("C", 20, false, false), D("D", 15, false, false), E("E", 40, false, true);
    private String itemRef;
    private int price;
    private boolean haveOffer;
    private boolean haveSpecialOffer;

    // contructor
    item(final String itemRef, final int price, final boolean haveOffer, final boolean haveSpecialOffer) {
        this.itemRef = itemRef;
        this.price = price;
        this.haveOffer = haveOffer;
        this.haveSpecialOffer = haveSpecialOffer;
    }

    public String getItemRef() {
        return itemRef;
    }

    public int getPrice() {
        return price;
    }

    public boolean isHaveOffer() {
        return haveOffer;
    }

    public boolean isHaveSpecialOffer() {
        return haveSpecialOffer;
    }

    // get offers by item
    public ArrayList<offer> getOffers() {
        ArrayList<offer> offers = new ArrayList<offer>();
        if (this.equals(A)) {
            offers.add(offer.A1);
            offers.add(offer.A2);
        } else if (this.equals(B)) {
            offers.add(offer.B);
        }

        return offers;
    }
}

// offer linked to item
enum offer {
    // to manage the groups of items of the same item
    // will be necessary manage the groups in descendent order by numItems
    // numItems, price
    A1(5, 200), A2(3, 130), B(2, 45);
    private int numItems;
    private int price;

    //constructor
    offer(final int numItems, final int price) {
        this.numItems = numItems;
        this.price = price;
    }

    public int getNumItems() {
        return numItems;
    }

    public int getPrice() {
        return price;
    }
}

// specialOffer linked to item
enum specialOffer {
    // numItems, free item object
    E(2, item.B);

    private int numItems;
    private item freeItem;

    //constructor
    specialOffer(final int numItems, final item freeItem) {
        this.numItems = numItems;
        this.freeItem = freeItem;
    }
}


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

