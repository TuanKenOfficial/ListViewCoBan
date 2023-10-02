package com.example.hoclistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView2Activity extends AppCompatActivity {

    ListView lvData2;
    String []arrData2;
    ArrayAdapter<String>adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvData2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListView2Activity.this,"Bạn chọn ["+arrData2[i]+"]",Toast.LENGTH_LONG).show();
            }
        });
//        lvData2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String s=arrData2[i];
//                adapter2.remove(s);
//                return false;
//            }
//        });
    }

    private void addControls() {
        lvData2= (ListView) findViewById(R.id.lvData2);
        arrData2=getResources().getStringArray(R.array.myArray); //chú ý String Array
        //tạo adapter:
        adapter2=new ArrayAdapter<String>(
                ListView2Activity.this,
                android.R.layout.simple_list_item_1,
                arrData2);
        //gán adapter cho listView:
        lvData2.setAdapter(adapter2);
    }
}
