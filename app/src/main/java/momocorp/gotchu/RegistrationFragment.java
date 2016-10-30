package momocorp.gotchu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import momocorp.gotchu.DataStructures.RegistrationInfo;
import momocorp.gotchu.DataStructures.UnitConverter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain getActivity() fragment must implement the
 * {@link RegistrationFragmentListener} interface
 * to handle interaction events.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of getActivity() fragment.
 */
public class RegistrationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Spinner weightTypeSpinner, heightTypeSpinner, genderSpinner;
    TextInputEditText age, height, firstName, lastName, weight;
    float ageVal, heightVal, weightVal;
    String first_name, last_name;

    Button getContact;
    TextView emergenCon1;
    TextView emergenCon2;
    UnitConverter unitConverter = new UnitConverter();
    String gender;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RegistrationInfo regInfo;

    private RegistrationFragmentListener mListener;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use getActivity() factory method to create a new instance of
     * getActivity() fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment
        mListener = (RegistrationFragmentListener) getActivity();
        regInfo = new RegistrationInfo(getActivity());
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        emergenCon1 = (TextView) view.findViewById(R.id.emergency_contact_info_1);
        emergenCon2 = (TextView)view.findViewById(R.id.emergency_contact_info_2);


        age = (TextInputEditText) view.findViewById(R.id.age);
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    ageVal =  Float.parseFloat(String.valueOf(charSequence));
                    regInfo.setAge(ageVal);
                }
                else {
                    regInfo.setAge(ageVal);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        height = (TextInputEditText) view.findViewById(R.id.height);
        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (heightVal!=0) {
                    heightVal = Float.parseFloat(String.valueOf(charSequence));
                    regInfo.setHeight(heightVal);

                }
                else{
                    regInfo.setHeight(heightVal);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        weight = (TextInputEditText) view.findViewById(R.id.weight);
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()!=0) {
                    weightVal = Float.parseFloat(String.valueOf(charSequence));
                    regInfo.setWeight(weightVal);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        firstName = (TextInputEditText) view.findViewById(R.id.first_name);
        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                first_name = String.valueOf(charSequence);
                regInfo.setFirstName(first_name);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lastName = (TextInputEditText) view.findViewById(R.id.last_name);

        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                last_name = String.valueOf(charSequence);
                regInfo.setLastName(last_name);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        weightTypeSpinner = (Spinner) view.findViewById(R.id.weight_type_spinner);
        ArrayAdapter<CharSequence> weightChoices = ArrayAdapter.
                createFromResource(getActivity(), R.array.weight_choices, android.R.layout.simple_spinner_item);

        weightChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightTypeSpinner.setAdapter(weightChoices);
        weightTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0) {
                    weightVal = unitConverter.convertToKG(weightVal);
                }
                else {
                    regInfo.setWeight(weightVal);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //height stuff
        heightTypeSpinner = (Spinner) view.findViewById(R.id.height_type_spinner);
        final ArrayAdapter heightAdapt = ArrayAdapter.
                createFromResource(getActivity(), R.array.height_choices, android.R.layout.simple_spinner_item);
        heightAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heightTypeSpinner.setAdapter(heightAdapt);
        heightTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0){
                    // TODO: 10/29/2016 convert getActivity() to cm
                    heightVal = unitConverter.convertToCM((float) adapterView.getItemAtPosition(i));
                    regInfo.setHeight(heightVal);

                }
                else {
                    regInfo.setHeight(heightVal);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //gender stuff
        genderSpinner = (Spinner) view.findViewById(R.id.gender_spinner);
        final ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter
                .createFromResource(getActivity(), R.array.gender_choices, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = (String) adapterView.getItemAtPosition(i);
                regInfo.setGender(gender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        getContact = (Button) view.findViewById(R.id.emergency_contact_button);
        getContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.getContactInformation();
                getContact.setEnabled(false);
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.getContactInformation();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RegistrationFragmentListener) {
            mListener = (RegistrationFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement RegistrationFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void setEmergenCon(String i1, String i2){
        emergenCon1.setText(i1);
        emergenCon2.setText(i2);
    }

    /**
     * getActivity() interface must be implemented by activities that contain getActivity()
     * fragment to allow an interaction in getActivity() fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface RegistrationFragmentListener {
        // TODO: Update argument type and name
        void getContactInformation();
        void completeEmergencyPick();
    }
}
