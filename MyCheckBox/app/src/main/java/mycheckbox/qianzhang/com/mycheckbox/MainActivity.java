package mycheckbox.qianzhang.com.mycheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cat;
    private CheckBox dog;
    private CheckBox neither;
    private Button showButton;
    private TextView showView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cat = (CheckBox)findViewById(R.id.catId);
        dog = (CheckBox)findViewById(R.id.dogId);
        neither = (CheckBox) findViewById(R.id.neitherId);
        showButton = (Button) findViewById(R.id.buttonId);
        showView = (TextView) findViewById(R.id.showId);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( neither.isChecked() && (cat.isChecked() || dog.isChecked())){
                    showView.setText("Hei, you chosed neither but also selected one of cat and dog.");
                }
                else {

                    if (cat.isChecked()) {
                        if (dog.isChecked()) {
                            showView.setText("HaHa, you like both cat and dog!");
                        } else {
                            showView.setText("Oh, so you like cat not don't like dog!");
                        }
                    } else {
                        if (dog.isChecked()) {
                            showView.setText("Woo, I also like dog but don't cat!");
                        } else {
                            showView.setText("Woo, what a sad. You don't neither of them.");
                        }

                    }
                }


            }
        });
    }
}
