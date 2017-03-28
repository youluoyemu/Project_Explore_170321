package xinji.com.project_explore_170321.customview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import xinji.com.project_explore_170321.R;

/**
 * Created by Administrator on 2017/3/23.
 */

public class ListRefreshLayout extends SwipeRefreshLayout implements AbsListView.OnScrollListener {

    private ListView listView;
    private boolean isLoading;
    private View footerView;
    private OnLoadListener onLoadListener;

    public ListRefreshLayout(Context context) {
        super(context);
    }

    public ListRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        footerView = LayoutInflater.from(context).inflate(R.layout.layout_progress, null,false);

    }

    public boolean isLoading() {
        return isLoading;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (listView==null){
            getListView();
        }

    }

    private void getListView() {

        //获取子view数目
        int count = getChildCount();
        if (count>0){
            //获取第一个子view,SwipeRefreshLayout中只能有一个子View
            View view = getChildAt(0);
            if (view instanceof ListView){
                listView= (ListView) view;
                listView.setOnScrollListener(this);
            }
        }

    }

    public interface OnLoadListener{
        void onLoad();
    }

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.onLoadListener = onLoadListener;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
            // 判断滑动到底部，并且未处于加载状态
            if (listView.getLastVisiblePosition()==listView.getAdapter().getCount()-1&&isLoading==false){
                setLoading(true);

                // 监听接口，加载数据
                onLoadListener.onLoad();

            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {



    }



    public void setLoading(boolean loading){
        //设置加载中，防止正在加载中又触发加载
        isLoading=loading;

        if (loading){
            listView.addFooterView(footerView);
        }else {
            listView.removeFooterView(footerView);
        }
    }

}
