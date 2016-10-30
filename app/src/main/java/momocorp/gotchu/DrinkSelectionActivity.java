package momocorp.gotchu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DrinkSelectionActivity extends AppCompatActivity {
    private static final String D_FRAG = "DRINK FRAG";
    DrinkTypeFragment drinkTypeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drinkTypeFragment = new DrinkTypeFragment();

        getFragmentManager().beginTransaction().add(R.id.drink_content_fragment, drinkTypeFragment, D_FRAG).commit();


    }

}
