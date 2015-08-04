package com.ep.jyq.design;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.ep.jyq.design.R.id;
import static com.ep.jyq.design.R.layout;


public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout root;
    private DrawerLayout md;
    private NavigationView nv;
    private FirstFragment fra1;
    private SecondFragment fra2;
    private ThredFragment fra3;
    //  private ViewPager vp;
    private VpAdapter adapter;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ActionBarDrawerToggle ad;
      private FloatingActionButton fab;

    //  private TabLayout tablay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        md = (DrawerLayout) findViewById(id.md);
        nv = (NavigationView) findViewById(id.nv_menu);
        root = (CoordinatorLayout) findViewById(id.main_content);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);


//        final ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(drawable.ic_menu);
//        ab.setDisplayHomeAsUpEnabled(true);
//        ab.setHomeButtonEnabled(true);

        ad = new ActionBarDrawerToggle(MainActivity.this,md,R.string.hello_world,R.string.hello_world);
  /*      {
            public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
        }

            @Override
            public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            super.onDrawerSlide(drawerView, 0); // this disables the arrow @ completed state
        }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            super.onDrawerSlide(drawerView, 0); // this disables the animation
        }
        }*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        md.setDrawerListener(ad);
        ad.syncState();
        setupDrawerContent(nv);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("Design Library");
        initEdit();
        //     initvp();

    }




    private void initEdit() {
        final TextInputLayout ip = (TextInputLayout) findViewById(id.textInput);
        final TextInputLayout ipp = (TextInputLayout) findViewById(id.textInputP);
        EditText et = ip.getEditText();
        EditText ett=ipp.getEditText();
        ett.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 6) {
                    ipp.setErrorEnabled(true);
                    ipp.setError(" ◑﹏◐ sorry！ 您的密码请超过6个字符 ");
                } else {
                    ipp.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    ip.setErrorEnabled(true);
                    ip.setError("您输入的姓名不能超过4个字符  ◑﹏◐ sorry！");
                } else {
                    ip.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    fab = (FloatingActionButton) findViewById(id.fabBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root," hi Snacbar !~",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

/*    private void initvp() {
        tablay = (TabLayout) findViewById(R.id.tablay);
        List<Fragment> mlist = new ArrayList<Fragment>();
        mlist.add(new Vpfra());
        mlist.add(new Vpfraa());
        mlist.add(new Vpfraaa());

        List<String> tab = new ArrayList<String>();
        tab.add("Tab One");
        tab.add("Tab Two");
        tab.add("Tab Three");

        tablay.setTabMode(TabLayout.MODE_FIXED);

        vp = (ViewPager) findViewById(R.id.vp);
        adapter = new VpAdapter(getSupportFragmentManager(), mlist, tab);
        vp.setAdapter(adapter);
        tablay.setupWithViewPager(vp);

    }*/


    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fg = (Fragment)
                getSupportFragmentManager().findFragmentById(id.fra);
        if (fg == null) {
            fra1 = new FirstFragment();
            transaction.replace(id.fra, fra1);
            transaction.commit();
        }
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        selectDrawerItem(menuItem);
                        md.closeDrawers();
                        return true;
                    }
                });

    }

    private void selectDrawerItem(MenuItem menuItem) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (menuItem.getItemId()) {
            case id.nav_home:
                if (fra1 == null) {
                    fra1 = new FirstFragment();
                    //   vp.setVisibility(View.GONE);
                    //  tablay.setVisibility(View.GONE);
                }
                transaction.replace(id.fra, fra1);
                break;

            case id.nav_messages:
                //  vp.setVisibility(View.GONE);
                //  tablay.setVisibility(View.GONE);
                break;
            case id.nav_discussion:
                if (fra2 == null) {
                    fra2 = new SecondFragment();
                }
                transaction.replace(id.fra, fra2);
                //   vp.setVisibility(View.GONE);
                //   tablay.setVisibility(View.GONE);
                break;
        }
        transaction.commit();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
      /*  if (item.getItemId() == android.R.id.home) {
            md.openDrawer(GravityCompat.START);
            return true;
        }*/
             if (ad.onOptionsItemSelected(item))
                 return true;

        if(item.getItemId() == id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);


    }

}