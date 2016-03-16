package mytogglebutton.qianzhang.com.mytogglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton button;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (ToggleButton) findViewById(R.id.toggleButtonId);
        show = (TextView) findViewById(R.id.showViewId);
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    show.setVisibility(View.VISIBLE);
                }else{
                    show.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
