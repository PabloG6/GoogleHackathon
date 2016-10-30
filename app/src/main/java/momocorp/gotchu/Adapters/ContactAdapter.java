package momocorp.gotchu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import momocorp.gotchu.DataStructures.ContactInformation;
import momocorp.gotchu.DataStructures.ContactStructures;
import momocorp.gotchu.R;

/**
 * Created by Pablo on 10/29/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactStructures> contactList;
    public ContactAdapter(Context context){
        this.context = context;
        contactList = new ContactInformation().fetchContact(context);

    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView phoneNumber;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.contact_name);
            phoneNumber = (TextView) itemView.findViewById(R.id.contact_number);
        }
    }
}
