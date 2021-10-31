package com.example.ders20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mBaslik[] = {"Gül","Kasımpatı","Lale","Nergis","Zambak"};
    String mAciklama[] = {"Gül Açıklama","Kasımpatı Açıklama","Lale Açıklama","Nergis Açıklama","Zambak Açıklama"};
    int mresim[] = {R.drawable.gul,R.drawable.kasimpati,R.drawable.lale,R.drawable.nergis,R.drawable.zambak};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        benimAdapter adapter = new benimAdapter(this,mBaslik,mAciklama,mresim);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Gül Açıklama", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Kasımpatı Açıklama", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Lale Açıklama", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Nergis Açıklama", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Zambak Açıklama", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class benimAdapter extends ArrayAdapter<String>{
        Context context;
        String rBaslik[];
        String rAciklama[];
        int rresim[];

        benimAdapter (Context c, String baslik[], String Aciklama[], int resim[]){
            super(c, R.layout.custom_listview, R.id.text1, baslik);
            this.context = c;
            this.rBaslik = baslik;
            this.rAciklama = Aciklama;
            this.rresim = resim;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View satir = layoutInflater.inflate(R.layout.custom_listview,parent,false);
            ImageView resim = satir.findViewById(R.id.resim);
            TextView benimBaslik = satir.findViewById(R.id.text1);
            TextView benimAciklama = satir.findViewById(R.id.text2);

            resim.setImageResource(rresim[position]);
            benimBaslik.setText(rBaslik[position]);
            benimAciklama.setText(rAciklama[position]);


            return satir;



        }


    }

}