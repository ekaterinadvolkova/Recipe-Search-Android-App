package fi.metropolia.easytocook;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    ListActivity listActivity;
    List<Activity_recipe_detail> modelList;
    Context context;

    public CustomAdapter(ListActivity listActivity, List<Activity_recipe_detail> modelList, Context context) {
        this.listActivity = listActivity;
        this.modelList = modelList;
        this.context = context;
    }

    /*@NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //inflate layout
        View itemView = LayoutInflater.from(ViewGroup.getContext()
                .inflate(R.layout.model_layout, viewGroup, false));


        //handle item clicks here
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}*/
