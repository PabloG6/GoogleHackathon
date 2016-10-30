package momocorp.gotchu.Adapters;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import momocorp.gotchu.R;
import momocorp.gotchu.Services.DrunkService;

/**
 * Created by Pablo on 10/29/2016.
 */
public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    Context context;
    @Override
    public DrinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_layout_content, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DrinkAdapter.ViewHolder holder, int position) {
        holder.drinkCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView drinkName;
        public ImageView drinkPic;
        public CardView drinkCard;
        public ViewHolder(View itemView) {
            super(itemView);

            drinkName = (TextView) itemView.findViewById(R.id.drink_title);
            drinkPic = (ImageView) itemView.findViewById(R.id.drink_picture);
            drinkCard = (CardView) itemView.findViewById(R.id.drink_card);
        }
    }
}
