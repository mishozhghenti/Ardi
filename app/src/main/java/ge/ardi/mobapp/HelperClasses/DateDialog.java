package ge.ardi.mobapp.HelperClasses;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by m1sho on 5/20/2016.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    TextView txtdate;

    public DateDialog(View view) {
        txtdate = (TextView) view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {


// Use the current date as the default date in the dialog
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);


    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        //show to the selected date in the text box
        String date = day + "-" + (month + 1) + "-" + year;
        txtdate.setText(date);
    }
}