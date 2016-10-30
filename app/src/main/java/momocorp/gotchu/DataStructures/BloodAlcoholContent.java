package momocorp.gotchu.DataStructures;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by ShumbaBrown on 10/29/16.
 */

public class BloodAlcoholContent {
    public static final long femCon = (long) 0.66;
    public static final long malCon = (long) 0.73;
    public static final long alcGram = (long) 14;
    String gender = "Male";
    public static long totalDrinks = 0;

    public BloodAlcoholContent(Context context) {
        gender = context.
                getSharedPreferences(RegistrationInfo.REG_INFO, Context.MODE_PRIVATE).
                getString(RegistrationInfo.GENDER, "Male");
    }


    public double calculateBloodAlcoholContent() {
        return totalDrinks *0.02;


    }

}


