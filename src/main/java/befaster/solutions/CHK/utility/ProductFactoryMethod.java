package befaster.solutions.CHK.utility;

import java.util.List;

public interface ProductFactoryMethod {

    public Product createProduct(String productRef, Integer price, List<Offer> offerList, List<SpecialOffer> specialOffers, List<CombinationOffer> combinationOffers);
}
