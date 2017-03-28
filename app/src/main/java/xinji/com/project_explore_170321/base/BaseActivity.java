package xinji.com.project_explore_170321.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/23.
 */

public class BaseActivity extends AppCompatActivity {

    private boolean isFinish;
    private long lastTime;
    public Activity mContext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        mContext=this;


        if (Build.VERSION.SDK_INT>=21){
            View decorView = mContext.getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            mContext.getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){

            Log.i("Test", "onKeyDown: ============="+getSupportFragmentManager().getBackStackEntryCount());
            if (getSupportFragmentManager().getBackStackEntryCount()==0){

                Date date = new Date(System.currentTimeMillis());
                long currentTime = date.getTime();


                if (!isFinish){
                    Toast.makeText(this,"再次点击将退出程序",Toast.LENGTH_SHORT).show();
                    lastTime=currentTime;
                    isFinish=true;
                    return false;
                }else {
                    if (currentTime-lastTime<3000) {
                        finish();
                        return true;
                    }else {
                        Toast.makeText(this,"再次点击将退出程序",Toast.LENGTH_SHORT).show();
                        lastTime=currentTime;

                    }

                    return false;
                }
            }

        }

        return super.onKeyDown(keyCode, event);
    }
}
