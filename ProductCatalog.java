import java.util.*;

// Class ProductCatalog
public class ProductCatalog {
    private Map productSpecifications = new HashMap();

    public ProductCatalog() {
        // sample data
        ItemID idl = new ItemID(100);
        ItemID id2 = new ItemID(200);
        Money price = new Money(3);
        ProductSpecification ps;
        ps = new ProductSpecification(idl, price, "product 1");
        productSpecifications.put(idl, ps);
        ps = new ProductSpecification(id2, price, "product 2");
        productSpecifications.put(id2, ps);
    }

    public ProductSpecification getSpecification(ItemID id) {
        return (ProductSpecification) productSpecifications.get(id);
    }
}