package befaster.solutions.CHK.utility;

import java.util.List;

public class CombinationOffer {
    private Integer price;
    private Integer numProducts;
    private List<ProductFactoryMethod.product> productsRef;

    public CombinationOffer(Integer price, Integer numProducts, List<ProductFactoryMethod.product> productsRef) {
        this.price = price;
        this.numProducts = numProducts;
        this.productsRef = productsRef;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNumProducts() {
        return numProducts;
    }

    public List<ProductFactoryMethod.product> getProductsRef() {
        return productsRef;
    }
}


