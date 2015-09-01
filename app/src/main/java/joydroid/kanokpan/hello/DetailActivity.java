package joydroid.kanokpan.hello;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    //Explicit variables
    TextView titleTextView,detailTextView; //ประกาศ private แบบย่อ
    //private variable, other class can use this variable
    ImageView trafficImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Bind Widget
        bindWidget();  //this is variable name, manual type full name 'bindWidget'


        //show title
        showTitle();

        //show image
        showImage();
        //show detailtext
        showDetail();

    }  //onCreate

    //click back button
    public void clickBack(View view) {
        finish();
    }

    private void showDetail() {
        String[] strDetail = getResources().getStringArray(R.array.detail);
        detailTextView.setText(strDetail[getIntent().getIntExtra("Index", 0)]);

    }

    private void showImage() {
        int intImage = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        trafficImageView.setImageResource(intImage);


    }

    private void showTitle() {
        String strTitle = getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

    }


    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        detailTextView = (TextView) findViewById(R.id.txtDetail);
        trafficImageView = (ImageView) findViewById(R.id.imvTrafficDetail);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}//main class of DetailActivity

