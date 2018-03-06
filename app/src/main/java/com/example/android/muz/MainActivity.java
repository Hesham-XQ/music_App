package com.example.android.muz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fayrouz = (TextView) findViewById(R.id.fayrouz_text);
        TextView adele = (TextView) findViewById(R.id.adele_text);
        TextView relax = (TextView) findViewById(R.id.relax_text);

        fayrouz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent fayrouzIntent = new Intent(MainActivity.this, activity_fayrouz.class);

                // Start the new activity
                startActivity(fayrouzIntent);
            }
        });

        adele.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent adeleIntent = new Intent(MainActivity.this, adele.class);

                startActivity(adeleIntent);
            }
        });

        relax.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent relaxIntent = new Intent(MainActivity.this, relax.class);

                // Start the new activity
                startActivity(relaxIntent);
            }
        });



    }
}
