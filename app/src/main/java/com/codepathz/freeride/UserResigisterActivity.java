package com.codepathz.freeride;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UserResigisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mSubmitUserButton;
    private EditText nameEditText;
    private EditText nicEditText;
    private EditText telephoneEditText;
    private EditText emailEditText;
    private Spinner genderSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_resigister);

        mSubmitUserButton= (Button) findViewById(R.id.submitUserButton);
        nameEditText= (EditText) findViewById(R.id.nameEditText);
        nicEditText= (EditText) findViewById(R.id.nicEditText);
        telephoneEditText= (EditText) findViewById(R.id.telephoneEditText);
        emailEditText= (EditText) findViewById(R.id.emailEditText);
        genderSpinner= (Spinner) findViewById(R.id.genderSpinner);

        mSubmitUserButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitUserButton) {
            Log.e("Clicked", "Reg button is clicked");

            final String name = nameEditText.getText().toString();
            final String nic = nicEditText.getText().toString();
            final String telephone = telephoneEditText.getText().toString();
            final String email = emailEditText.getText().toString();
            final String gender = genderSpinner.getSelectedItem().toString();

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
                    params.put("name",name);
                    params.put("nic",nic);
                    params.put("telephone",telephone);
                    params.put("email",email);
                    params.put("gender",gender);
                    return params;
                }
            };

            queue.add(stringRequest);

        }
    }
}
