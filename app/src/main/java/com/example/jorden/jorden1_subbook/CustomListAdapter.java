/**
 * CustomListAdapter
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

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * This class is used to display the list of subscriptions in an easy to read format.
 * The main goal of this class is just to set a custom adapter so that it is easy to display the
 * subscription objects in the main activity.
 *
 * @see MainActivity
 *
 * Part of this code was adapted from:
 * https://appsandbiscuits.com/listview-tutorial-android-12-ccef4ead27cc
 * accessed on 2/4/2018
 */

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final SubArray  sub;

    /**
     * This is the constructor for this class. It takes two parameters, context and sub.
     * It sets them to the values that are passed into the constructor.
     *
     * @param context this is the context of the view
     * @param sub this is a subscription object
     * @see Subscription

     */
    public CustomListAdapter(Activity context, SubArray sub) {

        super(context, R.layout.sublist_view, sub.getList());

        this.context = context;
        this.sub = sub;
    }

    /**
     * This method is used to display the subscriptions properly in the list. It allows the user to
     * quickly see their list of subscriptions
     *
     * @param position where an object appears in the list.
     * @param view this is the view of where the list will be displayed
     * @param parent the parent of this view
     * @return returns the item from the list in an easy to read format
     * @see MainActivity
     */
    @Override
    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.sublist_view, null, true);

        TextView nameText = (TextView) rowView.findViewById(R.id.nameId);
        TextView infoText = (TextView) rowView.findViewById(R.id.infoId);

        nameText.setText(sub.getList().get(position).getName());
        infoText.setText(sub.getList().get(position).getDate() + "   "
                + SubArray.getInstance().getList().get(position).getPrice().toString());

        return rowView;
    }
}
