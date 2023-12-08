import java.util.*;

// Class ProductCatalog
public class ProductCatalog {
    private Map<ItemID, ProductSpecification> productSpecifications = new HashMap<>();

    public ProductCatalog() {
        // sample data
        ItemID idl = new ItemID(100);
        ItemID id2 = new ItemID(200);
        Money price = new Money(3);
        ProductSpecification ps1 = new ProductSpecification(idl, price, "product 1");
        ProductSpecification ps2 = new ProductSpecification(id2, price, "product 2");
        
        productSpecifications.put(idl, ps1);
        productSpecifications.put(id2, ps2);
    }

    public ProductSpecification getSpecification(ItemID id) {
        return (ProductSpecification) productSpecifications.get(id);
    }
}