package xinji.com.project_explore_170321.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import xinji.com.project_explore_170321.pojo.Topic;

/**
 * Created by Administrator on 2017/3/24.
 */

public interface DataService {

    @GET("api/topics/hot.json")
    Call<Topic> topicHttpGet();

}
