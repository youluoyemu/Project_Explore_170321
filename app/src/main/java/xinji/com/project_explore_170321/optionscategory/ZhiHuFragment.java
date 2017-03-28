package xinji.com.project_explore_170321.optionscategory;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

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

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Administrator on 2017/3/22.
 */

public class ZhiHuFragment extends OptionsFragment {

    private List<android.support.v4.app.Fragment> fragmentList;

    public static final String TAG="Test";

    @Override
    public Fragment createFragment() {
        return new ZhiHuFragment();
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        Log.i(TAG, "onCreateView: ===");
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (fragmentList==null) {
            initFragmentList();
        }
        Log.i(TAG, "fragmentList:======="+fragmentList.size());


        String[] titles={"SUBJECT","PICTURE"};
        AppCompatActivity activity= (AppCompatActivity) getActivity();

        HotFragmentAdapter adapter = new HotFragmentAdapter(activity.getSupportFragmentManager(), fragmentList,titles);



        Log.i(TAG, "adapter:"+adapter.getCount());


        viewPager.setAdapter(adapter);
        Log.i(TAG, "onActivityCreated: end");

    }

    @Override
    protected void initFragmentList() {

        fragmentList=new ArrayList<>();

        HotTopicFragment hotTopicFragment = HotTopicFragment.newInstance("");
        HotTopicFragment latestTopicFragment = HotTopicFragment.newInstance("https://www.v2ex.com/api/topics/latest.json");

        Log.i(TAG, "initFragmentList:========= " + hotTopicFragment+"========"+latestTopicFragment);

        fragmentList.add(hotTopicFragment);
        fragmentList.add(latestTopicFragment);

    }
}
