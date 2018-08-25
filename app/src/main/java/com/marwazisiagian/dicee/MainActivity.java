package com.marwazisiagian.dicee;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mIndexLeftImage = 5;
    private int mIndexRightImage = 5;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {

            // load from the InstanceState
            mIndexLeftImage = savedInstanceState.getInt("index_leftImage");
            mIndexRightImage= savedInstanceState.getInt("index_rightImage");
        }

        Button rollButton = (Button) findViewById(R.id.rollbutton);

        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_RightDice);


        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        // change the image according to the new index
        leftDice.setImageResource(diceArray[mIndexLeftImage]);
        rightDice.setImageResource(diceArray[mIndexRightImage]);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randomNumberGenerator = new Random();

                //generate the random number for the new index
                mIndexLeftImage = randomNumberGenerator.nextInt(6);
                mIndexRightImage = randomNumberGenerator.nextInt(6);


                // change the image according to the new index
                leftDice.setImageResource(diceArray[mIndexLeftImage]);
                rightDice.setImageResource(diceArray[mIndexRightImage]);

            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("index_leftImage",mIndexLeftImage);
        outState.putInt("index_rightImage", mIndexRightImage);
    }
}
