package momocorp.gotchu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import momocorp.gotchu.Services.DrunkService;

public class DrinkSelectionActivity extends AppCompatActivity implements DrinkTypeFragment.OnFragmentInteractionListener{
    private static final String D_FRAG = "DRINK FRAG";
    FloatingActionButton submit;
    DrinkTypeFragment drinkTypeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drinkTypeFragment = new DrinkTypeFragment();

        getFragmentManager().beginTransaction().add(R.id.frag_layout, drinkTypeFragment, D_FRAG).commit();

        submit = (FloatingActionButton) findViewById(R.id.submit_info);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drinkTypeFragment.submitNumberOfDrinks();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(this, DrunkService.class);
        startService(intent);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
