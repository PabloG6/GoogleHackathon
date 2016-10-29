package momocorp.gotchu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Pablo on 10/29/2016.
 */
public class MyQuestionAdapter extends RecyclerView.Adapter<MyQuestionAdapter.ViewHolder> {
    public MyQuestionAdapter(Context context){

    }


    @Override
    public MyQuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyQuestionAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView view;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    }


