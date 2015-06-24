package com.myname.task2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Comparator;


public class MainActivity extends Activity {

    String[] data={"pavithran","bavani","fathima","sathish","bhargav","anusha","praveen"};
    ListView l;
    Button sort,search;
    EditText name;
    int flag=0,flag2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.listView);
       final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.textView, data);
        l.setAdapter(adapter);




        sort = (Button) findViewById(R.id.sort);
        search = (Button) findViewById(R.id.search);
        name=(EditText)findViewById(R.id.name);


        sort.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (flag2 == 0) {
                    flag2 = 1;
                    adapter.sort(new Comparator<String>() {

                        @Override
                        public int compare(String arg1, String arg0) {
                            return arg1.compareTo(arg0);
                        }
                    });
                }
                else if (flag2 == 1) {
                    flag2 = 0;
                    adapter.sort(new Comparator<String>() {
                        @Override
                        public int compare(String arg1, String arg0) {
                            return -arg1.compareTo(arg0);
                        }
                    });
                   flag2=0;
                }
            }
        });





        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String t = name.getText().toString();
              //  name.setText(t);
                for (int i = 0; i < 7; i++) {
                    if (t.equals(data[i]))
                    {   String k = "Contact Found: "+ data[i];
                        Toast.makeText(getApplicationContext(), k ,
                                Toast.LENGTH_SHORT).show();
                        flag = 1;
                    }

                    else {
                    }

                }

                if (flag == 0)
                    Toast.makeText(getApplicationContext(), "Missing",
                            Toast.LENGTH_SHORT).show();

                flag=0;
            }





        });

        }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


           }
