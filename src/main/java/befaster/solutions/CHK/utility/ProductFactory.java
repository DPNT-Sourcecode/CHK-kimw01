package befaster.solutions.CHK.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ProductFactory implements ProductFactoryMethod {


    @Override
    public Product createProduct(product productRef) {
        List<Offer> offers = new ArrayList<Offer>();
        List<SpecialOffer> specialOffers = new ArrayList<SpecialOffer>();
        List<CombinationOffer> combinationOffers = new ArrayList<CombinationOffer>();
        switch (productRef) {
            case A:
                offers.add(new Offer(3, 130));
                offers.add(new Offer(5, 200));
                offers.sort(Comparator.comparing(Offer::getNumProducts).reversed());
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case B:
                offers.add(new Offer(2, 45));
                return new Product(productRef, 30, offers, specialOffers, combinationOffers);
            case C:
                return new Product(productRef, 20, offers, specialOffers, combinationOffers);
            case D:
                return new Product(productRef, 15, offers, specialOffers, combinationOffers);
            case E:
                specialOffers.add(new SpecialOffer(2,Arrays.asList(ProductFactoryMethod.product.B)));
                return new Product(productRef, 40, offers, specialOffers, combinationOffers);
            case F:
                specialOffers.add(new SpecialOffer(2,Arrays.asList(ProductFactoryMethod.product.F)));
                return new Product(productRef, 10, offers, specialOffers, combinationOffers);
            case G:
                return new Product(productRef, 20, offers, specialOffers, combinationOffers);
            case H:
                offers.add(new Offer(5, 45));
                offers.add(new Offer(10, 80));
                offers.sort(Comparator.comparing(Offer::getNumProducts).reversed());
                return new Product(productRef, 10, offers, specialOffers, combinationOffers);
            case I:
                return new Product(productRef, 35, offers, specialOffers, combinationOffers);
            case J:
                return new Product(productRef, 60, offers, specialOffers, combinationOffers);
            case K:
                offers.add(new Offer(2, 120));
                return new Product(productRef, 70, offers, specialOffers, combinationOffers);
            case L:
                return new Product(productRef, 90, offers, specialOffers, combinationOffers);
            case M:
                return new Product(productRef, 15, offers, specialOffers, combinationOffers);
            case N:
                specialOffers.add(new SpecialOffer(3,Arrays.asList(ProductFactoryMethod.product.M)));
                return new Product(productRef, 40, offers, specialOffers, combinationOffers);
            case O:
                return new Product(productRef, 10, offers, specialOffers, combinationOffers);
            case P:
                offers.add(new Offer(5, 200));
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case Q:
                offers.add(new Offer(3, 80));
                return new Product(productRef, 30, offers, specialOffers, combinationOffers);
            case R:
                specialOffers.add(new SpecialOffer(3,Arrays.asList(ProductFactoryMethod.product.Q)));
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case S:
                combinationOffers.add(new CombinationOffer(3,45, Arrays.asList(ProductFactoryMethod.product.T,ProductFactoryMethod.product.X,ProductFactoryMethod.product.Y,ProductFactoryMethod.product.Z)));
                return new Product(productRef, 20, offers, specialOffers, combinationOffers);
            case T:
                combinationOffers.add(new CombinationOffer(3,45, Arrays.asList(ProductFactoryMethod.product.S,ProductFactoryMethod.product.X,ProductFactoryMethod.product.Y,ProductFactoryMethod.product.Z)));
                return new Product(productRef, 20, offers, specialOffers, combinationOffers);
            case U:
                specialOffers.add(new SpecialOffer(3,Arrays.asList(ProductFactoryMethod.product.U)));
                return new Product(productRef, 40, offers, specialOffers, combinationOffers);
            case V:
                offers.add(new Offer(2, 90));
                offers.add(new Offer(3, 130));
                offers.sort(Comparator.comparing(Offer::getNumProducts).reversed());
                return new Product(productRef, 50, offers, specialOffers, combinationOffers);
            case W:
                return new Product(productRef, 20, offers, specialOffers, combinationOffers);
            case X:
                combinationOffers.add(new CombinationOffer(3,45, Arrays.asList(ProductFactoryMethod.product.T,ProductFactoryMethod.product.S,ProductFactoryMethod.product.Y,ProductFactoryMethod.product.Z)));
                return new Product(productRef, 17, offers, specialOffers, combinationOffers);
            case Y:
                combinationOffers.add(new CombinationOffer(3,45, Arrays.asList(ProductFactoryMethod.product.T,ProductFactoryMethod.product.X,ProductFactoryMethod.product.S,ProductFactoryMethod.product.Z)));
                return new Product(productRef, 20, offers, specialOffers, combinationOffers);
            case Z:
                combinationOffers.add(new CombinationOffer(3,45, Arrays.asList(ProductFactoryMethod.product.T,ProductFactoryMethod.product.X,ProductFactoryMethod.product.Y,ProductFactoryMethod.product.S)));
                return new Product(productRef, 21, offers, specialOffers, combinationOffers);
            default:
                return null;
        }
    }
}

