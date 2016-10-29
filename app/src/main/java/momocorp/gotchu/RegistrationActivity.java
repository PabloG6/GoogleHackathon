package momocorp.gotchu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Spinner weightTypeSpinner;
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
        weightTypeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String weightVal = (String) adapterView.getItemAtPosition(position);

            }
        });





    }

}
