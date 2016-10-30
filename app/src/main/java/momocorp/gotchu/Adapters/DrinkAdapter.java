package momocorp.gotchu.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import momocorp.gotchu.DataStructures.BloodAlcoholContent;
import momocorp.gotchu.DataStructures.RegistrationInfo;
import momocorp.gotchu.R;
import momocorp.gotchu.Services.DrunkService;

/**
 * Created by Pablo on 10/29/2016.
 */
public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    Context context;
    BloodAlcoholContent bloodAlcoholContent;
    SharedPreferences sharedPreferences;
    View view;

    ArrayList<DrinkValue> drinkValuesArrayList = new ArrayList<>();

    public DrinkAdapter() {
        for (int i = 0; i < 12; i++) {
            drinkValuesArrayList.add(new DrinkValue("Tequila", 0));
        }


    }


    @Override
    public DrinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_layout_content, parent, false);
        context = parent.getContext();
        this.view = view;
        bloodAlcoholContent = new BloodAlcoholContent(context);
        sharedPreferences = context.getSharedPreferences(RegistrationInfo.REG_INFO, Context.MODE_PRIVATE);




        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DrinkAdapter.ViewHolder holder, final int position) {
        holder.drinkName.setText(String.valueOf(drinkValuesArrayList.get(position).getTequila()));
        holder.numOfDrinks.setText(String.valueOf(drinkValuesArrayList.get(position).getI()));
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_val = drinkValuesArrayList.get(position).getI() + 1;
                drinkValuesArrayList.get(position).setI(new_val);
                notifyDataSetChanged();
            }
        });

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int new_val = drinkValuesArrayList.get(position).getI() - 1;
                if (new_val >= 0) {
                    drinkValuesArrayList.get(position).setI(new_val);
                    notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    public int getItemCount() {

        return drinkValuesArrayList.size();
    }

    public void submitDrinks() {
        int total = 0;
        long time;
        for (DrinkValue value :
                drinkValuesArrayList) {
            total += value.getI();

        }
        BloodAlcoholContent.totalDrinks = total;

//        long weight = sharedPreferences.getLong(RegistrationInfo.WEIGHT, 120);
        long weight =120;
        if (sharedPreferences.getLong(RegistrationInfo.EL_TIME, 0)==0) {
             time = System.currentTimeMillis();
            sharedPreferences.edit().putLong(RegistrationInfo.EL_TIME, time).apply();
        } else {
             time = System.currentTimeMillis() - sharedPreferences.getLong(RegistrationInfo.EL_TIME, 0);
            sharedPreferences.edit().putLong(RegistrationInfo.EL_TIME, time).apply();
        }
        BloodAlcoholContent blood = new BloodAlcoholContent(context);

        Snackbar.make(view, "Hey you're current blood alcohol level is"+bloodAlcoholContent.calculateBloodAlcoholContent(), Snackbar.LENGTH_SHORT);
        Log.i("blood alcohol ", ""+blood.calculateBloodAlcoholContent());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView drinkName;

        public TextView numOfDrinks;
        public CardView drinkCard;
        public ImageButton addButton, minusButton;

        public ViewHolder(View itemView) {
            super(itemView);

            drinkName = (TextView) itemView.findViewById(R.id.drink_title);

            drinkCard = (CardView) itemView.findViewById(R.id.drink_card);
            numOfDrinks = (TextView) itemView.findViewById(R.id.number_of_drinks);
            addButton = (ImageButton) itemView.findViewById(R.id.add_drink);
            minusButton = (ImageButton) itemView.findViewById(R.id.minus_drink);

        }
    }
}
