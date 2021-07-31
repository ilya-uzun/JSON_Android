package com.uzun.json_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList< String > name = new ArrayList<>();
    ArrayList< String > username = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //Полчаем JSON file
        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset("users.json"));
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i=0;i< jsonArray.length();i++){
                JSONObject userData=jsonArray.getJSONObject(i);
                name.add(userData.getString("name"));
                username.add(userData.getString("username"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HelperAdapter helperAdapter = new HelperAdapter(name,username,MainActivity.this);
        recyclerView.setAdapter(helperAdapter);
    }
    // возвращаем данные из json
    private String JsonDataFromAsset(String fileName) { // передаем имя JSON файла
        String json = null;
        try {
            InputStream inputStream = getAssets().open(fileName);
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}