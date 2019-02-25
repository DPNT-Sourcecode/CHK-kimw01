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
    A("A", 50, true, false),
    B("B", 30, true, false),
    C("C", 20, false, false),
    D("D", 15, false, false),
    E("E", 40, false, true),
    F("F", 10, false, true),
    G("G", 20, false, false),
    H("H", 10, true, false), //5H for 45, 10H for 80  |
    I("I", 35, false, false),
    J("J", 60, false, false),
    K("K", 80, true, false), //   | 2K for 150             |
    L("L", 90, false, false),
    M("M", 15, false, false),
    N("N", 40, false, true), //    | 3N get one M free      |
    O("O", 10, false, false),
    P("P", 50, true, false),  // | 5P for 200             |
    Q("Q", 30, true, false),  // | 3Q for 80              |
    R("R", 50, false, true),  // | 3R get one Q free      |
    S("S", 30, false, false),
    T("T", 20, false, false),
    U("U", 40, false, true),   //| 3U get one U free      |
    V("V", 50, true, false),  //| 2V for 90, 3V for 130  |
    W("W", 20, false, false),
    X("X", 90, false, false),
    Y("Y", 10, false, false),
    Z("Z", 50, false, false);
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
        } else if (this.equals(H)) {
            offers.add(offer.H1);
            offers.add(offer.H2);
        } else if (this.equals(K)) {
            offers.add(offer.K);
        } else if (this.equals(P)) {
            offers.add(offer.P);
        } else if (this.equals(Q)) {
            offers.add(offer.Q);
        } else if (this.equals(V)) {
            offers.add(offer.V1);
            offers.add(offer.V2);
        }

        return offers;
    }

    // get specialOffers by item
    public ArrayList<specialOffer> getSpecialOffers() {
        ArrayList<specialOffer> specialOffers = new ArrayList<specialOffer>();
        if (this.equals(E)) {
            specialOffers.add(specialOffer.E);
        } else if (this.equals(F)) {
            specialOffers.add(specialOffer.F);
        } else if (this.equals(N)) {
            specialOffers.add(specialOffer.N);
        } else if (this.equals(R)) {
            specialOffers.add(specialOffer.R);
        } else if (this.equals(U)) {
            specialOffers.add(specialOffer.U);
        }

        return specialOffers;
    }
}

// offer linked to item
enum offer {
    // to manage the groups of items of the same item
    // will be necessary manage the groups in descendent order by numItems
    // numItems, price
    A1(5, 200),
    A2(3, 130),
    B(2, 45),
    H1(10, 80),
    H2(5, 45),
    K(2, 150),
    P(5, 200),
    Q(3, 80),
    V1(3, 130),
    V2(2, 90);
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
    E(2, item.B),
    F(2, item.F),
    N(3, item.M),
    R(3, item.Q),
    U(3, item.U);

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

        // manage collection of items/products by type of taxonomy (1:special offers, 2:pack offers, 3:normal items)
        // important: handle the items in taxonomy order to discard free items before calculate pack offers
        // we cannot create a recursive method to handle all the products
        // first: handle items with special offers
        for (item i : item.values()) {
            if (i.isHaveSpecialOffer()) {
                // calculate price by item/product and get the remain items in the collection
                items = processItemCollection(items, i);
            }
        }
        // second: handle items with pack offers
        for (item i : item.values()) {
            if (i.isHaveOffer()) {
                // calculate price by item/product and get the remain items in the collection
                items = processItemCollection(items, i);
            }
        }
        // third: handle items without any kind of offer
        for (item i : item.values()) {
            if (!i.isHaveSpecialOffer() && !i.isHaveOffer()) {
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
                    // Be careful when the special offer pack get free n items of the same item reference
                    if (so.getFreeItem().getItemRef().equals(product.getItemRef())) {
                        // calculate packs
                        List<String> remainItems = collect.subList(0, collect.size());
                        while (remainItems.iterator().hasNext() && ((remainItems.size() / so.getNumItems()) > 0)) {
                            if (remainItems.size() > so.getNumItems()) {
                                // sublist of items remain, remove 3 (2 pack and 1 free)
                                remainItems = remainItems.subList(0, remainItems.size() - (so.getNumItems()+1));
                            } else {
                                break;
                            }
                            // add price of two items of pack to total price until finish the loop
                            sumToTotalPrice(so.getNumItems() * product.getPrice());
                        }
                        // remain items out pack
                        sumToTotalPrice(remainItems.size() * product.getPrice());
                    } else {
                        for (int i = (collect.size() / so.getNumItems()); i > 0; i--) {
                            items.remove(so.getFreeItem().getItemRef());
                        }
                        // because the product passed don't have a pack offer
                        // will be calculate de price by normal way after remove the free items
                        sumToTotalPrice(items.stream().filter(i -> i.equals(product.getItemRef())).collect(Collectors.toList()).size() * product.getPrice());
                    }

                }
            } else if (product.isHaveOffer()) {
                // second: with offers
                int remainItems = collect.size();
                for (offer o : product.getOffers()) {
                    sumToTotalPrice((remainItems / o.getNumItems()) * o.getPrice());
                    // local remain items by product
                    remainItems = remainItems % o.getNumItems();
                }
                // sum the price of local remain items by product
                sumToTotalPrice(remainItems * product.getPrice());
            } else {
                // third: normal product
                sumToTotalPrice(collect.size() * product.getPrice());
            }
        }
        return items;
    }
}
