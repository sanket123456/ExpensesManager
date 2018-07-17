package astitva.expensesmanager;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Grocery extends Activity {

    String str1, str2;
    EditText ettype,etbill;

    Button btnsubmit,btnshow;

    DBGrocery myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

                ettype  = (EditText)findViewById(R.id.ettype);

                etbill  = (EditText)findViewById(R.id.etAmount);

                myDB=new DBGrocery(this);

                btnsubmit  = (Button) findViewById(R.id.btnSubmit);

                btnshow  = (Button)findViewById(R.id.btnShow);

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
                        String currentDate = sdf.format(new Date());


                        if(!TextUtils.isEmpty(ettype.getText().toString())) {
                            myDB.open();

                            long result = myDB.insertRow(ettype.getText().toString(), etbill.getText().toString(), currentDate);

                            myDB.close();

                        }

                    }
                });


                btnshow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        populateListView();
                    }
                });

    }

    private void populateListView(){

        Cursor cursor = myDB.getall();

        String[] fromfieldName = new String[]{DBGrocery.KEY_ROWID,DBGrocery.KEY_DATE,DBGrocery.KEY_TYPE,DBGrocery.KEY_TASK};

        int[] toViewIDs = new int[]{ R.id.rowno,R.id.date,R.id.type,R.id.amount};

        SimpleCursorAdapter simpleCursorAdapter;

        simpleCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.item_layout,cursor,fromfieldName
                ,toViewIDs,0);

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(simpleCursorAdapter);
    }


}
