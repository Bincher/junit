import java.util.HashMap;
import java.util.Map;

public class DbStub {
    private static final Map<Integer, ProductSpecification> productDatabase = new HashMap<>();
    private static final Map<Integer, Sale> saleDatabase = new HashMap<>();
    private static int saleIdCounter = 1; // Counter for generating unique sale IDs

    public static void saveProductSpecification(ProductSpecification productSpec) {
        productDatabase.put(productSpec.getltemlD().getId(), productSpec);
    }

    public static ProductSpecification getProductSpecification(int productId) {
        return productDatabase.get(productId);
    }

    public static int saveSale(Sale sale) {
        int saleId = generateUniqueSaleId();
        saleDatabase.put(saleId, sale);
        return saleId;
    }

    public static Sale getSale(int saleId) {
        return saleDatabase.get(saleId);
    }

    public static void saveSalesLineItem(int saleId, SalesLineItem salesLineItem) {
        Sale sale = saleDatabase.get(saleId);
        if (sale != null) {
            sale.makeLineltem(salesLineItem.getProductSpec(), salesLineItem.getQuantity());
        }
    }

    public static void savePayment(int saleId, Money cashTendered) {
        Sale sale = saleDatabase.get(saleId);
        if (sale != null) {
            sale.makePayment(cashTendered);
        }
    }

    public static boolean isSaleComplete(int saleId) {
        Sale sale = saleDatabase.get(saleId);
        return sale != null && sale.isComplete();
    }

    private static int generateUniqueSaleId() {
        return saleIdCounter++;
    }
}
