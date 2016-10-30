package momocorp.gotchu;

import android.net.Uri;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import momocorp.gotchu.DataStructures.UnitConverter;

public class RegistrationActivity extends AppCompatActivity implements RegistrationFragment.RegistrationFragmentListener {
    private static final String CON_FRAG = "CON";
    private static final String REG_FRAG = "REG_FRAG";
    ContactListFragment contactListFragment;
    RegistrationFragment registrationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //instantiate recyclerView;

        contactListFragment = new ContactListFragment();
        registrationFragment = new RegistrationFragment();
        getFragmentManager().beginTransaction().
                add(R.id.fragment_holder, registrationFragment, REG_FRAG).commit();

    }

    @Override
    public void getContactInformation() {

        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, contactListFragment, CON_FRAG).commit();
    }
}
