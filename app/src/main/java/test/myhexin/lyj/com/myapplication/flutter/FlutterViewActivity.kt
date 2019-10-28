package test.myhexin.lyj.com.myapplication.flutter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import io.flutter.facade.Flutter
import test.myhexin.lyj.com.myapplication.R

class FlutterViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_view)
        initView()
    }

    private fun initView() {
        val flutterView: View = Flutter.createView(this, lifecycle, "flutter Route1")
        val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        addContentView(flutterView, layoutParams)
    }
}
