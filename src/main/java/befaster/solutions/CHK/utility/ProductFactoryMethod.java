package befaster.solutions.CHK.utility;

public interface ProductFactoryMethod {

    public Product createProduct(String productRef, Integer price, boolean haveOffer, boolean haveSpecialOffer, boolean haveCombinationOffer);
}
