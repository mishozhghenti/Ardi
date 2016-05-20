package ge.ardi.mobapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.home)
    TextView homeTextView;

    @Bind(R.id.language)
    TextView languageTextView;

    @Bind(R.id.my_page_text)
    TextView myPageTextView;

    @Bind(R.id.calculator_text)
    TextView calculatorTextView;

    @Bind(R.id.ardimedi_text)
    TextView arimediTextView;

    @Bind(R.id.ardicard_text)
    TextView ardicardTextView;

    @Bind(R.id.sos_text)
    TextView sosTextView;

    @Bind(R.id.zarali_text)
    TextView zaraliTextView;

    @Bind(R.id.info_text)
    TextView infoTextView;

    @Bind(R.id.contact_text)
    TextView contactTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setFonts();
     /*   final List<NameValuePair> args = new ArrayList<NameValuePair>();
        args.add(new BasicNameValuePair("Email", "guka@yahoo.com"));
        args.add(new BasicNameValuePair("Password","Aa@1234567!"));
        args.add(new BasicNameValuePair("ConfirmPassword", "Aa@1234567!"));
        final JSONHttpClient jsonHttpClient = new JSONHttpClient();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("here","here1");
                jsonHttpClient.PostParams("http://greenhillsstudio.com/api/account/register/", args, null);
                Log.e("here","here2");
            }
        }).start();*/

     /*   Map<String, String> data = new HashMap<>();
        String URL = "http://beladent-001-site1.htempurl.com/api/Values/?value=misho2";
        data.put("key","saxli");
        new SendDataToServer(data, URL, getApplicationContext());
        Log.e("aaa", "wevida");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

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


    private Bitmap mySelectedImage;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            /**
             * get BitMap of an image
             */
            mySelectedImage = BitmapFactory.decodeFile(picturePath);


            /**
             * BitMap to string
             */
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mySelectedImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            String bitMapString = Base64.encodeToString(byteArray, Base64.DEFAULT);


            /**
             * string to BitMap
             */
            byte[] decodedString = Base64.decode(bitMapString, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);



          /*  ImageView imageView = (ImageView) findViewById(R.id.selected_image);
            imageView.setImageBitmap(decodedByte);*/


        }
    }

    public void chooseOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }


    public void onClickLang(View view) {

        String languageToLoad = "";
        if (languageTextView.getText().equals("ქარ")) {
            languageToLoad = "en";
        } else {
            languageToLoad = "ka";
        }
        
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        languageTextView.setText(getString(R.string.language));
        homeTextView.setText(getString(R.string.main));
        myPageTextView.setText(getString(R.string.my_page));
        calculatorTextView.setText(getString(R.string.calculator));
        arimediTextView.setText(getString(R.string.ardimedi));
        ardicardTextView.setText(getString(R.string.ardi_card));
        sosTextView.setText(getString(R.string.ardi_sos));
        zaraliTextView.setText(getString(R.string.zarali));
        infoTextView.setText(getString(R.string.info));
        contactTextView.setText(getString(R.string.contacct));
    }


    public void myPageListener(View view) {
        Intent goToMyPage = new Intent(getApplicationContext(), MyPage.class);
        startActivity(goToMyPage);
    }

    private void setFonts() {
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "bpg_nino_mtavruli_normal.ttf");

        languageTextView.setTypeface(myTypeface);
        homeTextView.setTypeface(myTypeface);
        myPageTextView.setTypeface(myTypeface);
        calculatorTextView.setTypeface(myTypeface);
        arimediTextView.setTypeface(myTypeface);
        ardicardTextView.setTypeface(myTypeface);
        sosTextView.setTypeface(myTypeface);
        zaraliTextView.setTypeface(myTypeface);
        infoTextView.setTypeface(myTypeface);
        contactTextView.setTypeface(myTypeface);
    }
}
