package test.myhexin.lyj.com.myapplication.callback;

/**
 * A类
 */
public class Callback {
    /**
     * 定义回调接口的成员变量
     */
    private CallBack mCallback;

    /**
     * 定义一个接口，包涵一个函数，供B类调用
     */
    public interface CallBack {
        public void testCallback();
    }

    /**
     * 用来注册的函数
     * @param mCallBack 接口对象
     */
    public void setCallBack(CallBack mCallBack) {
        this.mCallback = mCallBack;
    }

    /**
     * 调用回调接口对象中的方法
     */
    public void doWork() {
        mCallback.testCallback();
    }
}
