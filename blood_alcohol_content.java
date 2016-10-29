public static int calcBAC(){
    float weightLbs = 0;// weight in pounds
    float weightGs = weightLbs * 454; // weight in grams
    float alchGrams = drinkVolume * alchCont * 0.789;// alcohol amount in grams
    float weightdist; // weight * gender ratio
    float rawBac = 0, bac = 0; // raw blood alcohol content and as a percentage
    String gender; //gender



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
