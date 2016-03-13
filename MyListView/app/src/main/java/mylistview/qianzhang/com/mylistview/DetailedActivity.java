package mylistview.qianzhang.com.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {
private TextView text;
    private Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        text = (TextView)findViewById(R.id.textId);
        extra = getIntent().getExtras();
        if(extra != null){
            text.setText(extra.getString("name"));

        }

    }

}
