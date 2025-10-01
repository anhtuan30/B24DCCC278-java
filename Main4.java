
// Interface PaymentMethod
interface PaymentMethod {
    void pay(int amount, String customerName);
    String getType(); // Trực tiếp, Không dùng tiền mặt
    
}

// CreditCard Payment
class CreditCardPayment implements PaymentMethod {


    @Override
    public void pay(int amount, String customerName) {
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Thanh toán " + amount + " bằng thẻ tín dụng.");
    }

    @Override
    public String getType() {
        return "Không dùng tiền mặt";
    }

    
}

// PayPal Payment
class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(int amount, String customerName) {
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Thanh toán " + amount + " qua PayPal.");
    }

    @Override
    public String getType() {
        return "Không dùng tiền mặt";
    }


}

// Cash Payment
class CashPayment implements PaymentMethod {
    @Override
    public void pay(int amount, String customerName) {
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Thanh toán " + amount + " bằng tiền mặt.");
    }

    @Override
    public String getType() {
        return "Trực tiếp";
    }

    
}

// MoMo Payment (dễ dàng mở rộng)
class MoMoPayment implements PaymentMethod {
    @Override
    public void pay(int amount, String customerName) {
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Thanh toán " + amount + " qua MoMo.");
    }

    @Override
    public String getType() {
        return "Không dùng tiền mặt";
    }


}

// Order Class
class Order {
    private final String customerName;
    private final double amount;
    private final PaymentMethod paymentMethod;

    public Order(String customerName, double amount, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {

        paymentMethod.pay((int) amount, customerName);
    }
}

// Main
public class Main4 {
    public static void main(String[] args) {
        Order o1 = new Order("An", 200000, new CreditCardPayment());
        Order o2 = new Order("Bình", 150000, new PayPalPayment());
        Order o3 = new Order("Chi", 100000, new CashPayment());
        Order o4 = new Order("Dũng", 300000, new MoMoPayment());

        o1.checkout();
        o2.checkout();
        o3.checkout();
        o4.checkout();
    }
}
