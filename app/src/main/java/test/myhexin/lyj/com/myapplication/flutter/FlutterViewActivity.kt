package test.myhexin.lyj.com.myapplication.flutter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import io.flutter.facade.Flutter
import io.flutter.plugin.common.MethodChannel
import test.myhexin.lyj.com.myapplication.R
import android.content.Intent


class FlutterViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_view)
//        initView()
        initFlutterContain()

    }

    private fun initView() {
        val flutterView: View = Flutter.createView(this, lifecycle, "flutter Route1")
        val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        addContentView(flutterView, layoutParams)
    }

    private fun initFlutterContain() {
        //初始化Flutter容器
        val flutterView = Flutter.createView(this, lifecycle, "default")
        //注册方法通道
        MethodChannel(flutterView, "samples.demo/navigation").setMethodCallHandler { call, result ->
            //如果方法名为打开新页面,则打开新的activity
            if (call.method == "openNativePage") {
                val intent = Intent(this@FlutterViewActivity, OtherNativeActivity::class.java)
                startActivity(intent)
                result.success(0)
                //如果方法名为关闭Flutter页面，则销毁自身容器
            } else if (call.method == "closeFlutterPage") {
                finish()
                result.success(0)
            } else {
                result.notImplemented()
            }
        }
        //将flutterView替换成Activity的contentView
        setContentView(flutterView)
    }
}
