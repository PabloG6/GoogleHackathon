public static int calcBAC(){
    float weightLbs = 0;
    float weightGs = weightLbs * 454;
    float alchGrams = drinkVolume * alchCont * 0.789;
    float weightdist;
    float rawBac = 0, bac = 0;
    String gender; s



    if (gender == 'Male'){
        weightdist = weightGs * 0.68
    }
    else if (gender == 'Female'){
        weightdist = weightGs * 0.55;
    }

    rawBac = alchGrams / weightdist;
    bac = rawBac * 100;

    return bac;
}
