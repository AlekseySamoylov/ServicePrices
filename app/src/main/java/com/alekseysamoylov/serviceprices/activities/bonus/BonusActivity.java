package com.alekseysamoylov.serviceprices.activities.bonus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.util.CustomerInformation;

/**
 * Created by alekseysamoylov on 1/15/17.
 */

public class BonusActivity extends Activity {
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonuses);

        tx = (TextView) findViewById(R.id.bonuses);
        tx.setText(CustomerInformation.userBonuses.setScale(0).toString() + " bonuses");
    }
}
