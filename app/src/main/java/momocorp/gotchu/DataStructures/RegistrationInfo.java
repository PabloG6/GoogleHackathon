package momocorp.gotchu.DataStructures;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ShumbaBrown on 10/29/16.
 */



public class RegistrationInfo  {

    public static final String S_EM_CON = "S_EM_CON";
    public static final String TOTAL_DRINK = "TOTAL DRINIKS";
    public static final String EL_TIME = "ELAPSED TIME";
    public static final String AL_CONTENT = "Alcohol Content";
    public static final String NAME = "NAME";

    public static final String EMERGENCY_PHONE_NUM = "EMERGENCY NUMBER";
    public static final String S_EM_PHONE = "S EM PHONE";

    Context context;
    SharedPreferences sharedPref;
    public static final String WEIGHT = "WEIGHT";
    public static final String FIRST = "FIRST";
    public static final String LAST = "LAST";
    public static final String GENDER = "GEN";
    public static final String HEIGHT = "HEI";
    public static final String F_EM_CON = "first emergency contact";
    public static final String L_EM_CON = "s_em_con";
    public static final String AGE = "age";
    public static final String REG_INFO = "RegistrationInfo";
    private String secEmergenConName;
    private int elapsedTime;
    private float currentTime;

    public RegistrationInfo (Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences(REG_INFO, Context.MODE_PRIVATE);



    }



    public void setFirstName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("First Name", value);
        editor.apply();
    }

    public String getFirstName() {
        return sharedPref.getString("First Name", "");
    }

    public void setLastName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Last Name", value);
        editor.apply();
    }

    public String getLastName() {
        return sharedPref.getString("Last Name", "");
    }

    public void setEmergencyContactFirstName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Emergency Contact First Name", value);
        editor.apply();
    }

    public String getEmergencyContactFirstName() {
        return sharedPref.getString("Emergency Contact First Name", "");
    }

    public void setEmergencyContactLastName(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Emergency Contact Last Name", value);
        editor.apply();
    }

    public String getEmergencyContactLastName() {
        return sharedPref.getString("Emergency Contact Last Name", "");
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

    public void setAge(float value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(AGE, value);
        editor.apply();
    }

    public float getAge() {
        float value = sharedPref.getFloat(AGE, 0);
        return value;
    }

    public void setWeight(float value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(WEIGHT, value);
        editor.apply();
    }

    public long getWeight() {
        return sharedPref.getLong(WEIGHT, 0);
    }

    public void setHeight(float value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(HEIGHT, value);
        editor.apply();
    }

    public float getHeight() {
        return sharedPref.getFloat("Height", 0);
    }

    public void setEmergencyContactNumber(String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(F_EM_CON, value);
        editor.apply();
    }
    public void setSecEmergenConName(String i1){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(S_EM_CON, i1);
        editor.apply();

    }
//var list = [];


    public String getSecEmergenConName() {

        return secEmergenConName;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(EL_TIME, currentTime);
        editor.apply();
    }

    public int getElapsedTime() {
        elapsedTime = (int) (currentTime - System.currentTimeMillis());
        return elapsedTime;
    }

    public void setAlcoholContent(long alcoholContent) {
        SharedPreferences.Editor edit = context.getSharedPreferences(RegistrationInfo.REG_INFO, Context.MODE_PRIVATE).edit();
        edit.putLong(AL_CONTENT, alcoholContent).apply();

    }


}


