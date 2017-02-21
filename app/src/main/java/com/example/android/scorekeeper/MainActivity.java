package com.example.android.scorekeeper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

//    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MainTheme);
        setContentView(R.layout.activity_main);
    }

//    public void new_layer(View view){
//        Intent intent = new Intent(this, BasketballActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }

    public void Football(View View) {
        Intent intent = new Intent(this, FootballActivity.class);
        startActivity(intent);
    }

    public void American_Football(View View) {
        Intent intent = new Intent(this, AmericanFootballActivity.class);
        startActivity(intent);
    }

    public void Basketball(View View) {
        Intent intent = new Intent(this, BasketballActivity.class);
        startActivity(intent);
    }

    public void AM_txt_street(View View) {
        TextView addressview = (TextView) findViewById(R.id.AM_txt_address_value);
        String uri = String.format(Locale.ENGLISH, "geo:0,0?q=%s", addressview.getText());
        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void AM_txt_contact(View View) {
        //startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "(+49)15...", null)));
        TextView contactview = (TextView) findViewById(R.id.AM_txt_contact_value);
        String uri = String.format(Locale.ENGLISH, "tel:%s", contactview.getText());

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }



}
