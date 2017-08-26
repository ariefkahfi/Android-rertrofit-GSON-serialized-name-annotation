package com.example.arief.androidretrofitcobagsonserializedname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.example.arief.androidretrofitcobagsonserializedname.retrofithandler.RetrofitCreator;

public class MainActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView)findViewById(R.id.listView);

        new RetrofitCreator()
            .loadDataByPeopleList();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu,menu);
        return true;
    }

}
