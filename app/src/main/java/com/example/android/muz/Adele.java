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

public class Adele extends AppCompatActivity {
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
                Intent fayrouzIntent = new Intent(Adele.this, Fayrouz.class);

                startActivity(fayrouzIntent);
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent relaxIntent = new Intent(Adele.this, Relax.class);

                startActivity(relaxIntent);
            }
        });

        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Hello", "Adele", R.raw.hello, R.drawable.adele));
        musics.add(new Music("Set fire to the rain", "Adele", R.raw.set_fire_to_the_rain, R.drawable.adele));
        musics.add(new Music("Rolling in the deeb", "Adele", R.raw.rolling, R.drawable.adele));

        MusicAdapter adapter = new MusicAdapter(this, musics, R.color.adele_cat);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
