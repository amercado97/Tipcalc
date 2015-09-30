package cs2302.amercado.tipcalculator;

import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		calcClickListener btn = new calcClickListener();
		Button calcBTN = (Button) findViewById(R.id.calcBTN);
		calcBTN.setOnClickListener(btn);
	}

	private class calcClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			EditText foodET = (EditText) findViewById(R.id.foodET);
			Editable foodEdbl = foodET.getText();
			String foodStr = foodEdbl.toString();
			double food = Double.parseDouble(foodStr);
			EditText taxET = (EditText) findViewById(R.id.taxET);
			Editable taxEdbl = taxET.getText();
			String taxStr = taxEdbl.toString();
			double tax = Double.parseDouble(taxStr);
			RadioGroup tipRG = (RadioGroup) findViewById(R.id.tipPercentageRG);
			int checkedID = tipRG.getCheckedRadioButtonId();
			double tip;
			if(checkedID == R.id.tip0RB){
				tip = .1;
			}
			else if(checkedID == R.id.tip1RB){
				tip = .15;
			}
			else if (checkedID == R.id.tip2RB){
				tip = .2;
			}
			else{
				tip = -123.45;
			}
			double fintip = food * tip;
			double total = food + tax + fintip;
			NumberFormat tipfmt = NumberFormat.getCurrencyInstance();//locale aware
			String formattedPayment = tipfmt.format(fintip);
			EditText tipET = (EditText) findViewById(R.id.tipET);
			tipET.setText(formattedPayment + "");
			NumberFormat totfmt = NumberFormat.getCurrencyInstance();//locale aware
			String formattedPayment2 = totfmt.format(total);
			EditText totalET = (EditText) findViewById(R.id.totalET);
			totalET.setText(formattedPayment2 + "");
		}
	
}
}
