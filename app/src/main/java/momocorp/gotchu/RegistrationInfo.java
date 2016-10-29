package momocorp.gotchu;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ShumbaBrown on 10/29/16.
 */



public class RegistrationInfo  {

    Context context;

    public RegistrationInfo (Context context) {
        this.context = context;
    }

    SharedPreferences sharedPref = context.getSharedPreferences("RegistrationInfo", Context.MODE_PRIVATE);


    public void setFirstName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("First Name", value);
        editor.apply();
    }

    public String getFirstName() {
        String value = sharedPref.getString("First Name", "");
        return value;
    }

}


