import java.io.*;

public class Treasurer extends Employee {

    public Treasurer() {

        super(UserType.TREASURER);
    
    }
    
    public String memberPrice(Member m, MemberList ml) {
    
        if (!m.getValidity()) return m.getPrice()+".00 DKK";
        
        return "0.00 DKK";

    }


    public void registerPayment(String paymentMethod, Member m, MemberList ml) {
    
        m.setValidity();
        m.setCard();
    
    }
    


}
