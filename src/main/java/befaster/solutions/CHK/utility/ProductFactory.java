package befaster.solutions.CHK.utility;

import java.util.ArrayList;
import java.util.List;


public class ProductFactory implements ProductFactoryMethod {


    @Override
    public Product createProduct(product productRef) {
        List<Offer> offers = new ArrayList<Offer>();
        List<SpecialOffer> specialOffers = new ArrayList<SpecialOffer>();
        List<CombinationOffer> combinationOffers = new ArrayList<CombinationOffer>();
        switch (productRef) {
            case A:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case B:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case C:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case D:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case E:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case F:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case G:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case H:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case I:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case J:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case K:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case L:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case M:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case N:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case O:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case P:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case Q:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case R:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case S:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case T:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case U:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case V:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case W:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case X:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case Y:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case Z:
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            default:
                return null;
        }
    }
}





