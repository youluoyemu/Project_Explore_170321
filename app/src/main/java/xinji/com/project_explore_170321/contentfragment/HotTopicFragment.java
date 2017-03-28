package xinji.com.project_explore_170321.contentfragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import xinji.com.project_explore_170321.R;
import xinji.com.project_explore_170321.adapter.TitleAdapter;
import xinji.com.project_explore_170321.customview.ListRefreshLayout;
import xinji.com.project_explore_170321.loaddata.OKHttpUtil;
import xinji.com.project_explore_170321.optionscategory.OptionsFragment;
import xinji.com.project_explore_170321.pojo.Member;
import xinji.com.project_explore_170321.pojo.Node;
import xinji.com.project_explore_170321.pojo.Topic;
import xinji.com.project_explore_170321.retrofit.DataService;

/**
 * Created by Administrator on 2017/3/22.
 */

public class HotTopicFragment extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener, ListRefreshLayout.OnLoadListener, OKHttpUtil.OnDisplayListener {

    private ListRefreshLayout refreshLayout;
    private ListView listView;
    private List<Topic> topics;
    private String url;
    private TitleAdapter titleAdapter;
    private Handler handler;

    public static final String ARGUMENT = "argument";
    String TAG = "Test";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            url = bundle.getString(ARGUMENT);
            Log.i(TAG, "onCreate: ===========" + url);

        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hottopic, container, false);
        refreshLayout = (ListRefreshLayout) view.findViewById(R.id.refresh);
        listView = (ListView) view.findViewById(R.id.lv_title);

        Log.i(TAG, "onCreateView: =============");

        handler = new Handler();

//        OKHttpUtil.setOnDisplayListener(this);
        OKHttpUtil.getResponseFromServer(url,this);


        if (topics == null) {
//            showProgress();


        }

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadListener(this);


        return view;
    }

    public static HotTopicFragment newInstance(String arguments) {

        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, arguments);
        HotTopicFragment fragment = new HotTopicFragment();
        fragment.setArguments(bundle);

        return fragment;

    }


    @Override
    public void onRefresh() {


        OKHttpUtil.getResponseFromServer(url,this);


    }

    @Override
    public void onLoad() {


        OKHttpUtil.getResponseFromServer(url,this);


    }

    @Override
    public void display(String data) {

        loadData(data);
        Log.i(TAG, "display: ==============" + titleAdapter);

        if (titleAdapter==null){
            titleAdapter = new TitleAdapter(topics, getActivity());
//            Log.i(TAG, "topic: ===="+topics.get(0));

        }

        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "getadapter: ==="+listView.getAdapter());
                if (listView.getAdapter() == null) {

                    listView.setAdapter(titleAdapter);

                    Log.i(TAG, "run: ===========");
                } else {
                    Log.i(TAG, "else: ============== ");
                    titleAdapter.notifyDataSetChanged();
                    if (refreshLayout.isLoading()) {
                        refreshLayout.setLoading(false);
                    } else if (refreshLayout.isRefreshing()) {
                        refreshLayout.setRefreshing(false);
                    }

                }
            }
        });


    }

    private void loadData(String data) {


        topics = new ArrayList<>();
        JSONArray jsonArray = null;

        try {

            jsonArray = new JSONArray(data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        Topic topic = null;
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                jsonObject = (JSONObject) jsonArray.get(i);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            topic = gson.fromJson(jsonObject.toString(), Topic.class);

            topics.add(topic);

        }

    }
}
