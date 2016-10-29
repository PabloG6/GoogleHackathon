package momocorp.gotchu;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ShumbaBrown on 10/29/16.
 */



public class RegistrationInfo  {

    Context context;
    SharedPreferences sharedPref;


    public RegistrationInfo (Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences("RegistrationInfo", Context.MODE_PRIVATE);


    }



    public void setFirstName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("First Name", value);
        editor.apply();
    }

    public String getFirstName() {
        String value = sharedPref.getString("First Name", "");
        return value;
    }

    public void setLastName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Last Name", value);
        editor.apply();
    }

    public String getLastName() {
        String value = sharedPref.getString("Last Name", "");
        return value;
    }

    public void setEmergencyContactFirstName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Emergency Contact First Name", value);
        editor.apply();
    }

    public String getEmergencyContactFirstName() {
        String value = sharedPref.getString("Emergency Contact First Name", "");
        return value;
    }

    public void setEmergencyContactLastName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Emergency Contact Last Name", value);
        editor.apply();
    }

    public String getEmergencyContactLastName() {
        String value = sharedPref.getString("Emergency Contact Last Name", "");
        return value;
    }

    public void setGender(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Gender", value);
        editor.apply();
    }

    public String getGender() {
        String value = sharedPref.getString("Gender", "");
        return value;
    }

    public void setAge(int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("Age", value);
        editor.apply();
    }

    public int getAge() {
        int value = sharedPref.getInt("Age", 0);
        return value;
    }

    public void setWeight(int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("Weight", value);
        editor.apply();
    }

    public int getWeight() {
        int value = sharedPref.getInt("Weight", 0);
        return value;
    }

    public void setHeight(int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("Height", value);
        editor.apply();
    }

    public int getHeight() {
        int value = sharedPref.getInt("Height", 0);
        return value;
    }

    public void setEmergencyContactNumber(int value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("Emergency Contact Number", value);
        editor.apply();
    }

    public int getEmergencyContactNumber() {
        int value = sharedPref.getInt("Emergency Contact Number", 0);
        return value;
    }


}


