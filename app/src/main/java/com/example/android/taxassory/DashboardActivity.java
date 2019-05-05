package com.example.android.taxassory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

    }

    public void showPopup(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_doc);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.opt1:
                Intent resetIntent = new Intent(DashboardActivity.this, UploadActivity.class);
                startActivity(resetIntent);

            case R.id.opt2:
                Toast.makeText(this, "Option 2 is clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opt3:
                Toast.makeText(this, "Option 3 is clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opt4:
                Toast.makeText(this, "Option 3 is clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opt5:
                Toast.makeText(this, "Option 4 is clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }



    public void showSettings(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_settings);
        popupMenu.show();
    }

}
