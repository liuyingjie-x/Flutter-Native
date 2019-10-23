package test.myhexin.lyj.com.myapplication.callback;

import android.widget.Button;

/**
 * B类
 */
public class TestCallback {
    private Callback callback;
    private void testButton(){
        /**
         * 为Callback类设置回调函数, 在这里定义具体的回调方法
         */
        callback.setCallBack(new Callback.CallBack() {
            @Override
            public void testCallback() {

            }
        });
    }
}
