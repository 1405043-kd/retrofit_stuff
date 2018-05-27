package clandestine.medict;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ListView listView;
    private DatabaseReference mDatabase;
    private ArrayList<String> subList=new ArrayList<>();

// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

////        // Write a message to the database
////        FirebaseDatabase database = FirebaseDatabase.getInstance();
////        DatabaseReference myRef = database.getReference("message");
//
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        mDatabase.setValue("Hello, World!");
////        tv = (TextView) findViewById(R.id);

        listView = (ListView) findViewById(R.id.pagination_list);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.0.104:8000/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        String type_ob="QuestionSet";

        QuestionClient questionClient = retrofit.create(QuestionClient.class);
        Call<List<Questions>> call_cq =questionClient.cqAll();

        Call<List<QuestionSet>> call_qset =questionClient.q_set();

        Call<List<ExamHistory>> call_ehistory =questionClient.e_history();


//        call_ehistory.enqueue(new Callback<List<ExamHistory>>() {
//            @Override
//            public void onResponse(Call<List<ExamHistory>> call, Response<List<ExamHistory>> response) {
//                System.out.println("hcud");
//                List<ExamHistory> repos = response.body();
//
//                listView.setAdapter(new ExamHistoryAdapter(MainActivity.this, repos));
//            }
//
//            @Override
//            public void onFailure(Call<List<ExamHistory>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
//            }
//        });
//


//        call_cq.enqueue(new Callback<List<Questions>>() {
//            @Override
//            public void onResponse(Call<List<Questions>> call, Response<List<Questions>> response) {
//                System.out.println("hcud");
//                List<Questions> repos = response.body();
//
//                listView.setAdapter(new QuestionAdapter(MainActivity.this, repos));
//            }
//
//            @Override
//            public void onFailure(Call<List<Questions>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
//            }
//        });
//





        call_qset.enqueue(new Callback<List<QuestionSet>>() {
            @Override
            public void onResponse(Call<List<QuestionSet>> call, Response<List<QuestionSet>> response) {
                System.out.println("hcud");
                List<QuestionSet> repos = response.body();

                listView.setAdapter(new QuestionSetAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<QuestionSet>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });


//          GitHubClient client = retrofit.create(GitHubClient.class);
//          Call<List<GitHubRepo>> call = client.reposForUser("1405043-kd");
//
//          System.out.println("lulul"+call.clone());
//
//          call.enqueue(new Callback<List<GitHubRepo>>() {
//            @Override
//            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
//                List<GitHubRepo> repos = response.body();
//
//                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
//            }
//
//            @Override
//            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
