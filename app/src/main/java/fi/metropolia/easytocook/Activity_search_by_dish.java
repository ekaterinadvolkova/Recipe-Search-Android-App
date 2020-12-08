package fi.metropolia.easytocook;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import fi.metropolia.easytocook.receipe.Dish;


    public class Activity_search_by_dish extends AppCompatActivity {
        FirebaseFirestore  recipe;
        public static final String TAG = "myApp";
        public EditText searchh;

        private final View.OnClickListener myClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == findViewById(R.id.btnSearchDish)) {
                    retrieveDate();
                    //Intent intentRecipe = new Intent(getApplicationContext(), Activity_recipe_detail.class);
                    //startActivity(intentRecipe);
                }
            }
        };

        public void retrieveDate (){
            searchh = findViewById(R.id.searchOnDish);
            Object search = searchh.getText().toString();

            recipe.collection("recipes")
                .whereEqualTo("Dish", true)
        .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_by_dish);
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            //add intent to direct to recipe detail page
            findViewById(R.id.btnSearchDish).setOnClickListener(myClickListener);

            //Task<DocumentReference> documentReferenceTask =recipeDB.collection("recipes")


                    //List<Dish> allDishes = recipeDB.collection("recipes")

            /*ListView lvOfDishes = findViewById(R.id.listViewOnDishSearch);
            lvOfDishes.setAdapter(new ArrayAdapter<Dish>(
                    this,
                    android.R.layout.simple_list_item_1,
                    allDishes
            ));*/

            /*lvOfDishes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Log.d(Activity_create_account.TAG,"onItemClick("+ position +")");

                    Dish d = allDishes.get(position);
                    //Log.d(Activity_create_account.TAG,"click dish"+ d.dishId);

                    Intent intent = new Intent (getApplicationContext(),Activity_recipe_detail.class);
                    //intent.put("indexOfDish",d.dishId);

                    Log.d("Dish",Integer.toString(position));
                    startActivity(intent);
                }
            });*/
        }
    }

    /*List<Model>modelList=new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Adapter adapter;

    ProgressDialog pd;*/

    /*Button searchbtn;
    private EditText search;
    public static final String TAG = "recipe search";
    ListView listView;
    ArrayList<String> recipesList = new ArrayList<>();*/

    /*private void searchData(String query) {

        db.collection("recipes").whereEqualTo("search ", query.toLowerCase())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        modelList.clear();

                        //if search is successful

                        //show data
                        for (DocumentSnapshot doc: task.getResult()){
                            Model model = new Activity_recipe_detail(doc.getString("Dish"));
                            doc.getString("Dish"),
                                    model.getString("Ingredient"),
                                    model.getString("Cooking Time"),
                                    model.getString("Calories");
                            model.doc.getString("Dish");
                            modelList.add(model);
                        }
                        //adapter
                        adapter = new CustomAdapter(Activity_search_by_dish.this, modelList);
                        mRecyclerView.setAdapter(adapter);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //if search fails
                        pd.dismiss();
                        Toast.makeText(Activity_search_by_dish.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });*/

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_dish);
        //ListView = (ListView)findViewById(R.id.listViewOnDishSearch);
        db=FirebaseFirestore.getInstance();
        //searchbtn = findViewById(R.id.btnSearchDish);

        //set onClick listener
        //searchbtn.setOnClickListener(this::onClick);

        //initialise views
        //RecyclerView = findViewById(R.id.recycler_view);

    }

    //menu
    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        //inflating menu_search_by_dish.xml
        getMenuInflater().inflate(R.menu.menu_search_by_dish,menu);

        //Search view
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //called when search button pressed
                //searchData(query); //function call with string entered in searchview as parameter
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //called when something is typed
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        //handle other menu item clicks here
        if(item.getItemId()==R.id.action_settings){
            Toast.makeText(this,"Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }*/

    /*private void onClick(View view) {
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
    }*/



