package momocorp.gotchu.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import momocorp.gotchu.DataStructures.ContactInformation;
import momocorp.gotchu.DataStructures.ContactStructures;
import momocorp.gotchu.DataStructures.RegistrationInfo;
import momocorp.gotchu.R;
import momocorp.gotchu.RegistrationFragment;

/**
 * Created by Pablo on 10/29/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactStructures> contactList;
    RegistrationInfo regInfo;
    public int pickTwo;
    SharedPreferences sharedPreferences;
    RegistrationFragment.RegistrationFragmentListener regListener;

    public ContactAdapter(Context context) {
        this.context = context;
        contactList = new ContactInformation().fetchContact(context);
        regInfo = new RegistrationInfo(context);
        regListener = (RegistrationFragment.RegistrationFragmentListener) context;
      sharedPreferences = context.getSharedPreferences(RegistrationInfo.REG_INFO, Context.MODE_PRIVATE);


    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactAdapter.ViewHolder holder, int position) {
       final String name = contactList.get(holder.getAdapterPosition()).getName();
       final String phone = contactList.get(holder.getAdapterPosition()).getPhoneNumber();
        holder.name.setText(name);
        holder.phoneNumber.setText(phone);
        holder.personImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pickTwo == 0){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(RegistrationInfo.EMERGENCY_PHONE_NUM, phone);
                    editor.putString(RegistrationInfo.F_EM_CON, name).apply();
                    pickTwo++;

                } else if (pickTwo==1) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(RegistrationInfo.S_EM_CON, name);
                    editor.putString(RegistrationInfo.S_EM_PHONE, phone);
                    editor.apply();



                    pickTwo++;
                }

                holder.personImage.setImageResource(R.drawable.ic_done_red_50_24dp);

                checkPick(pickTwo);
            }
        });
    }

    private void checkPick(int pickTwo) {
        if(pickTwo>1){
             regListener.completeEmergencyPick();
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView phoneNumber;
        public ImageView personImage;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.contact_name);
            phoneNumber = (TextView) itemView.findViewById(R.id.contact_number);
            personImage = (ImageView) itemView.findViewById(R.id.contact_image);
        }
    }
}
