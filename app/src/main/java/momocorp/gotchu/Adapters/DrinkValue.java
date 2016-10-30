package momocorp.gotchu.Adapters;

/**
 * Created by Pablo on 10/30/2016.
 */

public class DrinkValue {

    String tequila;
    int i;

    public String getTequila() {
        return tequila;
    }

    public void setTequila(String tequila) {
        this.tequila = tequila;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public DrinkValue(String tequila, int i) {
        this.tequila = tequila;
        this.i = i;
    }
}
