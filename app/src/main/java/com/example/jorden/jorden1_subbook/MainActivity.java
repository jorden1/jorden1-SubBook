/**
 * Main Activity
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
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * this is the main activity for this app, it is the starting screen. Here the user can see the list
 * of all of their subscriptions as well as click on them to edit or delete them. It also shows the
 * monthly total that the user spends on all fo their subscriptions
 */
public class MainActivity extends AppCompatActivity {

    private  CustomListAdapter adapt;

    /**
     * this is the main activity method for this class. It first makes a custom adapter to be used to
     * print the list of subscriptions properly. it also has the button to add a new subscription and
     * allows the user to click on an existing subscription to edit or delete it.
     *
     * @param savedInstanceState the state of the activity
     *
     * @see AddNewSubActivity
     * @see EditOrDeleteActivity
     * @see SubArray
     * @see Subscription
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the adapter and setting it up
        adapt = new CustomListAdapter(this, SubArray.getInstance());
        ListView list = (ListView) findViewById(R.id.subList);
        list.setAdapter(adapt);

        //loading data in, does not currently work
        loadData();
        Button add = (Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            /**
             * This is the method clalled when the user clicks the add button, it calls the
             * AddNewSubActivty when press
             * @param view the current view
             *
             * @see AddNewSubActivity
             */
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNewSubActivity.class));

            }

        });

        //if the user clicks on an item in the list, it calls the EditOrDelete activity
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * This method is called when the user clicks on an item in a list, it will then call
             * the EditorDelete activity.
             * @param adapterView the adapterView
             * @param view the view of the current screen
             * @param i the position of the item in the list
             * @param l
             *
             * @see EditOrDeleteActivity
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent2 = new Intent(new Intent(MainActivity.this,
                        EditOrDeleteActivity.class));
                Subscription editSub = SubArray.getInstance().getList().get(i);
                intent2.putExtra("editSub", editSub);
                startActivity(intent2);
            }
        });
    }

    /**
     * This method is called when returning to this activty. It's main purpose it to reupdate the
     * total cost per month and to update the adpater if something was added or changed.
     *
     * part of this code was adapted from https://developer.android.com/guide/components/activities/activity-lifecycle.html
     * accessed on 2/4/2018
     */
    public void onResume(){
        super.onResume();
        double total = 0;
        for (int i = 0; i <SubArray.getInstance().getList().size(); i++){
            total = total + SubArray.getInstance().getList().get(i).getPrice();
        }
        TextView totalCost = (TextView)findViewById(R.id.totalCost);
        totalCost.setText(Double.toString(total));
        adapt.notifyDataSetChanged();
        saveData();

    }

    /**
     * This is the method used to save data once the application is closed, it does not currently work
     *
     * Part of this code was adapted from https://www.youtube.com/watch?v=jcliHGR3CHo
     * accessed on 2/4/2018
     */
    private void saveData(){
        SharedPreferences sharedPrefrences = getSharedPreferences("shared pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefrences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(SubArray.getInstance().getList());
        editor.putString("array List", json);
        editor.apply();

    }

    /**
     * This is the method used to load data once the application is reopened, it does not currently work
     *
     * Part of this code was adapted from https://www.youtube.com/watch?v=jcliHGR3CHo
     * accessed on 2/4/2018
     */
    private void loadData(){
        SharedPreferences sharedPrefrences = getSharedPreferences("shared pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPrefrences.getString("array list", null);
        Type type = new TypeToken<ArrayList<Subscription>>(){}.getType();
        ArrayList<Subscription> item = gson.fromJson(json, type);

        if(item != null){
            SubArray.getInstance().setList(item);
        }

    }



}
