package befaster.solutions.CHK.utility;

import java.util.List;

public abstract class Product {

    private String productRef;
    private Integer price;
    private boolean haveOffer;
    private boolean haveSpecialOffer;
    private boolean haveCombinationOffer;

    public Product(String productRef, Integer price, boolean haveOffer, boolean haveSpecialOffer, boolean haveCombinationOffer){
        this.productRef = productRef;
        this.price = price;
        this.haveOffer = haveOffer;
        this.haveSpecialOffer = haveSpecialOffer;
        this.haveCombinationOffer = haveCombinationOffer;
    }

    public String getProductRef() {
        return productRef;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean isHaveOffer() {
        return haveOffer;
    }

    public boolean isHaveSpecialOffer() {
        return haveSpecialOffer;
    }

    public boolean isHaveCombinationOffer() {
        return haveCombinationOffer;
    }

    // abstract methods of operations
    public abstract List<Offer> getListOffer();

    public abstract void setListOffer();

    public abstract List<SpecialOffer> getListSpecialOffer();

    public abstract void setListSpecialOffer();

    public abstract List<CombinationOffer> getListCombinationOffer();

    public abstract void setListCombinationOffer();

    public abstract void priceOperation(Integer price, List<String> basketItems);

    public abstract void priceOfferOperation(Integer price);

    public abstract void priceSpecialOfferOperation(Integer price);

    public abstract void priceCombinationOfferOperation(Integer price);
}



