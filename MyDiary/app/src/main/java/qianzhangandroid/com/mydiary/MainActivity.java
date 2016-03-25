package qianzhangandroid.com.mydiary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText enterText;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText =(EditText)findViewById(R.id.editText);
        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!enterText.getText().toString().equals("")){
                    String data = enterText.getText().toString();
                    writeToFile(data);
                }else{
                    Toast.makeText(getApplicationContext(), "blabla", Toast.LENGTH_LONG).show();
                }
            }
        });
        if(readFromFile() != null) {
            enterText.setText(readFromFile());
        }else{

        }

    }
    private void writeToFile(String myData){
        try{

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("Diary.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(myData);
            outputStreamWriter.close();

        }catch(IOException e){
            Log.v("MyActiviry", e.toString());
        }

    }
    private String readFromFile(){
        String result="";
        try{

            InputStream inputStream = openFileInput("Diary.txt");
            if(inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader  = new BufferedReader(inputStreamReader);
                String temp ="";
                while((temp = bufferedReader.readLine()) != null){
                    result = temp;
                }
            }
            inputStream.close();


        }catch(IOException e){
            Log.v("MyActivity", "Not Found" + e.toString());
        }
        return result;
    }
}
