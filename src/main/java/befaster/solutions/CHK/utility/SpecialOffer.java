package befaster.solutions.CHK.utility;

import java.util.List;

public class SpecialOffer {
    private Integer numItems;
    private List<Product> freeProducts;

    public SpecialOffer(final Integer numItems, final List<Product> freeProducts){
        this.numItems = numItems;
        this.freeProducts = freeProducts;
    }
    public Integer getNumItems() {
        return numItems;
    }

    public List<Product> getFreeProducts() {
        return freeProducts;
    }
}

