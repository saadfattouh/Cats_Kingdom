package com.example.catkingdom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.catkingdom.constants.IntentKeys;
import com.example.catkingdom.fragment.AccessoriesMarketFragment;
import com.example.catkingdom.fragment.CatsMarketFragment;
import com.example.catkingdom.fragment.ClinicsBrowseFragment;
import com.example.catkingdom.fragment.LibraryFragment;
import com.example.catkingdom.fragment.MarketFragment;
import com.example.catkingdom.fragment.MyAccountFragment;
import com.example.catkingdom.fragment.TipsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements MarketFragment.OpenSecondLevelFragment{

    BottomNavigationView bottomNavigationView;

    MarketFragment marketFragment;
    ClinicsBrowseFragment clinicsBrowseFragment;
    LibraryFragment libraryFragment;
    MyAccountFragment myAccountFragment;
    TipsFragment tipsFragment;

    CatsMarketFragment catsMarketFragment;
    AccessoriesMarketFragment accessoriesMarketFragment;

    FloatingActionButton mAddNewCatFab;

    FragmentManager fm;

    boolean outOfMainFragment = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        mAddNewCatFab = findViewById(R.id.add_new_cat_btn);

        marketFragment = new MarketFragment();
        clinicsBrowseFragment = new ClinicsBrowseFragment();
        libraryFragment = new LibraryFragment();
        myAccountFragment = new MyAccountFragment();
        tipsFragment = new TipsFragment();


        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.content_main, tipsFragment, TipsFragment.TAG).commit();
        bottomNavigationView.setSelectedItemId(R.id.placeholder);


        bottomNavigationView.setOnNavigationItemSelectedListener(item -> setSuitableView(item));

        mAddNewCatFab.setOnClickListener(v -> goToAddCatActivity());
    }

    private void goToAddCatActivity() {
        Intent i = new Intent(this, AddCatFroSaleActivity.class);
        startActivity(i);
    }

    private boolean setSuitableView(MenuItem item) {

        switch (item.getItemId()){
            case R.id.market:
                fm.beginTransaction().replace(R.id.content_main, marketFragment, MarketFragment.TAG).commit();
                outOfMainFragment = true;
                return true;
            case R.id.clinics:
                fm.beginTransaction().replace(R.id.content_main, clinicsBrowseFragment, ClinicsBrowseFragment.TAG).commit();
                outOfMainFragment = true;
                return true;
            case R.id.library:
                fm.beginTransaction().replace(R.id.content_main, libraryFragment, LibraryFragment.TAG).commit();
                outOfMainFragment = true;
                return true;
            case R.id.profile:
                fm.beginTransaction().replace(R.id.content_main, myAccountFragment, MyAccountFragment.TAG).commit();
                outOfMainFragment = true;
                return true;
        }
        return false;
    }


    @Override
    public void onBackPressed() {

        CatsMarketFragment catsMarketFragment = (CatsMarketFragment) getSupportFragmentManager().findFragmentByTag(CatsMarketFragment.TAG);
        AccessoriesMarketFragment accessoriesMarketFragment = (AccessoriesMarketFragment) getSupportFragmentManager().findFragmentByTag(AccessoriesMarketFragment.TAG);
        if (catsMarketFragment != null && catsMarketFragment.isVisible()) {
            fm.beginTransaction().replace(R.id.content_main, marketFragment, MarketFragment.TAG).commit();
            return;
        }
        if (accessoriesMarketFragment != null && accessoriesMarketFragment.isVisible()) {
            fm.beginTransaction().replace(R.id.content_main, marketFragment, MarketFragment.TAG).commit();
            return;
        }

        if(outOfMainFragment){
            outOfMainFragment = false;
            fm.beginTransaction().replace(R.id.content_main, tipsFragment, TipsFragment.TAG).commit();
            bottomNavigationView.setSelectedItemId(R.id.placeholder);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public void openSecondLevelFragment(String tag) {
        if(tag.equals(CatsMarketFragment.TAG)){
            catsMarketFragment = new CatsMarketFragment();
            fm.beginTransaction().replace(R.id.content_main, catsMarketFragment, CatsMarketFragment.TAG).commit();
        }else if(tag.equals(AccessoriesMarketFragment.TAG)){
            accessoriesMarketFragment = new AccessoriesMarketFragment();
            fm.beginTransaction().replace(R.id.content_main, accessoriesMarketFragment, AccessoriesMarketFragment.TAG).commit();
        }
    }
}

