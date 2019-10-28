package test.myhexin.lyj.com.myapplication.flutter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import test.myhexin.lyj.com.myapplication.R
import android.view.MenuItem


class OtherNativeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_native)
        initView()
    }

    private fun initView() {
        findViewById<Button>(R.id.btn_intent).setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        val intent = Intent(this@OtherNativeActivity, FlutterViewActivity::class.java)
                        startActivity(intent)
                    }

                }
        )

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home->{
                this.finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
//    fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            android.R.id.home -> {
//                this.finish() // back button
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}
