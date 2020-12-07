package fi.metropolia.easytocook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Activity_search_by_dish extends AppCompatActivity {

    Button searchbtn;
    private EditText search;
    public static final String TAG = "recipe search";
    FirebaseFirestore database;
    ListView listView;
    ArrayList<String> recipesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_dish);
        listView = (ListView)findViewById(R.id.listViewOnDishSearch);
        database=FirebaseFirestore.getInstance();
        searchbtn = findViewById(R.id.btnSearchDish);

        //set onClick listener
        searchbtn.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        search = findViewById(R.id.searchOnDish);
        String editText = search.getText().toString();

        database.collection("recipes").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException error) {

                //save doc value in snapshot and save in a string
                for(DocumentSnapshot snapshot : documentSnapshots){
                    //recipesList.add(snapshot.getString("recipe"));

                }
                //create adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item,recipesList);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
            }
        });
    }


}
