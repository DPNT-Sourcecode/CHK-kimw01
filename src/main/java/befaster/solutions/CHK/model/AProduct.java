package befaster.solutions.CHK.model;

import befaster.solutions.CHK.utility.CombinationOffer;
import befaster.solutions.CHK.utility.Offer;
import befaster.solutions.CHK.utility.Product;
import befaster.solutions.CHK.utility.SpecialOffer;

import java.util.List;

public class AProduct extends Product {


    @Override
    public List<Offer> getListOffer() {
        return null;
    }

    @Override
    public void setListOffer() {

    }

    @Override
    public List<SpecialOffer> getListSpecialOffer() {
        return null;
    }

    @Override
    public void setListSpecialOffer() {

    }

    @Override
    public List<CombinationOffer> getListCombinationOffer() {
        return null;
    }

    @Override
    public void setListCombinationOffer() {

    }

    @Override
    public void priceOperation(Integer price, List<String> basketItems) {

    }

    @Override
    public void priceOfferOperation(Integer price) {

    }

    @Override
    public void priceSpecialOfferOperation(Integer price) {

    }

    @Override
    public void priceCombinationOfferOperation(Integer price) {

    }
}
