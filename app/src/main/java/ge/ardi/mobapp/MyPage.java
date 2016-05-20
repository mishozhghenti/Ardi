package ge.ardi.mobapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyPage extends AppCompatActivity {

    @Bind(R.id.entered_user_name)
    EditText enteredUserName;

    @Bind(R.id.entered_password)
    EditText enteredPassword;

    @Bind(R.id.login)
    TextView loginText;

    @Bind(R.id.registration)
    TextView registration;

    @Bind(R.id.forget_password)
    TextView forget_password;

    @Bind(R.id.home)
    TextView homeTitle;

    @Bind(R.id.language)
    TextView language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        ButterKnife.bind(this);
        setFonts();
    }

    public void goBackListener(View view) {
        onBackPressed();
    }

    public void goToRegistration(View view) {
        Intent goToRegistration = new Intent(this, Registration.class);
        startActivity(goToRegistration);
    }


    private void setFonts() {
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "bpg_nino_mtavruli_normal.ttf");
        enteredUserName.setTypeface(myTypeface);
        enteredPassword.setTypeface(myTypeface);
        loginText.setTypeface(myTypeface);
        registration.setTypeface(myTypeface);
        forget_password.setTypeface(myTypeface);
        homeTitle.setTypeface(myTypeface);
        language.setTypeface(myTypeface);
    }

    public void changeLanguage(View view) {
        String languageToLoad = "";
        if (language.getText().equals("ქარ")) {
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


        enteredUserName.setText(getString(R.string.user));
        enteredPassword.setText(getString(R.string.password));
        loginText.setText(getString(R.string.enter));
        registration.setText(getString(R.string.registration));
        forget_password.setText(getString(R.string.forget_password));
        homeTitle.setText(getString(R.string.registration));
        language.setText(getString(R.string.language));
    }
}
