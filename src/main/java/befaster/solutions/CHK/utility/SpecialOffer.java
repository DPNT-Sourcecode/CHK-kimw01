package befaster.solutions.CHK.utility;

import java.util.List;

public class SpecialOffer {
    private Integer numItems;
    private List<ProductFactoryMethod.product> freeProducts;

    public SpecialOffer(final Integer numItems, final List<ProductFactoryMethod.product> freeProducts){
        this.numItems = numItems;
        this.freeProducts = freeProducts;
    }
    public Integer getNumItems() {
        return numItems;
    }

    public List<ProductFactoryMethod.product> getFreeProducts() {
        return freeProducts;
    }
}
