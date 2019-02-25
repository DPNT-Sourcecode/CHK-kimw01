package befaster.solutions.CHK.utility;

import java.util.List;

public class Product {

    private ProductFactoryMethod.product productRef;
    private Integer price;
    private List<Offer> offerList;
    private List<SpecialOffer> specialOffers;
    private List<CombinationOffer> combinationOffers;

    public Product(ProductFactoryMethod.product productRef, Integer price, List<Offer> offerList, List<SpecialOffer> specialOffers, List<CombinationOffer> combinationOffers){
        this.productRef = productRef;
        this.price = price;
        this.offerList = offerList;
        this.specialOffers = specialOffers;
        this.combinationOffers = combinationOffers;
    }

    public ProductFactoryMethod.product getProductRef() {
        return productRef;
    }

    public Integer getPrice() {
        return price;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public List<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public List<CombinationOffer> getCombinationOffers() {
        return combinationOffers;
    }
}

