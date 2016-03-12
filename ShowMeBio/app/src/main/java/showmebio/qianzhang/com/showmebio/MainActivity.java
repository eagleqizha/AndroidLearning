package showmebio.qianzhang.com.showmebio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{
    private ImageView bach;
    private ImageView mozart;
    private static final int REQUEST_CODE = 1;
    private String bachBio = "Johann Sebastian Bach was a German composer and musician of the Baroque period";
    private String mozartBio = "Wolfgang Amadeus Mozart was a prolific and influential composer of the Classical era, born in Salzburg.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bach = (ImageView)findViewById(R.id.bachImage);
        mozart = (ImageView)findViewById(R.id.mozartImage);

        bach.setOnClickListener(this);
        mozart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bachImage:

                Intent bachIntent = new Intent(MainActivity.this, detail_Activity.class);
                bachIntent.putExtra("bach", bachBio);
                bachIntent.putExtra("name", "bach");
                startActivityForResult(bachIntent, REQUEST_CODE);
                break;
            case R.id.mozartImage:
                Intent mozartIntent = new Intent(MainActivity.this, detail_Activity.class);
                mozartIntent.putExtra("mozart",mozartBio);
                mozartIntent.putExtra("name","mozart");
                startActivityForResult(mozartIntent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int result, int returnResult, Intent data){
        if(result == REQUEST_CODE){
            if(returnResult == RESULT_OK){

            }
        }

    }
}
