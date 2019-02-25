package befaster.solutions.CHK.utility;

import java.util.List;


public class ProductFactory implements ProductFactoryMethod {


    @Override
    public Product createProduct(product productRef, Integer price, List<Offer> offerList, List<SpecialOffer> specialOffers, List<CombinationOffer> combinationOffers) {
        switch (productRef){
            case A:
                return new Product(productRef, 50, offerList, specialOffers, combinationOffers);
        }
    }
}




