package xinji.com.project_explore_170321.optionscategory;



import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xinji.com.project_explore_170321.R;
import xinji.com.project_explore_170321.adapter.HotFragmentAdapter;
import xinji.com.project_explore_170321.contentfragment.HotTopicFragment;
import xinji.com.project_explore_170321.contentfragment.LatestTopicFragment;

/**
 * Created by Administrator on 2017/3/21.
 */
public class ExploreFragment extends OptionsFragment {

    public static final String TAG = "Test";

//    private TabLayout tabLayout;
//    private ViewPager viewPager;
    private List<android.support.v4.app.Fragment> fragmentList;

    @Override
    public Fragment createFragment() {
        return new ExploreFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (fragmentList==null) {
            initFragmentList();
        }
        Log.i(TAG, "fragmentList:"+fragmentList.size());


        String[] titles={"HOT","LATEST"};
        AppCompatActivity activity= (AppCompatActivity) getActivity();

        HotFragmentAdapter adapter = new HotFragmentAdapter(activity.getSupportFragmentManager(), fragmentList,titles);
        Log.i(TAG, "adapter:"+adapter.getCount());


        viewPager.setAdapter(adapter);
        Log.i(TAG, "onActivityCreated: end");
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//
//        Log.i(TAG, "onCreateView: ------------------------");

//        View view = inflater.inflate(R.layout.fragment_v2ex, container, false);
//        tabLayout = (TabLayout) view.findViewById(R.id.tl_v2ex);
//        viewPager= (ViewPager) view.findViewById(R.id.viewpager);

//        Log.i(TAG, "tabLayout:"+(tabLayout==null)+"   viewPager:"+(viewPager==null));


//        if (fragmentList==null) {
//            initFragmentList();
//        }
//        Log.i(TAG, "fragmentList:"+fragmentList.size());
//
//
//        String[] titles={"HOT","LATEST"};
//        AppCompatActivity activity= (AppCompatActivity) getActivity();
//
//        HotFragmentAdapter adapter = new HotFragmentAdapter(activity.getSupportFragmentManager(), fragmentList,titles);
//        Log.i(TAG, "adapter:"+adapter.getCount());
//
//
//        viewPager.setAdapter(adapter);
//
//        Log.i(TAG, "getChildCount:"+viewPager.getChildCount());
//        Log.i(TAG, "getCurrentItem:"+viewPager.getCurrentItem());
//
//
//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.sgrey));
//
//
//        return view;
//    }

    public void initFragmentList() {

        fragmentList=new ArrayList<>();

        HotTopicFragment hotTopicFragment = HotTopicFragment.newInstance("https://www.v2ex.com/api/topics/hot.json");
        HotTopicFragment latestTopicFragment = HotTopicFragment.newInstance("https://www.v2ex.com/api/topics/latest.json");

        Log.i(TAG, "initFragmentList: " + hotTopicFragment+"========"+latestTopicFragment);

        fragmentList.add(hotTopicFragment);
        fragmentList.add(latestTopicFragment);

    }
}
