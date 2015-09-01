package joydroid.kanokpan.hello;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.LiveFolders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private ListView trafficListView;
    private Button aboutMeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget ประกาศการผูกความสัมพันธ์ของตัวแปร กับ widget
        bindWidget();

        //Button Controller
        buttonController();

        //create listview
        createListView();
    }   // this is main method, first method to start working
    private void createListView() {

        final int[] intImage = {R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
                R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
                R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12,
                R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
                R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18,
                R.drawable.traffic_19, R.drawable.traffic_20};

        final String[] strTitle = new String[20];
        strTitle[0] = "ห้ามเลียวซ้าย";
        strTitle[1] = "ห้ามเลียวขวา";
        strTitle[2] = "ให้ตรงไป";
        strTitle[3] = "เลียวขวา";
        strTitle[4] = "เลียวซ้าย";
        strTitle[5] = "หยุด";
        strTitle[6] = "ทางเข้า";
        strTitle[7] = "ทางออก";
        strTitle[8] = "หยุด";
        strTitle[9] = "จำกัดความสูง";
        strTitle[10] = "ทางแยก";
        strTitle[11] = "ห้ามกลับรถ";
        strTitle[12] = "หยุด";
        strTitle[13] = "รถสวน";
        strTitle[14] = "ห้ามแซง";
        strTitle[15] = "เข้า";
        strTitle[16] = "หยุด";
        strTitle[17] = "จำกัดความเร็ว";
        strTitle[18] = "จำกัดความกว่า";
        strTitle[19] = "จำกดความสูง";

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intImage, strTitle);
        trafficListView.setAdapter(objMyAdapter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Intent to DetailActivity
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);
                objIntent.putExtra("Title", strTitle[i]);
                objIntent.putExtra("Image", intImage[i]);
                objIntent.putExtra("Index", i);
                startActivity(objIntent);


            }   // event
        });


    }   // createListView
//    private void createListview() {
//        final int[] intImage= {R.drawable.traffic_01, R.drawable.traffic_02,R.drawable.traffic_03,R.drawable.traffic_04,R.drawable.traffic_05,
//                R.drawable.traffic_06,R.drawable.traffic_07, R.drawable.traffic_08,R.drawable.traffic_09,R.drawable.traffic_10,
//                R.drawable.traffic_11, R.drawable.traffic_12,R.drawable.traffic_13,R.drawable.traffic_14,R.drawable.traffic_15,
//                R.drawable.traffic_16,R.drawable.traffic_17, R.drawable.traffic_18,R.drawable.traffic_19,R.drawable.traffic_20};
//        //or  int intImage[]= {};
//        final String[] strTitle = new String[20];  //reserve 20 string variables
//        strTitle[0] = "ห้ามเลี้ยวซ้าย";
//        strTitle[1] = "ห้ายเลี้ยวขวา";
//        strTitle[2] = "ตรงไป";
//        strTitle[3] = "เลี้ยวขาว";
//        strTitle[4] = "เลี้ยวซ้าย";
//        strTitle[5] = "ทางออก";
//        strTitle[6] = "ทางเข้า";
//        strTitle[7] = "ทางออก";
//        strTitle[8] = "หยุด";
//        strTitle[9] = "สูงไม่เกิน 2.5 เมตร";
//        strTitle[10] = "ทางแยก";
//        strTitle[11] = "ห้ามกลับรถ";
//        strTitle[12] = "ห้ามจอด";
//        strTitle[13] = "ทางสวน";
//        strTitle[14] = "ห้ามแซง";
//        strTitle[15] = "ทางเข้า";
//        strTitle[16] = "หยุดตรวจ";
//        strTitle[17] = "จำกัดความเร็ว";
//        strTitle[18] = "จำกัดความกว้าง";
//        strTitle[19] = "จำกัดความสูง";
//        MyAdapter objMyAdaptor = new MyAdapter(MainActivity.this, intImage,strTitle );
//        trafficListView.setAdapter(objMyAdaptor);
//        //select at icon, then get int value for next step
//        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //Intent to DetailActivity
//                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);  //move from one activity to another activity
//                objIntent.putExtra("Title", strTitle[i]);
//                objIntent.putExtra("Image", intImage[i]);
//                objIntent.putExtra("Index", i);
//                startActivity(objIntent);
//
//            }
//        });
//    }   // Listview method

    private void buttonController() {
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //when click will active event here
                //sound effect
                MediaPlayer buttonPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
                buttonPlayer.start();
                //Intent to webview, after click then go to website/url and can go to other application
                Intent objIntent = new Intent(Intent.ACTION_VIEW);  //ประกาศตัวแปร objIntent
                objIntent.setData(Uri.parse("http://www.hengbao.com/en/"));   //go to this link
                startActivity(objIntent);  //method start activity objIntent
            }  //event
        });


    }

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);


    }   //bindWidget


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}   //Main class
