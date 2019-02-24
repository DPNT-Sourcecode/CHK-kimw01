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

    // get specialOffers by item
    public ArrayList<specialOffer> getSpecialOffers() {
        ArrayList<specialOffer> specialOffers = new ArrayList<specialOffer>();
        if (this.equals(E)) {
            specialOffers.add(specialOffer.E);
        }

        return specialOffers;
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

    public int getNumItems() {
        return numItems;
    }

    public item getFreeItem() {
        return freeItem;
    }
}


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

        // manage collection of items/products by type of taxonomy (1:special offers, 2:pack offers, 3:normal items)
        // important: handle the items in taxonomy order to discard free items before calculate pack offers
        // we cannot create a recursive method to handle all the products
        // first: handle items with special offers
        for (item i : item.values()) {
            if(i.isHaveSpecialOffer()){
                // calculate price by item/product and get the remain items in the collection
                items = processItemCollection(items, i);
            }
        }
        // second: handle items with pack offers
        for (item i : item.values()) {
            if(i.isHaveOffer()){
                // calculate price by item/product and get the remain items in the collection
                items = processItemCollection(items, i);
            }
        }
        // third: handle items without any kind of offer
        for (item i : item.values()) {
            if(!i.isHaveSpecialOffer() && !i.isHaveOffer()){
                // calculate price by item/product and get the remain items in the collection
                items = processItemCollection(items, i);
            }
        }

        return getTotalPrice();
    }

    /**
     * To handle the item/product and offers
     *
     * @param items   list items on basket to calculate the totalPrice by item
     * @param product item to handle
     * @return List of remain items on basket to handle
     */
    private List<String> processItemCollection(List<String> items, item product) {
        // collection of items by product
        List<String> collect = items.stream().filter(i -> i.equals(product.getItemRef())).collect(Collectors.toList());
        // total items by product
        //int totalItems = collect.size();

        // if the list not empty process the product, if the list is empty the total price of item/product will be zero
        // and then will not be necessary add the product price to the total price of basket
        if (!collect.isEmpty()) {
            // first: with special offers
            if (product.isHaveSpecialOffer()) {
                // for each product with special offer
                for (specialOffer so : product.getSpecialOffers()) {
                    // because the special offer means that some products are free
                    // they will be remove from collection for the next calculation pack of items/products
                    // calculate the remain items and remove the number of items describe by special offer
                    for (int i = (collect.size() / so.getNumItems()); i > 0; i--) {
                        items.remove(so.getFreeItem().getItemRef());
                    }
                    // because the product passed don't have a pack offer
                    // will be calculate de price by normal way
                    sumToTotalPrice(collect.size() * product.getPrice());
                }
            } else if (product.isHaveOffer()) {
                // second: with offers
                for(offer o : product.getOffers()){
                    sumToTotalPrice((collect.size() / o.getNumItems()) * o.getPrice());
                }

            } else {
                // third: normal product
                sumToTotalPrice(collect.size() * product.getPrice());
            }
        }
        return items;
    }
}




