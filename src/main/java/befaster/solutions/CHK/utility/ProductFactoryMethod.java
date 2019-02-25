package befaster.solutions.CHK.utility;

import java.util.List;

public interface ProductFactoryMethod {
    public enum product {
        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E"),
        F("F"),
        G("G"),
        H("H"),
        I("I"),
        J("J"),
        K("K"),
        L("L"),
        M("M"),
        N("N"),
        O("O"),
        P("P"),
        Q("Q"),
        R("R"),
        S("S"),
        T("Y"),
        U("U"),
        V("V"),
        W("W"),
        X("X"),
        Y("Y"),
        Z("Z");

        private String ref;
        product(final String ref){

        }
    }
    Product createProduct(product productRef);
}

