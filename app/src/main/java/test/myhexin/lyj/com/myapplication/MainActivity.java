package test.myhexin.lyj.com.myapplication;

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
import android.widget.TextView;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
 private static  final Pattern PATTERN=Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
 private String date ="2017-06-13 ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv_text);
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        textView.getPaint().setAntiAlias(true);
        TextView textView1 = findViewById(R.id.tv_text2);
//        textView1.
        SpannableString content = new SpannableString(textView1.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, textView1.length(), 0);
        TextView textView2 = findViewById(R.id.tv_text3);
        textView2.setText(Html.fromHtml("<u>" + textView2.getText().toString() + "</u>"));
        Matcher matcher =PATTERN.matcher(date);
        if (matcher.find()){
            Log.e("lyj","onCreate:"+matcher.group());
        }
        BatteryManager batteryManager = (BatteryManager) getSystemService(BATTERY_SERVICE);
        Intent intent = new ContextWrapper(getApplicationContext()).
                registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//        Log.e("lyj", "onCreate: "+matcher.start()+"" );
        PATTERN.matcher(date);
//        Paint paint=new Paint();
//        Canvas canvas=new Canvas();
//        paint.setUnderlineText(true);
//        canvas.drawText(textView2.getText().toString(),10,20,paint);
        getMacAddress(textView, textView1);
        for (int i = 0; i <10 ; i++) {

        }
        String number = "2.3456789";
        int length =number.indexOf('.');
        textView.setText(number.length()-1-length+"");
//        WebView webView = findViewById(R.id.webview);
//        webView.loadUrl("about:blank");
//        webView.loadUrl("http://www.baidu.com");
    }


    private String test(){
        return "hhh";
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    private void getMacAddress(TextView textViewMac, TextView textViewIp) {
        String macAddress = null;
        String ip = null;
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = (null == wifiManager ? null : wifiManager.getConnectionInfo());
        if (null != wifiInfo) {
            macAddress = wifiInfo.getMacAddress();
            ip = String.valueOf(wifiInfo.getIpAddress());
            textViewMac.setText(getMacAddr());
            textViewIp.setText(ip);
            Log.e("lyj", "getMacAddress: " + getMacAddr() + "==" + ip);
        }
    }
    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:",b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }

}
