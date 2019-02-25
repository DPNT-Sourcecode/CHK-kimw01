package befaster.solutions.CHK.utility;

import java.util.List;

public interface ProductFactoryMethod {
    public enum product {
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
    public Product createProduct(product productRef, Integer price, List<Offer> offerList, List<SpecialOffer> specialOffers, List<CombinationOffer> combinationOffers);
}

