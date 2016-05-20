package ge.ardi.mobapp;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import ge.ardi.mobapp.HelperClasses.DateDialog;

public class Registration extends AppCompatActivity {
    @Bind(R.id.home)
    TextView homeTitle;

    @Bind(R.id.language)
    TextView language;


    @Bind(R.id.first_name_view)
    PercentRelativeLayout firstNameView;

    @Bind(R.id.last_name_view)
    PercentRelativeLayout lastNameView;

    @Bind(R.id.calendar_view)
    PercentRelativeLayout calendarView;

    @Bind(R.id.personal_number_view)
    PercentRelativeLayout personalNumberView;

    @Bind(R.id.mobile_number_view)
    PercentRelativeLayout mobileNumberView;
    /*------------------------*/
    @Bind(R.id.mail_view)
    PercentRelativeLayout mailView;

    @Bind(R.id.policy_view)
    PercentRelativeLayout policyView;

    @Bind(R.id.user_view)
    PercentRelativeLayout userView;

    @Bind(R.id.password_view)
    PercentRelativeLayout passwordView;

    @Bind(R.id.password_confirm_view)
    PercentRelativeLayout passwordConfirmView;

    @Bind(R.id.next_button)
    TextView nextButton;

    @Bind(R.id.first_name)
    EditText firstName;
    @Bind(R.id.last_name)
    EditText lastName;
    @Bind(R.id.birthday)
    TextView birthday;
    @Bind(R.id.personal_number)
    EditText personaID;
    @Bind(R.id.mobile_number)
    EditText mobile;
    @Bind(R.id.entered_mail)
    EditText mail;
    @Bind(R.id.entered_policy)
    EditText plicy;
    @Bind(R.id.entered_user)
    EditText enteredUser;
    @Bind(R.id.entered_password)
    EditText password;
    @Bind(R.id.entered_password_confirm)
    EditText confirmedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        setFonts();

    }

    public void goBackListener(View view) {
        onBackPressed();
    }


    public void onClickCalendar(View view) {
        DateDialog dialog = new DateDialog(view);
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        dialog.show(ft, "DatePicker");
    }




    private boolean clicked = false;

    public void onClickOnNext(View view) {
        if (!clicked) {
            firstNameView.setVisibility(View.INVISIBLE);
            lastNameView.setVisibility(View.INVISIBLE);
            calendarView.setVisibility(View.INVISIBLE);
            personalNumberView.setVisibility(View.INVISIBLE);
            mobileNumberView.setVisibility(View.INVISIBLE);
            clicked = true;
            mailView.setVisibility(View.VISIBLE);
            policyView.setVisibility(View.VISIBLE);
            userView.setVisibility(View.VISIBLE);
            passwordView.setVisibility(View.VISIBLE);
            passwordConfirmView.setVisibility(View.VISIBLE);
            nextButton.setText(getString(R.string.registration));
        }
    }


    private void setFonts() {
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "bpg_nino_mtavruli_normal.ttf");
        homeTitle.setTypeface(myTypeface);
        language.setTypeface(myTypeface);
        nextButton.setTypeface(myTypeface);

        firstName.setTypeface(myTypeface);
        lastName.setTypeface(myTypeface);
        birthday.setTypeface(myTypeface);
        personaID.setTypeface(myTypeface);
        mobile.setTypeface(myTypeface);

        mail.setTypeface(myTypeface);
        plicy.setTypeface(myTypeface);
        enteredUser.setTypeface(myTypeface);
        password.setTypeface(myTypeface);
        confirmedPassword.setTypeface(myTypeface);
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


        homeTitle.setText(getString(R.string.registration));
        language.setText(getString(R.string.language));
        nextButton.setText(getString(R.string.next));

        firstName.setText(getString(R.string.first_name));
        lastName.setText(getString(R.string.last_name));
        birthday.setText(getString(R.string.birthday));
        personaID.setText(getString(R.string.id));
        mobile.setText(getString(R.string.mobile));

        mail.setText(getString(R.string.e_mail));
        plicy.setText(getString(R.string.policy_number));
        enteredUser.setText(getString(R.string.user));
        password.setText(getString(R.string.password));
        confirmedPassword.setText(getString(R.string.confirm_password));
    }
}
