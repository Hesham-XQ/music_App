package com.example.android.muz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SAMO on 3/5/2018.
 */

public class adele extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        final ArrayList<music> musics = new ArrayList<>();
        musics.add(new music("Hello", "Adele", R.raw.hello , R.drawable.adele));
        musics.add(new music("Set fire to the rain", "Adele", R.raw.set_fire_to_the_rain, R.drawable.adele));
        musics.add(new music("Rolling in the deeb", "Adele", R.raw.rolling, R.drawable.adele));





        musicAdapter adapter = new musicAdapter(this, musics , R.color.adele_cat);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
