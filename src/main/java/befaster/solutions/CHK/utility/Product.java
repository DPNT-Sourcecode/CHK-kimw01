package befaster.solutions.CHK.utility;

public abstract class Product {

    private Integer price;
    private boolean haveOffer;
    private boolean haveSpecialOffer;
    private boolean haveCombinationOffer;

    public Product(final Integer price, final boolean haveOffer, final boolean haveSpecialOffer, final boolean haveCombinationOffer){
        this.price = price;
        this.haveOffer = haveOffer;
        this.haveSpecialOffer = haveSpecialOffer;
        this.haveCombinationOffer = haveCombinationOffer;
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
    // TODO
}

