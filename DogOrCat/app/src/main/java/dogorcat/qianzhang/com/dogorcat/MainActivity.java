package dogorcat.qianzhang.com.dogorcat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgOne;
    private RadioButton radio;

    private SeekBar seek;
    private CheckBox dog;
    private CheckBox cat;
    private CheckBox parrot;
    private RadioGroup rgTwo;
    private RadioButton drool;

    private Button show;
    private TextView seekText;
    int dogCounter = 0;
    int catCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgOne = (RadioGroup) findViewById(R.id.radioGroupId);

        seek = (SeekBar)findViewById(R.id.seekBarId);
        dog = (CheckBox)findViewById(R.id.dogId);
        cat = (CheckBox)findViewById(R.id.catId);
        parrot= (CheckBox)findViewById(R.id.parrotId);
        rgTwo = (RadioGroup) findViewById(R.id.radoiGroupDrool);

        show = (Button) findViewById(R.id.button);
        seekText = (TextView)findViewById(R.id.textView3);
        seekText.setText("Comforatble: " + seek.getProgress() + "/" + seek.getMax());
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekText.setText("Comforatble: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dog.isChecked() && !cat.isChecked() && !parrot.isChecked()){
                    dogCounter += 5;
                }else if(cat.isChecked() && !dog.isChecked() && !parrot.isChecked())
                {
                    catCounter += 5;
                }else{

                }

                rgOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int id = rgOne.getCheckedRadioButtonId();
                        radio = (RadioButton) findViewById(id);
                        if(radio.getText().equals("Yes")){
                            dogCounter += 5;
                        }
                    }
                });

                rgTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        drool= (RadioButton) findViewById(rgTwo.getCheckedRadioButtonId());
                        if(drool.getText().equals("Yes")){
                            dogCounter += 5;
                        }
                    }
                });



                Intent i =new Intent(MainActivity.this, Result_Activity.class);
                i.putExtra("catCount", catCounter);
                i.putExtra("dogCount", dogCounter);
                startActivity(i);
            }
        });
    }
}
