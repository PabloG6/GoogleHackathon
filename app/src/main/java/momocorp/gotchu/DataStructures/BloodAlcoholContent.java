package momocorp.gotchu.DataStructures;

import android.content.Context;

/**
 * Created by ShumbaBrown on 10/29/16.
 */

public class BloodAlcoholContent {

    RegistrationInfo registrationInfo;
    public int totalDrinks = 0;


    public BloodAlcoholContent(Context context){
         registrationInfo = new RegistrationInfo(context);
    }

    public int calculateAlcoholGrams(int totalDrinks){

        int totalGrams = totalDrinks * 14;

        return totalGrams;

    }

    public int addDrink(){
        return totalDrinks++;
    }



    public float calculateBloodAlcoholContent(float gramsAlcohol, float time){
    /* units are assumed to be as follows:
        - Volume : Fluid ounces
        - Weight: Pounds (lbs)
        - Time: Milliseconds

    */
        float bac = 0.0f;
        float timeH = convertMilliseconds(time);

        if (registrationInfo.getGender() == "Female"){
            bac = (float) (gramsAlcohol / (0.66 * (454 * registrationInfo.getWeight())) - (0.015 * timeH));

        }
        else{
            bac = (float) (gramsAlcohol / (0.73 * (454 * registrationInfo.getWeight())) - (0.015 * timeH));
        }

        return bac;

    }

    public float convertMilliseconds(float milliseconds){
        float hours;

        hours = (milliseconds/1000)/3600;
        return hours;
    }
}


