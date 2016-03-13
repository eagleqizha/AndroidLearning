package mylistview.qianzhang.com.mylistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView listView;
    private static final int REQUEST_CODE = 1;
    private String[] values = new String[]{"Hello", "World","Android","Application","My Friend", "I love MoMo","HaHa", "I am Qian Zhang"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int intposition = position;
                String clickedValue = listView.getItemAtPosition(intposition).toString();
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name", clickedValue);
                startActivityForResult(intent, REQUEST_CODE);
                //Toast.makeText(getApplicationContext(),clickedValue,Toast.LENGTH_LONG).show();
            }
        });


    }


}
