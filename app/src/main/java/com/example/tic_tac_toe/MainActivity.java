package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;  //yellow=0;red=1;

    int gamestate[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int winingposition[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameative = true;

    public void dropit(View view) {
//        Log.i("msg","done");

        ImageView counter = (ImageView) view;

        int tappedcounter = Integer.parseInt(counter.getTag().toString());//index

        if (gamestate[tappedcounter] == 2 && gameative == true) {
            Log.i("msg","done2");

            gamestate[tappedcounter] = activePlayer;//updating red or yellow


            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.red);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] indisposition : winingposition) {
                if (gamestate[indisposition[0]] == gamestate[indisposition[1]] && gamestate[indisposition[1]] == gamestate[indisposition[2]] && gamestate[indisposition[0]] != 2) {
                    gameative = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "Red";

                    } else {
                        winner = "Yellow";
                    }

                    Button playagainbutton = (Button) findViewById(R.id.playagainbutton);
                    TextView winnertextview = (TextView) findViewById(R.id.winnertextview);

                    winnertextview.setText(winner + " has won!!");
                    playagainbutton.setVisibility(View.VISIBLE);
                    winnertextview.setVisibility(View.VISIBLE);


                }

            }

        }
    }

    public void playagain(View view) {
        Log.i("msg","done1");

         activePlayer=0;
        gameative = true;
        for (int i =0 ; i<gamestate.length;i++){

            gamestate[i]=2;

        }

        Button playagainbutton = (Button) findViewById(R.id.playagainbutton);
        TextView winnertextview = (TextView) findViewById(R.id.winnertextview);
        playagainbutton.setVisibility(View.INVISIBLE);
        winnertextview.setVisibility(View.INVISIBLE);

//        GridLayout gridlayout = (GridLayout) findViewById(R.id.gridlayout);
//
//        for (int i = 0; i < gridlayout.getChildCount(); i++) {
//            ImageView counter = (ImageView) gridlayout.getChildAt(i);
//            counter.setImageDrawable(null);
//        }

        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}