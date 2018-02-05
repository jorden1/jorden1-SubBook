/**
 * SubArray
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

import java.util.ArrayList;

/**
 * This class is a global class used to access the Subscription Array
 *
 * Part of this code was adapted from https://www.youtube.com/watch?v=1807u_OmW5A
 * accessed on 2/4/2018
 */
public class SubArray {

    private static SubArray instance;
    private ArrayList<Subscription> subs;
    /**
     * This is the constructor for this class, it takes no parameters and sets subs to be a new
     * arrayList with contains elements of the Subscription type
     *
     * @see Subscription
     */
    private SubArray(){
        this.subs = new ArrayList<>();
    }


    /**
     * this method allows a user to add a new subscription to the list.
     * It works by appending the new subscription to the list.
     * @param sub a new subscription to add to the arrayList
     */
    public void addSubscription(Subscription sub){

        this.subs.add(sub);
    }


    /**
     * This method returns the arrayList of the subscription elements.
     * @return returns the subscription list
     */
    public ArrayList<Subscription> getList(){
        return this.subs;
    }


    /**
     * This method is used to update the arrayList of subscriptions
     * it is used for loading in data from a previous session but that currently does not work
     *
     * @param subs the subscription list
     */
    public void setList(ArrayList<Subscription> subs){
        this.subs = subs;
    }


    /**
     * this method allows only one instance of the object to be created, meaning it is a global vaariable
     * @return the instance of SubArray
     */
    public static synchronized SubArray getInstance(){
        if (instance == null){
            instance = new SubArray();
        }
        return instance;
    }


}
