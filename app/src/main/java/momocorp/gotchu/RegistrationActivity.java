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
    RegistrationInfo registrationInfo;
    Spinner weightTypeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //instantiate recyclerView;

        registrationInfo = new RegistrationInfo(this);
        registrationInfo.setFirstName("Shumba");
        Log.i("TAG", registrationInfo.getFirstName());

        weightTypeSpinner = (Spinner) findViewById(R.id.weight_type_spinner);
        ArrayAdapter<CharSequence> weightChoices = ArrayAdapter.
                createFromResource(this, R.array.weight_choices, android.R.layout.simple_spinner_item);

        weightChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightTypeSpinner.setAdapter(weightChoices);
        weightTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String weightVal = (String) adapterView.getItemAtPosition(i);
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

}
