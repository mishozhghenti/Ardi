package ge.ardi.mobapp.HelperClasses;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by m1sho on 4/17/2016.
 */
public class SendDataToServer {
    private int control = 0;

    public SendDataToServer(final Map<String, String> data, String url, final Context context) {
        send(data, url, context);
    }

    private void send(final Map<String, String> data, final String url, final Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e(url, String.valueOf(control));
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                data.toString();
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        stringRequest.setTag(url);
        requestQueue.add(stringRequest);
    }

}