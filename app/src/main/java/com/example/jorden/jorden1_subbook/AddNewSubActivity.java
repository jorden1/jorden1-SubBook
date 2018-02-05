/**
 * AddNewSubActivity
 *
 * Version: 1.0
 *
 * Date: 2/5/2018
 *
 Copyright <2018> <Jorden Hansen>
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without
 limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions
 The above copyright notice and this permission notice shall be included in all copies or substantial
 portions of the Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.example.jorden.jorden1_subbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class is used allow the user to add a new subscription to their list. It lets them input
 * the information they want to have, name, date, and price are all required but they can also enter a comment
 *
 * It takes no paramters in creating it, and is a child-class of AppCompatActivity
 */
public class AddNewSubActivity extends AppCompatActivity {

    //define the layout textviews
    private TextView name;
    private TextView date;
    private TextView price;
    private TextView comment;

    /**
     * This is the main activty for adding a new subscription to the users list.
     * It also allows for the input of values for this new subscription
     *
     * It lets the user enter the values they want for the subscription and then saves it into the
     * SubArray where it can be gotten later. This class is access from the MainActivity class
     *
     * @param savedInstanceState is the instance state
     * @see SubArray
     * @see Subscription
     * @see MainActivity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_sub);

        //define the layout button and set TextView values
        Button sub_add = (Button)findViewById(R.id.sub_add);

        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.date);
        price = (TextView) findViewById(R.id.price);
        comment = (TextView) findViewById(R.id.comment);

        //sets a listener for when the button is clicked
        sub_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = name.getText().toString();
                String dateText = date.getText().toString();
                Double priceText = Double.parseDouble(price.getText().toString());
                String commentText = comment.getText().toString();

                if (comment.equals("")) {
                    //if the user doesnt enter a comment it calls a cosntructor without that option
                    Subscription new_subscription = new Subscription(nameText, dateText, priceText);
                    SubArray.getInstance().addSubscription(new_subscription);

                }else {
                    //if the user enters a comment it calls the constructor with that option
                    Subscription new_subscription = new Subscription(nameText, dateText, priceText, commentText);
                    SubArray.getInstance().addSubscription(new_subscription);
                }

                //returns to previous activity
                finish();

            }
        });
    }
}
