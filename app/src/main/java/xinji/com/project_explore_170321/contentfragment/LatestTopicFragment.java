package xinji.com.project_explore_170321.contentfragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xinji.com.project_explore_170321.R;
import xinji.com.project_explore_170321.optionscategory.OptionsFragment;

/**
 * Created by Administrator on 2017/3/22.
 */

public class LatestTopicFragment extends android.support.v4.app.Fragment{




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_latesttopic, container, false);

        return view;
    }
}
