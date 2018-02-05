/**
 * EditOrDeleteActivity
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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class is used to let the user choose to either edit or delete a subscription
 * the user must first have created a subscription to access this class.
 * once they do, then by clicking on the subscription in the list in the MainActivity, they can
 * open this one.
 *
 */
public class EditOrDeleteActivity extends AppCompatActivity {

    private Subscription sub;

    private TextView name;
    private TextView date;
    private TextView price;
    private TextView comment;

    /**
     * This is the main activty for this class. It takes one parameter of the bundle type.
     * It sets up all of the textviews that will be displayed as well as the buttons.
     * There are two buttons that the user can press, one to delete a subscription, and the other to edit it.
     * if they change the values in the textview, they can hit the edit button to update them.
     *
     * @param savedInstanceState the instance state
     *
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_or_delete);

        name = (TextView) findViewById(R.id.nameEdit);
        date = (TextView) findViewById(R.id.dateEdit);
        price = (TextView) findViewById(R.id.priceEdit);
        comment = (TextView) findViewById(R.id.commentEdit);

        Intent i = getIntent();
        sub = (Subscription)i.getSerializableExtra("editSub");
        name.setText(sub.getName());
        date.setText(sub.getDate());
        price.setText(sub.getPrice().toString());
        comment.setText(sub.getComment());

        Button subEdit = (Button) findViewById(R.id.subEdit);
        Button subDel = (Button) findViewById(R.id.subDel);


        /*
         * This method waits for a button click on "edit" button from the user, when the user clicks edit,
         * the method updates the subscription if they entered new information
         * The intent starts up the EditSubActivity, which is where the user can edit a subscription
         */
        subEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = name.getText().toString();
                String dateText = date.getText().toString();
                Double priceText = Double.parseDouble(price.getText().toString());
                String commentText = comment.getText().toString();

                for (int i = 0; i <SubArray.getInstance().getList().size(); i++){
                    if (sub.getName().equals(SubArray.getInstance().getList().get(i).getName()) &&
                            sub.getDate().equals(SubArray.getInstance().getList().get(i).getDate())){
                        SubArray.getInstance().getList().get(i).editName(nameText);
                        SubArray.getInstance().getList().get(i).editDate(dateText);
                        SubArray.getInstance().getList().get(i).editPrice(priceText);
                        SubArray.getInstance().getList().get(i).editComment(commentText);
                    }
                }
                finish();

            }
        });
        /*
         * This method waits for a button click on "delete" button from the user, when the user clicks delete,
         * the method finds the subscription in the list and deletes it.
         * It does this by looping through the list until it finds a subscription with a matching
         * date, name, and comment. This should be unique, it is unlikely that a user would have two
         * subscriptions with the same name, date, and comment.
         */
        subDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i <SubArray.getInstance().getList().size(); i++){
                    if (sub.getName().equals(SubArray.getInstance().getList().get(i).getName()) &&
                            sub.getDate().equals(SubArray.getInstance().getList().get(i).getDate())
                            && sub.getComment().equals(SubArray.getInstance().getList().get(i).getComment())){
                        SubArray.getInstance().getList().remove(i);
                    }
                }
                finish();

            }
        });


    }
}
