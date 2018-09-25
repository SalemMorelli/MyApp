package com.example.salem.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);


        //Set Event
       setSingleEvent(mainGrid);
       // setToggleEvent(mainGrid);
    }

    /**
     * A toggle event will change the colour of the card
     **/
  /*  private void setToggleEvent(GridLayout mainGrid) {

        //loop all child items of main grid
        for (int i = 0; i < mainGrid.getChildCount(); i++)
        {
        final CardView cardView = (CardView) mainGrid.getChildAt(i);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                    //change background colour
                  //  cardView.getCardBackgroundColor(Color.parseColor("#FF6F00"));
                    Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();
                } else {
                    //Change background color
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                }


            }
        });
    } */

    /**
     * A single event will start a new activity when the card is clicked
     **/
    private void setSingleEvent(GridLayout mainGrid) {
        //loop all child items of main grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //you can see, all child items is cardview, so we just cast object to cardview
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Here you can replace Toast with start new activity code
                    Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                    startActivity(intent);
                 //   Toast.makeText(MainActivity.this, "Clicked at index" + finalI, Toast.LENGTH_SHORT).show(); */

                }

            });
        }

        /** Called when the user taps the Send button

        public void sendMessage (View view){
            Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);  */
      //      startActivity(intent);
     //   }

   // }
}}
