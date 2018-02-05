/**
 * Subscription
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

import java.io.Serializable;


/**
 * This class is used to create a subscription object that can store the users information for that
 * subscription, specifically it can store a: name, date, price, and comment.
 *
 * Part of this code was adapted from:
 * https://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android
 * accessed on 2/3/2018
 */
public class Subscription implements Serializable {

    private String name;
    private String date_started;
    private Double price;
    private String comment;


    /**
     * This is one version of the constructor for this class. It requires that the user give it a name,
     * a date, and a price. It does not require a comment
     * @param name name of the subscription
     * @param date_started date subscription was started
     * @param price price of the subscription per month
     */
    public Subscription(String name, String date_started, Double price){
        this.name = name;
        this.date_started = date_started;
        this.price = price;
    }

    /**
     * this is similar to the previous constructor however this one is used if a comment is input by
     * the user
     * @param name name of the subscription
     * @param date_started date subscription was started
     * @param price price of the subscription per month
     * @param comment comment about the subscription
     */
    public Subscription(String name, String date_started, Double price, String comment){
        this.name = name;
        this.date_started = date_started;
        this.price = price;
        this.comment = comment;
    }


    /**
     * this method allows the user to edit the name of a subscription. It requires that the user give
     * it a new name for it
     * @param name the new name for a subscription
     */
    public void editName(String name){
        this.name = name;
    }

    /**
     * This method allows the user to edit the date a subscription was started. It requires the user
     * give it a new date
     * @param date new date for subscription
     */
    public void editDate(String date){
        this.date_started = date;
    }


    /**
     * This allows the user to edit the price of a subscription. it requires the user to give it
     * a new price
     * @param price new price of subscription
     */
    public void editPrice(double price){
        this.price = price;
    }


    /**
     * this allows the user to update the comment of a subscription. It can be removed by providing
     * an empty string
     * @param comment new comment for subscription
     */
    public void editComment(String comment){
        this.comment = comment;
    }


    /**
     * gets the name for a subscription
     * @return the name of a subscription
     */
    public String getName(){
        return this.name;
    }


    /**
     * gets the date of a subscription
     * @return the date of a subscription
     */
    public String getDate(){
        return this.date_started;
    }


    /**
     * get the price of a subscription
     * @return the price of a subscription
     */
    public Double getPrice(){
        return this.price;
    }

    /**
     * gets the comment of the subscriptiom
     * @return the comment of the subscription
     */
    public String getComment(){
        return this.comment;
    }



}
