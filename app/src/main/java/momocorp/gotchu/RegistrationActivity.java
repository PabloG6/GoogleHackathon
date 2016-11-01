package momocorp.gotchu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import momocorp.gotchu.DataStructures.RegistrationInfo;
import momocorp.gotchu.Fragments.ContactListFragment;
import momocorp.gotchu.Fragments.RegistrationFragment;

public class RegistrationActivity extends AppCompatActivity implements RegistrationFragment.RegistrationFragmentListener {
    private static final String CON_FRAG = "CON";
    private static final String REG_FRAG = "REG_FRAG";
    public Context context;
    ContactListFragment contactListFragment;
    RegistrationFragment registrationFragment;
    FloatingActionButton doneButton;
    RegistrationInfo regInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //instantiate recyclerView;

        context = this;
        regInfo = new RegistrationInfo(this);

        contactListFragment = new ContactListFragment();
        registrationFragment = new RegistrationFragment();
        getFragmentManager().beginTransaction().

                add(R.id.fragment_holder, registrationFragment, REG_FRAG).commit();
        
        doneButton = (FloatingActionButton) findViewById(R.id.finished);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/29/2016 select type of drinks fragment
                registrationFragment.setInformation();
                Intent intent = new Intent(context, DrinkSelectionActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getContactInformation() {

        getFragmentManager().beginTransaction().add(R.id.fragment_holder, contactListFragment, CON_FRAG).commit();
    }

    @Override
    public void completeEmergencyPick() {
        getFragmentManager().beginTransaction().remove(contactListFragment).commit();


    }
}
