package com.example.a08_listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class results_activity extends AppCompatActivity {
    Button returni;
    Intent gi;
    TextView player1,player2,winner;
    int s;
    int l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_activity);
        gi = getIntent();
        l = gi.getIntExtra("long",0);
        s = gi.getIntExtra("short",0);

        returni = (Button)findViewById(R.id.returni);
        player1 = (TextView)findViewById(R.id.player1);
        player2 = (TextView)findViewById(R.id.player2);
        winner = (TextView)findViewById(R.id.winner);
        player1.setText("player 1:" + s + "points");
        player2.setText("player 2:" + l + "points");
        if(l<s) winner.setText("player 1 is the winner!");
        else if(l>s) winner.setText("player 2 is the winner!");
        else winner.setText("DRAW!");



    }

    public void returnBack(View view) {
        player2.setText("");
        player1.setText("");
        winner.setText("");
        l=0;
        s=0;
        Intent wi = getIntent();
        wi.putExtra("longi",l);
        wi.putExtra("shorti", s);

        setResult(RESULT_OK,wi);
        finish();

    }
}