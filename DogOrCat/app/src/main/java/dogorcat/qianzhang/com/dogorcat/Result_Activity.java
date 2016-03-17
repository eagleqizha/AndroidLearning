package dogorcat.qianzhang.com.dogorcat;

import android.media.Image;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result_Activity extends AppCompatActivity {
    private TextView showResult;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);
        showResult = (TextView)findViewById(R.id.resultId);
        image = (ImageView) findViewById(R.id.imageId);
        Bundle extra = getIntent().getExtras();
        if(extra !=null) {
            int cat = extra.getInt("catCount");
            int dog = extra.getInt("dogCount");
            if(cat >= dog){
                showResult.setText("Cat Person!");
                image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.icon_lg_cat, null) );
            }
            else if(cat < dog){
                showResult.setText("Dog Person!");
                image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.icon_lg_dog, null) );
            }else{
                showResult.setText("Neither");
            }
        }
    }
}
