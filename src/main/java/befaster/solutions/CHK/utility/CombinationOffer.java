package befaster.solutions.CHK.utility;

import java.util.List;

public class CombinationOffer {
    private Integer price;
    private Integer numProducts;
    private List<ProductFactoryMethod.product> productsRef;
    private List<String> patternList;

    public CombinationOffer(Integer numProducts, Integer price, List<ProductFactoryMethod.product> productsRef, List<String> patternList) {
        this.price = price;
        this.numProducts = numProducts;
        this.productsRef = productsRef;
        this.patternList = patternList;
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

    public List<String> getPatternList() {
        return patternList;
    }
}

