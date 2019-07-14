package com.example.intentresult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class sharedata extends AppCompatActivity {
Button button;
ListView listview;
    String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedata);
        button=findViewById(R.id.button1);
        listview=findViewById(R.id.listView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareintent=new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                shareintent.putExtra(Intent.EXTRA_SUBJECT,"Vikrant is Here");
                String url="https://www.javatpoint.com/android-share-app-data";
                shareintent.putExtra(Intent.EXTRA_TEXT,url);
                startActivity(Intent.createChooser(shareintent,"Share data"));

            }
        });
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,contacts);
        listview.setAdapter(adapter);
      registerForContextMenu(listview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        menu.setHeaderTitle("Select any thing");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id1=item.getItemId();
        switch (id1)
        {
            case R.id.call:
                Toast.makeText(getApplicationContext(),"calling code", Toast.LENGTH_LONG).show();
                break;
            case R.id.another:
                Toast.makeText(getApplicationContext(),"sms", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
