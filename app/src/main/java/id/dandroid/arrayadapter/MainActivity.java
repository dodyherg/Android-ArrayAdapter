package id.dandroid.arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Inisialisasi Arraylist
    private List kontenList = new ArrayList();
    //Inisialisasi Array Adapte
    private ArrayAdapter adapter = null;

    //inisialisasi variable listView
    private ListView listView;

    //inisialisasi komponen pendukung
    private EditText InputData;
    private Button Savedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_data);
        InputData =findViewById(R.id.input_data);
        Savedata =findViewById(R.id.save_data);

        //mengatur ArrayAdapter untuk listview
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, kontenList);
        listView.setAdapter(adapter);

        Savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menambahkan konten yang akan di tampilkan pada listV
                konten myKonten = new konten();
                myKonten.setData(InputData.getText().toString());
                adapter.add(myKonten);
                Toast.makeText(getApplicationContext(),"Data tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
