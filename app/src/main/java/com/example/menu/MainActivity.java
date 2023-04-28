package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Registering for Context Menu
        registerForContextMenu((TextView)findViewById(R.id.t1));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.options_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
                break;
            case R.id.filter:
                Toast.makeText(this,"filter",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wishlist:
                Toast.makeText(this,"wishlist",Toast.LENGTH_SHORT).show();
                break;
            case R.id.MyCart:
                Toast.makeText(this,"MyCart",Toast.LENGTH_SHORT).show();
                break;
            case R.id.My_account:
                Toast.makeText(this,"My_account",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"Upload");
        menu.add(0,v.getId(),0,"Search");
        menu.add(0,v.getId(),0,"Copy");
        menu.add(0,v.getId(),0,"Paste");

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,"Selected Item: "+item.getTitle(),Toast.LENGTH_SHORT).show();
        return true;
    }

    public void pop(View v){
        PopupMenu popup = new PopupMenu(this,v);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_file,popup.getMenu());
        popup.show();

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.i1:
                Toast.makeText(this,"Clicked Main menu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this,"I am sub-menu 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                Toast.makeText(this,"I am sub-menu 2",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

