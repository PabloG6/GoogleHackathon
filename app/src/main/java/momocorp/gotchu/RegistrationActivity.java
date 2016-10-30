package momocorp.gotchu;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import momocorp.gotchu.DataStructures.UnitConverter;

public class RegistrationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Spinner weightTypeSpinner, heightTypeSpinner, genderSpinner;
    TextInputEditText age, height, firstName, lastName, weight;
    float ageVal, heightVal, weightVal;
    String first_name, last_name;

    UnitConverter unitConverter = new UnitConverter();
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //instantiate recyclerView;

        age = (TextInputEditText) findViewById(R.id.age);
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ageVal =  Float.parseFloat((String) charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        height = (TextInputEditText) findViewById(R.id.height);
        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                heightVal = Float.parseFloat((String) charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        weight = (TextInputEditText) findViewById(R.id.weight);
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                weightVal = Float.parseFloat((String) charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        firstName = (TextInputEditText) findViewById(R.id.first_name);
        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                first_name = (String) charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lastName = (TextInputEditText) findViewById(R.id.last_name);

        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                last_name = (String) charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        weightTypeSpinner = (Spinner) findViewById(R.id.weight_type_spinner);
        ArrayAdapter<CharSequence> weightChoices = ArrayAdapter.
                createFromResource(this, R.array.weight_choices, android.R.layout.simple_spinner_item);

        weightChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightTypeSpinner.setAdapter(weightChoices);
        weightTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0) {
                    weightVal = unitConverter.convertToKG(weightVal);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //height stuff
        heightTypeSpinner = (Spinner) findViewById(R.id.height_type_spinner);
        ArrayAdapter heightAdapt = ArrayAdapter.
                createFromResource(this, R.array.height_choices, android.R.layout.simple_spinner_item);
        heightAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heightTypeSpinner.setAdapter(heightAdapt);
        heightTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if (i!=0){
                // TODO: 10/29/2016 convert this to cm
                heightVal = unitConverter.convertToCM((float) adapterView.getItemAtPosition(i));

               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //gender stuff
        genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter
                .createFromResource(this, R.array.gender_choices, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









    }

}
