package Epayment;
class User {
    private int id;
    private String username;
    private String email;
    private double walletBalance;

    public User(int id, String username, String email, double walletBalance) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.walletBalance = walletBalance;
    }

    public boolean makePayment(double billAmount) {
        if (walletBalance >= billAmount) {
            walletBalance -= billAmount;
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public double getWalletBalance() {
        return walletBalance;
    }
}

class KYCUser extends User {
    private double rewardPoints;

    public KYCUser(int id, String username, String email, double walletBalance) {
        super(id, username, email, walletBalance);
    }

    @Override
    public boolean makePayment(double billAmount) {
        boolean paymentStatus = super.makePayment(billAmount);
        if (paymentStatus) {
            rewardPoints += billAmount * 0.1;
        }
        return paymentStatus;
    }

    public double getRewardPoints() {
        return rewardPoints;
    }
}

class EPayWallet {
    public static void processPaymentByUser(User user, double billAmount) {
        boolean paymentStatus = user.makePayment(billAmount);
        if (paymentStatus) {
            System.out.println("Congratulations " + user.getUsername() + ", payment of " + billAmount + " was successful");
        } else {
            System.out.println("Sorry " + user.getUsername() + ", not enough balance to make payment");
        }
        System.out.println("Your wallet balance is " + user.getWalletBalance());
        if (user instanceof KYCUser) {
            System.out.println("You have " + ((KYCUser) user).getRewardPoints() + " reward points");
        }
        
    }
}
public class PaymentProb {
    public static void main(String[] args) {
        User jack = new User(101, "Jack", "jack@dxc.com", 1000);
        KYCUser jill = new KYCUser(201, "Jill", "jill@dxc.com", 3000);

        EPayWallet.processPaymentByUser(jack, 700);
        EPayWallet.processPaymentByUser(jill, 1500);
        EPayWallet.processPaymentByUser(jill, 800);
        EPayWallet.processPaymentByUser(jill, 1200);
    }
}