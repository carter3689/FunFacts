package com.joelcarter.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FunFactsActivity extends Activity {

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare our view variables and assign the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.funFactText);
        final Button showFactButton = (Button) findViewById(R.id.nextFunFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String fact = mFactBook.getFact();
                        //Update the label with our dynamic fact
                factLabel.setText(fact);

                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);


            }
        };
        showFactButton.setOnClickListener(listener);

        Toast.makeText(this,"Yay! Our Activity was created!", Toast.LENGTH_LONG);


    }

}
