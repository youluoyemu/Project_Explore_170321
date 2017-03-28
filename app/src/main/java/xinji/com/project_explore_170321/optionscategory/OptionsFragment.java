package xinji.com.project_explore_170321.optionscategory;

import android.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xinji.com.project_explore_170321.R;

/**
 * Created by Administrator on 2017/3/22.
 */
public abstract class OptionsFragment extends Fragment{

    private TabLayout tabLayout;
    protected ViewPager viewPager;

    public static final String TAG="Test";

    public abstract Fragment createFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG, "onCreateView:=== "+this);

        View view = inflater.inflate(R.layout.fragment_v2ex, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tl_v2ex);
        viewPager= (ViewPager) view.findViewById(R.id.viewpager);



        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.sgrey));


        return view;

    }

    protected abstract void initFragmentList();
}
