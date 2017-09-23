package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(getApplicationContext(),
                    "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(getApplicationContext(),
                    "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox checkBoxWhippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox checkBoxChocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText editText = (EditText) findViewById(R.id.name_field);

        boolean hasWhippedCream = checkBoxWhippedCream.isChecked();
        boolean hasChocolate = checkBoxChocolate.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String name = editText.getText().toString();
        String message = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        composeEmail(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
   /* private void displayMessage(String line) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(line);

    }*/
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = 5;
        if (hasWhippedCream)
            price += 1;
        if (hasChocolate)
            price += 2;
        return price * quantity;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String message = getString(R.string.name_order, name)  +
                "\n" + getString(R.string.add_cream, hasWhippedCream) +
                "\n" + getString(R.string.add_chocolate, hasChocolate) +
                "\n" + getString(R.string.quantity_all, quantity)  +
                "\n" + getString(R.string.total, NumberFormat.getCurrencyInstance().format(price))  +
                "\n" + getString(R.string.thank_you);
        return message;
    }

    public void composeEmail(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.just_order));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
