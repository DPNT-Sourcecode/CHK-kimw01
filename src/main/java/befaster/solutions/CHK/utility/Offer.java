package befaster.solutions.CHK.utility;

public class Offer {
    private Integer numProducts;
    private Integer price;

    public Offer(final Integer numProducts, final Integer price){
        this.numProducts = numProducts;
        this.price = price;
    }

    public Integer getNumProducts() {
        return numProducts;
    }

    public Integer getPrice() {
        return price;
    }

}
