package momocorp.gotchu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Spinner weightTypeSpinner, heightTypeSpinner, ageTypeSpinner, genderSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //instantiate recyclerView;

        weightTypeSpinner = (Spinner) findViewById(R.id.weight_type_spinner);
        ArrayAdapter<CharSequence> weightChoices = ArrayAdapter.
                createFromResource(this, R.array.weight_choices, android.R.layout.simple_spinner_item);

        weightChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightTypeSpinner.setAdapter(weightChoices);
        weightTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String weightType = (String) adapterView.getItemAtPosition(i);

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
               switch (i){
                   case 1:
                       // TODO: 10/29/2016 change value to centimeter

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








    }

}
