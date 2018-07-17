package astitva.expensesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpensesManager extends AppCompatActivity {


  Button btnmanage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_manager);


        btnmanage = (Button)findViewById(R.id.btnManage);

        btnmanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ExpensesManager.this,Manage.class);
                startActivity(intent);

            }
        });

    }
}
