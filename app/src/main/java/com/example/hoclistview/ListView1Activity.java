package com.example.hoclistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListView1Activity extends AppCompatActivity {

    ListView lvData1;
    String []arrData={"Tuấn Ken","Vĩ Khang","Ngọc Thảo","Như Quỳnh","Tú Lan",
            "Công Bi","Văn Còn","Tuấn Phước","Tuấn Minh","Ngọc Lan"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvData1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListView1Activity.this,"Bạn chọn:"+arrData[i],Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        lvData1= (ListView) findViewById(R.id.lvData1);
        //tạo adapter:
        adapter=new ArrayAdapter<String>(
                ListView1Activity.this,
                android.R.layout.simple_list_item_1,
                arrData
                );
        //gán adapter cho listView:
        lvData1.setAdapter(adapter);
    }
}
