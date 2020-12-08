package fi.metropolia.easytocook;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mTitleTv, mdescriptionTv;
    View mView;

    public ViewHolder(@NonNull View itemView){
        super(itemView);
        mView=itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //item long click listener
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        //initialise views with model layout xml
        //mTitleTv = itemView.findViewById(R.id.rTitle);
        //mdescriptionTv = itemView.findViewById(R.id.mDescriotionTv);

        //interface for click listener
        //public interface ClickListener{
        //    void onItemClick
        //}


    }

}
