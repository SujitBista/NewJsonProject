package com.example.newjsonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);

        JSON_STRING=getIntent().getExtras().getString("json_data");
        Toast.makeText(this,JSON_STRING,Toast.LENGTH_SHORT).show();
        String name,password,contact,mcountry;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            jsonArray = jsonObject.getJSONArray("server_response");
            Toast.makeText(this,jsonArray.toString(),Toast.LENGTH_SHORT).show();
            int count = 0;
            while(count<jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                name = JO.getString("name");
                password= JO.getString("password");
                contact = JO.getString("contact");
                mcountry=JO.getString("country");
                Toast.makeText(this,mcountry,Toast.LENGTH_SHORT).show();
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
