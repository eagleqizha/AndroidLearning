package mylistview.qianzhang.com.mylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {
private TextView text;
    private Bundle extra;
    private Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        text = (TextView)findViewById(R.id.textId);
        extra = getIntent().getExtras();
        if(extra != null){
            text.setText(extra.getString("name"));

        }
        myButton = (Button)findViewById(R.id.buttonId);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent= getIntent();
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });


    }

}
