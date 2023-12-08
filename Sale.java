import java.util.*;

// Class Sale
public class Sale {
    private List lineltems = new ArrayList();
    private Date date = new Date();
    private boolean isComplete = false;
    private Payment payment;

    public Money getBalance()  {
            return payment.getAmount().minus(getTotal());
        }

    public void becomeComplete() {  isComplete = true;   }

    public boolean isComplete() {   return isComplete;   }

    public void makeLineltem(ProductSpecification spec, int quantity) {
        lineltems.add(new SalesLineItem(spec, quantity));
    }

    public List<SalesLineItem> getLineltems() {
        return lineltems;
    }

    public Money getTotal() {
        Money total = new Money();
        Iterator i = lineltems.iterator();
        while (i.hasNext()) {
            SalesLineItem sli = (SalesLineItem) i.next();
            total = total.add(sli.getSubtotal());
        }
        return total;
    }

    public void makePayment(Money cashTendered) { 
        payment = new Payment(cashTendered);  
    }
}