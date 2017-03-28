package xinji.com.project_explore_170321;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;

import xinji.com.project_explore_170321.base.BaseActivity;
import xinji.com.project_explore_170321.optionscategory.CollectionsFragment;
import xinji.com.project_explore_170321.optionscategory.ExploreFragment;
import xinji.com.project_explore_170321.optionscategory.OptionsFragment;
import xinji.com.project_explore_170321.optionscategory.SettingsFragment;
import xinji.com.project_explore_170321.optionscategory.ZhiHuFragment;

public class TitleListActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private MenuItem menuItem;
    private OptionsFragment optionsFragment;
    private FragmentManager fragmentManager;
    private ExploreFragment exploreFragment;
    private ZhiHuFragment zhiHuFragment;
    private SettingsFragment settingsFragment;
    private CollectionsFragment collectionsFragment;

    public static final String TAG="title";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_list);
        if (Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

        initView();

        fragmentManager=getFragmentManager();

        toolbar.setNavigationIcon(R.mipmap.back);


        setCurrentFragment(R.id.v2ex);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(this);

    }


    private void setCurrentFragment(int itemId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (optionsFragment!=null){
            fragmentTransaction.hide(optionsFragment);
        }

        switch (itemId) {
            case R.id.v2ex: {
                if (exploreFragment ==null) {
                    exploreFragment = new ExploreFragment();
                    Log.i(TAG, "setCurrentFragment: ==="+exploreFragment);
                    fragmentTransaction.add(R.id.fl_title, exploreFragment,"hot");
                }else {
                    fragmentTransaction.show(exploreFragment);
                    Log.i(TAG, "setCurrentFragment: showexplore");
                }

                optionsFragment = exploreFragment;
                toolbar.setTitle(R.string.v2ex);
            }
            break;
            case R.id.zhihu: {
                if (zhiHuFragment==null) {
                    zhiHuFragment = new ZhiHuFragment();
                    Log.i(TAG, "setCurrentFragment: ==="+zhiHuFragment);
                    fragmentTransaction.add(R.id.fl_title,zhiHuFragment,"zhihu");
                }else {
                    fragmentTransaction.show(zhiHuFragment);
                    Log.i(TAG, "setCurrentFragment: showzhihu");
                }
                optionsFragment = zhiHuFragment;

                toolbar.setTitle(R.string.zhihu);
            }
            break;
            case R.id.settings: {
                if (settingsFragment==null) {
                    settingsFragment = new SettingsFragment();
                    fragmentTransaction.add(R.id.fl_title,settingsFragment,"settings");
                }else {
                    fragmentTransaction.show(settingsFragment);
                }
                optionsFragment = settingsFragment;
                toolbar.setTitle(R.string.settings);
            }
            break;
            case R.id.collections: {
                if (collectionsFragment==null) {
                    collectionsFragment = new CollectionsFragment();
                    fragmentTransaction.add(R.id.fl_title,collectionsFragment,"collections");
                }else {
                    fragmentTransaction.show(collectionsFragment);
                }
                optionsFragment = collectionsFragment;
                toolbar.setTitle(R.string.collections);
            }
            break;
        }

        fragmentTransaction.commit();

    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_title);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        toolbar = (Toolbar) findViewById(R.id.titlebar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        navigationView.getMenu().findItem(R.id.v2ex).setChecked(false);

        if (menuItem != null) {
            menuItem.setChecked(false);
        }
        // 保存点击的item
        menuItem = item;
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(Gravity.LEFT);

        int itemId = menuItem.getItemId();


        setCurrentFragment(itemId);


        return false;
    }
}
