package qianzhangandroid.com.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button saveName;
    private EditText name;
    private TextView showNameText;
    private static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.nameEditText);
        showNameText = (TextView)findViewById(R.id.showMyNameTextView);
        saveName = (Button)findViewById(R.id.saveButton);
        saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();
                if(name.getText().equals("")) {
                    Toast.makeText(getApplicationContext(),"Please enter your name", Toast.LENGTH_LONG).show()
;                }
                else{
                    editor.putString("name", name.getText().toString());
                    editor.commit();
                    showNameText.setText("You name is: "+ name.getText().toString());
                }

            }
        });
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        if(prefs.contains("name")) {
            showNameText.setText("Your name is: " + prefs.getString("name", "not found"));
        }else{
            showNameText.setText("");
        }
    }
}
