package com.example.android.muz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

        Button activity1 = (Button) findViewById(R.id.button1);
        Button activity2 = (Button) findViewById(R.id.button2);

        activity1.setText(R.string.fayrouz);
        activity2.setText(R.string.relax);

        activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fayrouzIntent = new Intent(adele.this, activity_fayrouz.class);

                startActivity(fayrouzIntent);
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent relaxIntent = new Intent(adele.this, relax.class);

                startActivity(relaxIntent);
            }
        });

        final ArrayList<music> musics = new ArrayList<>();
        musics.add(new music("Hello", "Adele", R.raw.hello, R.drawable.adele));
        musics.add(new music("Set fire to the rain", "Adele", R.raw.set_fire_to_the_rain, R.drawable.adele));
        musics.add(new music("Rolling in the deeb", "Adele", R.raw.rolling, R.drawable.adele));

        musicAdapter adapter = new musicAdapter(this, musics, R.color.adele_cat);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
