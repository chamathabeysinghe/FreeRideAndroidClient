package com.codepathz.freeride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codepathz.freeride.utils.UserDataQuery;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button submitVehicleButton;
    private EditText numberEditText;
    private EditText typeEditText;
    private EditText colorEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_register);
        submitVehicleButton= (Button) findViewById(R.id.submitVehicleButton);
        numberEditText= (EditText) findViewById(R.id.numberEditText);
        typeEditText= (EditText) findViewById(R.id.typeEditText);
        colorEditText= (EditText) findViewById(R.id.colorEditText);

        submitVehicleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String number=numberEditText.getText().toString();
        final String type=typeEditText.getText().toString();
        final String color=colorEditText.getText().toString();
        final Long driverId=1l;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://localhost:8888/SpringBootCRUDApp/api/registerUser";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response",response);
                        // Display the first 500 characters of the response string.
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error","Volley error occurred "+error.getMessage());
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("number",number);
                params.put("type",type);
                params.put("color",color);
                params.put("driverId", UserDataQuery.findUserCode());
                return params;
            }
        };

        queue.add(stringRequest);
    }
}
