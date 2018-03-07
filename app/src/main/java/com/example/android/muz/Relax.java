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

public class Relax extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        Button activity1 = (Button) findViewById(R.id.button1);
        Button activity2 = (Button) findViewById(R.id.button2);

        activity1.setText(R.string.fayrouz);
        activity2.setText(R.string.adele);

        activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fayrouzIntent = new Intent(Relax.this, Fayrouz.class);

                startActivity(fayrouzIntent);
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adeleIntent = new Intent(Relax.this, Adele.class);

                startActivity(adeleIntent);
            }
        });

        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Play", "Other", R.raw.play, R.drawable.music));
        musics.add(new Music("Deep relaxation", "Other", R.raw.deep_relaxation, R.drawable.music));
        musics.add(new Music("Classic", "Other", R.raw.classic, R.drawable.music));

        MusicAdapter adapter = new MusicAdapter(this, musics, R.color.relax_cat);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


    }
}
