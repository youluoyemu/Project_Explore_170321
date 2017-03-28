package xinji.com.project_explore_170321.optionscategory;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xinji.com.project_explore_170321.R;

/**
 * Created by Administrator on 2017/3/22.
 */

public class SettingsFragment extends OptionsFragment {
    @Override
    public Fragment createFragment() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        return view;
    }

    @Override
    protected void initFragmentList() {

    }
}
