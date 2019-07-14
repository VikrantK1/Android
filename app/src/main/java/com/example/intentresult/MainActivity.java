package com.example.intentresult;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
Button button,button4;
EditText editText2=null;
Button button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        button4=findViewById(R.id.button4);
        button8=findViewById(R.id.button8);
        button=findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(MainActivity.this,result.class);
             startActivityForResult(intent,2);
         }
     });
       button4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               PopupMenu popupMenu=new PopupMenu(MainActivity.this,button4);
               popupMenu.getMenuInflater().inflate(R.menu.menu2,popupMenu.getMenu());
               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem menuItem) {
                       int id1=menuItem.getItemId();
                       switch (id1)
                       {
                           case R.id.call:
                               Toast.makeText(getApplicationContext(),"call",Toast.LENGTH_LONG).show();
                               break;
                           case R.id.another:
                               Toast.makeText(getApplicationContext(),"Contact",Toast.LENGTH_LONG).show();
                       }
                       return true;
                   }
               });
               popupMenu.show();
           }
       });
       button8.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Alarm();
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2)
        {
            String  message=data.getStringExtra("MESSAGE");
            textView.setText("Message"+message);
        }
    }
    public void sharedata(View v)
    {
        Intent intent=new Intent(MainActivity.this,sharedata.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.item1:
                Toast.makeText(MainActivity.this,"Item1",Toast.LENGTH_LONG).show();
            case R.id.item2:
                Toast.makeText(MainActivity.this,"Item2",Toast.LENGTH_LONG).show();
            case R.id.item3:
                Toast.makeText(MainActivity.this,"Item3",Toast.LENGTH_LONG).show();
            case R.id.item4:
                Toast.makeText(MainActivity.this,"Item4",Toast.LENGTH_LONG).show();
            case R.id.item5:
                Toast.makeText(MainActivity.this,"Item5",Toast.LENGTH_LONG).show();
            case R.id.item6:
                Toast.makeText(MainActivity.this,"Item6",Toast.LENGTH_LONG).show();
        }


        return super.onOptionsItemSelected(item);
    }
    public void startService(View v)
    {

        startService(new Intent(MainActivity.this,service.class));
    }
    public void stopService(View v)
    {

     stopService(new Intent(MainActivity.this,service.class));
    }
    public void Alarm()
    {
        editText2=findViewById(R.id.editText2);
        String data=editText2.getText().toString();
        int i=0;

                i=Integer.parseInt(data);



        Intent intent=new Intent(this,MyBroadCastReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 234324243,intent,0);
        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(getApplicationContext(),"Alarm at="+i,Toast.LENGTH_SHORT).show();
    }

}
