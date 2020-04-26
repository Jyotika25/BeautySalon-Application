package com.example.jyotikasharma.makeupstudio936;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
  //  Button btn=findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Your enquiry is SENT!!!", Toast.LENGTH_LONG).show();
    }
});*/

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nv = (NavigationView)findViewById(R.id.nv);

        dl = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, dl,toolbar,R.string.Open,R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            nv.setCheckedItem(R.id.home);
        }
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      //  dl.closeDrawer(Gravity.START, false);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        FragmentManager manager = getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.aboutus:
                        AboutFragment aboutFragment = new AboutFragment();
                        FragmentManager manager1 = getSupportFragmentManager();
                        manager1.beginTransaction().replace(R.id.fragment_container, aboutFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.contactus:
                        ContactFragment contactFragment = new ContactFragment();
                        FragmentManager manager2 = getSupportFragmentManager();
                        manager2.beginTransaction().replace(R.id.fragment_container, contactFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
                        break;
                  case R.id.pkgs:
                        PackageFragment packageFragment = new PackageFragment();
                        FragmentManager manager3 = getSupportFragmentManager();
                        manager3.beginTransaction().replace(R.id.fragment_container, packageFragment).commit();
                      dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Packages", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.work:
                        WorksFragment worksFragment = new WorksFragment();
                        FragmentManager manager4 = getSupportFragmentManager();
                        manager4.beginTransaction().replace(R.id.fragment_container, worksFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Our Works", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.beau:
                        BeautyFragment beautyFragment = new BeautyFragment();
                        FragmentManager manager5 = getSupportFragmentManager();
                        manager5.beginTransaction().replace(R.id.fragment_container, beautyFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Beauty and BodyCare", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bri:
                        BridalFragment bridalFragment = new BridalFragment();
                        FragmentManager manager6 = getSupportFragmentManager();
                        manager6.beginTransaction().replace(R.id.fragment_container, bridalFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Bridal Makeover", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fac:
                        FacialFragment facialFragment = new FacialFragment();
                        FragmentManager manager7 = getSupportFragmentManager();
                        manager7.beginTransaction().replace(R.id.fragment_container, facialFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "Facial Treatments", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sty:
                        StylingFragment stylingFragment = new StylingFragment();
                        FragmentManager manager8 = getSupportFragmentManager();
                        manager8.beginTransaction().replace(R.id.fragment_container, stylingFragment).commit();
                        dl.closeDrawers();
                        Toast.makeText(MainActivity.this, "HairStyling", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;

            }
        });


    }

    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
                 }
    }
}



