package test.myhexin.lyj.com.myapplication;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.flutter.app.FlutterActivity;
import io.flutter.facade.Flutter;
import io.flutter.view.FlutterView;
import test.myhexin.lyj.com.myapplication.flutter.FlutterViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private String date = "2017-06-13 ";
    private Button mBtnFlutter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnFlutter = findViewById(R.id.btn_flutter);
        mBtnFlutter.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_flutter:
                Intent intent = new Intent(MainActivity.this, FlutterViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
