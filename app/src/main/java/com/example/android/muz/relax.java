package com.example.android.muz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SAMO on 3/5/2018.
 */

public class relax extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        final ArrayList<music> musics = new ArrayList<>();
        musics.add(new music("Play", "Other", R.raw.play , R.drawable.music));
        musics.add(new music("Deep relaxation", "Other", R.raw.deep_relaxation , R.drawable.music));
        musics.add(new music("Classic", "Other", R.raw.classic, R.drawable.music));

        musicAdapter adapter = new musicAdapter(this, musics ,R.color.relax_cat);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


    }
}
