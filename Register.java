public class Register {
    private ProductCatalog catalog;
    private Sale sale;

    public Register(ProductCatalog catalog) {  
      this.catalog = catalog; 
    }

		public void makeNewSale() {   
      sale = new Sale();    
    }
    public void enterltem(ItemID id, int quantity) {
        ProductSpecification spec = catalog.getSpecification(id);
        sale.makeLineltem(spec, quantity);
    }
    public void endSale()  {   
      sale.becomeComplete(); 
    }
    public void makePayment(Money cashTendered) {   
      sale.makePayment(cashTendered);  
    }
}
