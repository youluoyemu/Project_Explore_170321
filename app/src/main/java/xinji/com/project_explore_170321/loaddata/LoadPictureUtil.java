package xinji.com.project_explore_170321.loaddata;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/3/24.
 */

public class LoadPictureUtil {

    public static void loadPicture(Context context, String url, ImageView imageView){

        Glide.with(context).load("http:"+url).into(imageView);

    }

}
