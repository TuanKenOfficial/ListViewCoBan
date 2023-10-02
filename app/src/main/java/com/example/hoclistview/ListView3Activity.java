package com.example.hoclistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoclistview.model.Contact;

public class ListView3Activity extends AppCompatActivity {

    TextView textView,textView2, textView3;
    EditText edtMa,edtTen,edtPhone;
    Button btnLuu;

    ListView lvContact;
    ArrayAdapter<Contact> contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThemContact();
            }
        });
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListView3Activity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                //Xóa Contact
                Contact c=contactAdapter.getItem(i);
                contactAdapter.remove(c);
                return false;

            }
        });
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact c=contactAdapter.getItem(i);
                //chú ý khi truyền kiểu int vào textview, edt,btn, id nó hiểu là tài nguyên trên giao diện
                //nhưng ở đây id nó hiểu là giá trị id bình thường thôi
                edtMa.setText(c.getId()+"");
                edtTen.setText(c.getName());
                edtPhone.setText(c.getPhone());
                Toast.makeText(ListView3Activity.this, ""+c, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void xuLyThemContact() {
        Contact c=new Contact();
        c.setId(Integer.parseInt(edtMa.getText().toString()));
        c.setName(edtTen.getText().toString());
        c.setPhone(edtPhone.getText().toString());

        contactAdapter.add(c);
    }

    private void addControls() {
        textView= (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3);
        edtMa= (EditText) findViewById(R.id.edtMa);
        edtTen= (EditText) findViewById(R.id.edtTen);
        edtPhone= (EditText) findViewById(R.id.edtPhone);
        btnLuu= (Button) findViewById(R.id.btnLuu);

        lvContact= (ListView) findViewById(R.id.lvContact);
        //tạo adapter
        contactAdapter=new ArrayAdapter<Contact>
                (ListView3Activity.this,
                 android.R.layout.simple_list_item_1);
        //đưa đối tượng ArrayAdapter lên listview
        lvContact.setAdapter(contactAdapter);
    }
}
