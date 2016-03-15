package myradiobutton.qianzhang.com.myradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button showChoice;
    private RadioGroup group;
    private RadioButton buttonChoiced;
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showChoice = (Button) findViewById(R.id.showChoiceBtn);
        group = (RadioGroup) findViewById(R.id.radioGroupId);
        show = (TextView) findViewById(R.id.showTextView);
        showChoice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = group.getCheckedRadioButtonId();
                buttonChoiced = (RadioButton)findViewById(position);
                show.setText(buttonChoiced.getText());
            }
        });
    }
}
