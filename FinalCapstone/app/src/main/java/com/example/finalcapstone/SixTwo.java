package com.example.finalcapstone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class SixTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_two);
    }

    int quantity = 0;

    /**
     * This method is called when the Increment/Plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    /**
     * This method is called when the Decrement/Minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity>0) {
            quantity--;
            display(quantity);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Figure out if user wants whipped cream
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity","Has whipped cream: " + hasWhippedCream);

        // Figure out if user wants chocolate
        CheckBox chocolate = findViewById(R.id.chocolate);
        boolean hasChocolate = chocolate.isChecked();
        Log.v("MainActivity","Has chocolate: " + hasChocolate);

        CheckBox strawCheckBox = findViewById(R.id.straw);
        boolean hasStraw = strawCheckBox.isChecked();
        Log.v("MainActivity","Added napkins: " + hasStraw);

        CheckBox napkinsCheckBox = findViewById(R.id.napkins);
        boolean hasNapkins = napkinsCheckBox.isChecked();
        Log.v("MainActivity","Added napkins: " + hasNapkins);

        // Get text from EditText to Html
        EditText nameField = findViewById(R.id.user_input_name_view);
        String name = nameField.getText().toString();
        Log.v("MainActivity","Name: "+ name);

        int price = calculatePrice(hasWhippedCream,hasChocolate,hasStraw,hasNapkins);
        String priceMessage =  createOrderSummary(price, hasWhippedCream, hasChocolate, name, hasNapkins, hasStraw);

        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto: \"calenzinger@icloud.com\"?subject="+ Uri.encode("Just Java order for "+ name) + "&body=" + Uri.encode(priceMessage))); // only email apps should handle this
        if (email.resolveActivity(getPackageManager()) != null) {
            startActivity(email);

        }

        displayMessage(priceMessage);

    }


    /**
     * Calculates the price of the order
     *
     * @param hasWhippedCream is whether or not the user wants whipped cream
     * @param hasChocolate is whether or not the user wants chocolate
     * @return total price
     */

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate, boolean hasStraw, boolean hasNapkins){
        int basePrice = 3;

        if (hasStraw) {
            basePrice = basePrice + 0;
        }
        if (hasNapkins) {
            basePrice = basePrice + 0;
        }

        //adds 1$ if they want whipped cream
        if (hasWhippedCream) {
            basePrice = basePrice + 1;
        }
        //adds 2$ if they want chocolate
        if (hasChocolate){
            basePrice = basePrice + 1;
        }
        //calculate the total order price by multiplying the quantity
        return quantity * basePrice;
    }


    /**
     * Create a summary of our order
     * @param name     of the customer
     * @param price    the total price
     * @param addWhippedCream is whether or not the user wants Whipped Cream Topping
     * @param chocolate chocolate
     * @return returns
     */

    private String createOrderSummary(int price, boolean addWhippedCream, boolean chocolate, String name, boolean hasStraw, boolean hasNapkins) {
        String priceMessage = "Name: "+ name;
        priceMessage += "\nThank you for ordering " + quantity + " Lemonades!";
        priceMessage += "\nAdd Lemon? " + addWhippedCream;
        priceMessage += "\nAdd Ice? " + chocolate;//I used the escape key \n to put info on a new line
        priceMessage += "\nAdd a Straw? " + hasStraw;
        priceMessage += "\nAdd Napkins? " + hasNapkins;
        priceMessage += "\nAmount Due: $" + price; //I used the escape key \n to put info on a new line
        priceMessage += "\n\nYour order will be right up!"; //Double \n escape key for w line separation
        return priceMessage;

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }
}