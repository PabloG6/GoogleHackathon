package momocorp.gotchu.DataStructures;

/**
 * Created by Pablo on 10/29/2016.
 */
public class ContactStructures{
    String phoneNumber;
    String name;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactStructures() {
    }



    public ContactStructures(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



}

