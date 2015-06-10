package io.kimo.faker.mvp.view.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import io.kimo.faker.R;
import io.kimo.faker.mvp.view.ui.fragment.InternetFragment;
import io.kimo.faker.mvp.view.ui.fragment.LoremFragment;
import io.kimo.faker.mvp.view.ui.fragment.NameFragment;
import io.kimo.faker.mvp.view.ui.fragment.NumberFragment;
import io.kimo.faker.mvp.view.ui.fragment.PhoneFragment;


public class MainActivity extends AppCompatActivity {
    public static final int LOREM_FRAGMENT = 0;
    public static final int NAME_FRAGMENT = 1;
    public static final int NUMBER_FRAGMENT = 2;
    public static final int PHONE_FRAGMENT = 3;
    public static final int INTERNET_FRAGMENT = 4;

    private Toolbar toolbar;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_toolbar);

        configureToolbar();
        configureDrawer(savedInstanceState);

        if(savedInstanceState == null) {
            showFragment(LOREM_FRAGMENT);
        }
    }

    private void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null) {
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void configureDrawer(Bundle savedInstanceState) {

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(
                        new AccountHeaderBuilder()
                                .withActivity(this)
                                .withHeaderBackground(R.drawable.drawer_background)
                                .withProfileImagesClickable(false)
                                .build()
                )
                .withToolbar(toolbar)
                .withTranslucentStatusBar(true)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName("Lorem")
                                .withIdentifier(LOREM_FRAGMENT),
                        new PrimaryDrawerItem()
                                .withName("Name")
                                .withIdentifier(NAME_FRAGMENT),
                        new PrimaryDrawerItem()
                                .withName("Number")
                                .withIdentifier(NUMBER_FRAGMENT),
                        new PrimaryDrawerItem()
                                .withName("Phone")
                                .withIdentifier(PHONE_FRAGMENT),
                        new PrimaryDrawerItem()
                                .withName("Internet")
                                .withIdentifier(INTERNET_FRAGMENT)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        if(iDrawerItem != null) {
                            showFragment(iDrawerItem.getIdentifier());
                        }

                        return false;
                    }
                })
                .withHeaderClickable(true)
                .withSelectedItem(LOREM_FRAGMENT)
                .withSavedInstance(savedInstanceState)
                .build();
    }

    @Override
    public void onBackPressed() {
        if(drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void showFragment(int flag) {
        switch (flag) {
            case LOREM_FRAGMENT:
                replace(LoremFragment.newInstance());
                break;
            case NAME_FRAGMENT:
                replace(NameFragment.newInstance());
                break;
            case NUMBER_FRAGMENT:
                replace(NumberFragment.newInstance());
                break;
            case PHONE_FRAGMENT:
                replace(PhoneFragment.newInstance());
                break;
            case INTERNET_FRAGMENT:
                replace(InternetFragment.newInstance());
                break;
        }
    }

    private void replace(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
