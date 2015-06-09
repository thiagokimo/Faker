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
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import io.kimo.faker.R;
import io.kimo.faker.mvp.view.ui.fragment.LoremView;
import io.kimo.faker.mvp.view.ui.fragment.NameView;


public class MainActivity extends AppCompatActivity {
    public static final int LOREM_FRAGMENT = 0;
    public static final int NAME_FRAGMENT = 1;

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
                .withHeader(R.layout.header_drawer)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName("Lorem")

                                .withIdentifier(LOREM_FRAGMENT),
                        new PrimaryDrawerItem().withName("Name").withIdentifier(NAME_FRAGMENT)

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
                replace(LoremView.newInstance());
                break;
            case NAME_FRAGMENT:
                replace(NameView.newInstance());
                break;
        }
    }

    private void replace(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
