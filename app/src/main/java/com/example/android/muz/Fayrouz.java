package com.example.android.muz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SAMO on 3/1/2018.
 */

public class Fayrouz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        Button activity1 = (Button) findViewById(R.id.button1);
        Button activity2 = (Button) findViewById(R.id.button2);

        activity1.setText(R.string.adele);
        activity2.setText(R.string.relax);

        activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adeleIntent = new Intent(Fayrouz.this, Adele.class);

                startActivity(adeleIntent);
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent relaxIntent = new Intent(Fayrouz.this, Relax.class);

                // Start the new activity
                startActivity(relaxIntent);
            }
        });

        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("shady", "fayrouz", R.raw.shady, R.drawable.fairouz));
        musics.add(new Music("alamony", "fayrouz", R.raw.alamony, R.drawable.fairouz));
        musics.add(new Music("habitaak bl saief", "fayrouz", R.raw.habitak_bl_saif, R.drawable.fairouz));
        musics.add(new Music("e7na w el qamar jeraan", "fayrouz", R.raw.e7na_w_el_qamar_jeran, R.drawable.fairouz));
        musics.add(new Music("Kan el zaman", "fayrouz", R.raw.kan, R.drawable.fairouz));
        musics.add(new Music("Khayef", "fayrouz", R.raw.khayef, R.drawable.fairouz));
        musics.add(new Music("Baatoflak", "fayrouz", R.raw.baatoflak, R.drawable.fairouz));
        musics.add(new Music("Sahar el lialy", "fayrouz", R.raw.sahr_ellialy, R.drawable.fairouz));
        musics.add(new Music("Ya ana", "fayrouz", R.raw.ya_ana, R.drawable.fairouz));

        MusicAdapter adapter = new MusicAdapter(this, musics, R.color.fairouz_cat);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
