package befaster.solutions.CHK;

import befaster.solutions.CHK.utility.*;
import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
        for (ProductFactoryMethod.product prod : ProductFactoryMethod.product.values()) {
            clone.removeIf(product -> product.equals(prod.getRef()));
        }

        // if the size of list is greater than 0 this means that the list contains illegal items or references
        if (clone.size() > 0) {
            return -1;
        }

        // create basket list of products on runtime
        List<Product> products = new ArrayList<Product>();
        for (String prod : items) {
            ProductFactory factory = new ProductFactory();
            Product product = factory.createProduct(ProductFactory.product.valueOf(prod));
            sumToTotalPrice(product.getPrice());
            products.add(product);
        }
        // special offers
        processSpecialOffers(items, products.stream().filter(p -> (!p.getSpecialOffers().isEmpty() && p.getOfferList().isEmpty() && p.getCombinationOffers().isEmpty())).collect(Collectors.toList()));
        // offers
        processOffers(items, products.stream().distinct().filter(p -> (p.getSpecialOffers().isEmpty() && !p.getOfferList().isEmpty() && p.getCombinationOffers().isEmpty())).collect(Collectors.toList()));

        return getTotalPrice();
    }

    /**
     * handle offers with free items
     *
     * @param items
     * @param products
     */
    private void processSpecialOffers(final List<String> items, final List<Product> products) {
        if (!products.isEmpty()) {
            for (Product product : products) {
                for (SpecialOffer so : product.getSpecialOffers()) {
                    int numPack = Collections.frequency(items, product.getProductRef().getRef()) / so.getNumItems();
                    while (numPack > 0) {
                        for (ProductFactoryMethod.product freeProduct : so.getFreeProducts()) {
                            Integer price = new ProductFactory().createProduct(freeProduct).getPrice();
                            // substract the unitary price of free product
                            sumToTotalPrice(-price);
                            numPack--;
                            // remove free products from items
                            items.remove(freeProduct.getRef());
                            // remove pack products from items
                            for (int i = so.getNumItems(); i > 0; i--) {
                                items.remove(product.getProductRef().getRef());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Handle offers pack of the same product
     *
     * @param items
     * @param products
     */
    private void processOffers(final List<String> items, final List<Product> products) {
        if (!products.isEmpty()) {
            // every product must be handle once but is not possible apply distinct on stream because every product is an own instance
            // we need a predicate to filter product list first
            List<Product> productList = products.stream().filter(distinctProductByRef(Product::getProductRef)).collect(Collectors.toList());
            for (Product product : productList) {
                for (Offer offer : product.getOfferList()) {
                    // substract unitary price and count products processed
                    int count = 0;
                    for (int i = offer.getNumProducts(); i > 0; i--) {
                        sumToTotalPrice(-product.getPrice());
                        // remove pack products from items
                        items.remove(product.getProductRef().getRef());
                        count ++;
                    }
                    // sum the pack price
                    sumToTotalPrice((count / offer.getNumProducts()) * offer.getPrice());
                    // if the list of items is empty go out of substract process
                    if(items.isEmpty()){
                        break;
                    }
                }

            }
        }
    }

    /**
     * Predicate to filter stream
     * @param ref key to extract
     * @param <T> function
     * @return
     */
    public static <T> Predicate<T> distinctProductByRef(Function<? super T, ?> ref) {
        Set<Object> set = ConcurrentHashMap.newKeySet();
        return product -> set.add(ref.apply(product));
    }
}
