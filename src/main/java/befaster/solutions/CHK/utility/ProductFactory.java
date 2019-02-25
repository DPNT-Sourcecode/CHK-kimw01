package befaster.solutions.CHK.utility;

import java.util.List;


public class ProductFactory implements ProductFactoryMethod {


    @Override
    public Product createProduct(product productRef, Integer price, List<Offer> offerList, List<SpecialOffer> specialOffers, List<CombinationOffer> combinationOffers) {
    
        return new Product(productRef, price, offerList, specialOffers, combinationOffers);
    }
}



