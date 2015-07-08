package com.example.codetribe1.tribe;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import dto.MembersDTO;
import dto.RequestDTO;
import dto.util.Statics;


public class RegisterActivity extends Activity{
    Context ctx;
    Activity activity;
    EditText name, nick, email, cell, surname, passwrd,pf, ambi;
    Button REGISTER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ctx = getApplicationContext();
        REGISTER = (Button) findViewById(R.id.btnreg);
        name = (EditText) findViewById(R.id.txtname);
        nick = (EditText) findViewById(R.id.txtnick);
        email = (EditText) findViewById(R.id.txtemail);
        cell = (EditText) findViewById(R.id.txtcell);
        surname = (EditText) findViewById(R.id.txtsurname);
        passwrd = (EditText) findViewById(R.id.txtpassword);
        ambi = (EditText) findViewById(R.id.txtambtion);
        pf = (EditText) findViewById(R.id.txtpf);
        REGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }
    private void register() {
        MembersDTO members = new MembersDTO();
        members.setName(name.getText().toString());
        members.setSurname(surname.getText().toString());
        members.setEmail(email.getText().toString());
        members.setPassword(passwrd.getText().toString());
        members.setProfession(pf.getText().toString());
        members.setNickname(nick.getText().toString());
        members.setAmbition(ambi.getText().toString());
        members.setCellphone(cell.getText().toString());
                // String username = name.getText().to;String();
                // String pass = passwrd.getText().toString();
        String nicky = nick.getText().toString();
        String emaily = email.getText().toString();
        String celly = cell.getText().toString();
        String amby = ambi.getText().toString();
        String sname = surname.getText().toString();
        String prof=pf.getText().toString();
        String pwd=passwrd.getText().toString();
        String username = name.getText().toString();
        RequestDTO dto = new RequestDTO();
        dto.setRequestType(RequestDTO.REGISTERMB);
        dto.setMembers(members);
        String urlData = Statics.URL + Statics.SERVLET_ENDPOINT + new Gson().toJson(dto);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, urlData, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("ERROR", volleyError.getMessage());

            }
        });
        queue.add(request);
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
}
