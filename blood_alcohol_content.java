public static float calcBAC(float alclvl, float vol, float weightLbs,
float time,float bac ,String gender){
    /* units are assumed to be as follows:
        - Volume : Fluid ounces
        - Weight: Pounds (lbs)
        - Time: Hours

    */
    float alclvl, vol, weightLbs, time, bac;
    String gender;

    if f(sex == "Female"){
        bac = alclvl * vol * * 0.823 * 0.66 / (16 * weight) - 0.015 * t;

    }
    else{
        bac = alclvl * vol * * 0.823 * 0.73 / (16 * weight) - 0.015 * t;
    }

    return bac;

}

public static float convertMins(float mins){
    float hours;

    hours = mins/60;
    return hours;
}
