package astitva.expensesmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Manage extends AppCompatActivity {

    ImageButton imgbuttonGrocery,imgbtnVehicle,imgbtnshopping;

    ImageButton imgbtnElectricity,imgbtnmobile,imgbtnothers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        imgbuttonGrocery = (ImageButton)findViewById(R.id.btnGrocery);
        imgbuttonGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Manage.this , Grocery.class);

                startActivity(intent);
            }
        });

        imgbtnVehicle = (ImageButton) findViewById(R.id.btnVehicle);

        imgbtnVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Manage.this,Vehicle.class);
                startActivity(intent);
            }
        });

        imgbtnshopping = (ImageButton)findViewById(R.id.btnShopping);

        imgbtnshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manage.this,Shopping.class);
                startActivity(intent);
            }
        });

        imgbtnElectricity = (ImageButton)findViewById(R.id.btnElectricity);

        imgbtnElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manage.this , Electricity.class);

                startActivity(intent);
            }
        });

        imgbtnmobile = (ImageButton)findViewById(R.id.btnMobile);
        imgbtnmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Manage.this , Mobile.class);
                startActivity(intent);
            }
        });

        imgbtnothers = (ImageButton)findViewById(R.id.btnOthers);

        imgbtnothers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Manage.this , Others.class);
                startActivity(intent);
            }
        });

    }

}
