package befaster.solutions.CHK.utility;

import java.util.List;


public class ProductFactory implements ProductFactoryMethod {
    public enum products {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J,
        K,
        L,
        M,
        N,
        O,
        P,
        Q,
        R,
        S,
        T,
        U,
        V,
        W,
        X,
        Y,
        Z
    }

    @Override
    public Product createProduct(String productRef, Integer price, List<Offer> offerList, List<SpecialOffer> specialOffers, List<CombinationOffer> combinationOffers) {

        return new Product(productRef, price, offerList, specialOffers, combinationOffers);
    }
}


