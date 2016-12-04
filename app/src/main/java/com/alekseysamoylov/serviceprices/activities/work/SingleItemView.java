package com.alekseysamoylov.serviceprices.activities.work;

/**
 * Created by AlekseiSamoilov on 08/05/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alekseysamoylov.serviceprices.R;

public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtPrice;
    TextView txtTitle;
    TextView txtDetails;
    String price;
    String title;
    String details;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        // Get the results of title
        title = i.getStringExtra("title");
        // Get the results of details
        details = i.getStringExtra("details");
        // Get the results of price
        price = i.getStringExtra("price");

        // Locate the TextViews in singleitemview.xml
        txtPrice = (TextView) findViewById(R.id.workPrice);
        txtTitle = (TextView) findViewById(R.id.workTitle);
        txtDetails = (TextView) findViewById(R.id.workDetails);

        // Load the results into the TextViews
        txtPrice.setText(price);
        txtTitle.setText(title);
        txtDetails.setText(details);
    }
}