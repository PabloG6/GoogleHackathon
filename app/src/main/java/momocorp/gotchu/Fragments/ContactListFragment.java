package momocorp.gotchu.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import momocorp.gotchu.Adapters.ContactAdapter;
import momocorp.gotchu.R;



public class ContactListFragment extends Fragment {



    // TODO: Rename and change types of parameters


    public ContactListFragment() {
        // Required empty public constructor
    }


    public static ContactListFragment newInstance() {

        return new ContactListFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);


        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }



    public interface OnFragmentInteractionListener {

    }



}
