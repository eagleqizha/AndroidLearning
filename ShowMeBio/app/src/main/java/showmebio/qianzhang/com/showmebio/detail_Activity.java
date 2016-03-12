package showmebio.qianzhang.com.showmebio;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detail_Activity extends Activity {
    private ImageView bioView;
    private TextView bioText;
    private TextView name;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        bioView = (ImageView)findViewById(R.id.bioImageId);
        bioText = (TextView)findViewById(R.id.bioTextId);
        extras = getIntent().getExtras();
        name = (TextView)findViewById(R.id.nameId);


        if(extras != null){


            String name = extras.getString("name");

            showDetailed(name);
        }

    }
    public void showDetailed(String nameIn){
        if(nameIn.equals("bach")){


            bioView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.bach_profile,null));
            bioText.setText(extras.getString("bach"));
            name.setText(nameIn);

        }else{
            bioView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mozart_profile,null));
            bioText.setText(extras.getString("mozart"));
            name.setText(nameIn);
        }
    }
}
