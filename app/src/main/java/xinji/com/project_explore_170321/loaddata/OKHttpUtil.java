package xinji.com.project_explore_170321.loaddata;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/27.
 */

public class OKHttpUtil {


    private static final OkHttpClient okHttpClient=new OkHttpClient();
//    private static OnDisplayListener onDisplayListener;

    public interface OnDisplayListener{
        void display(String data);
    }

//    public static void setOnDisplayListener(OnDisplayListener onDisplayListener) {
//        OKHttpUtil.onDisplayListener = onDisplayListener;
//    }

    /**
     * 异步访问网络
     * @param request
     * @param callback
     */
    public static void enqueue(Request request, Callback callback){
        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 异步获取网络数据
     * @param url
     */

    public static void getResponseFromServer(String url,final OnDisplayListener onDisplayListener){

        Request request=new Request.Builder().url(url).build();
        enqueue(request, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String data = response.body().string();
                onDisplayListener.display(data);
            }
        });





    }

}
