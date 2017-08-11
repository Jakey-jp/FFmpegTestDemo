/**
 * ��򵥵Ļ���FFmpeg��Helloworld����-��׿
 * Simplest FFmpeg Android Helloworld
 * <p/>
 * ������ Lei Xiaohua
 * leixiaohua1020@126.com
 * �й�ý��ѧ/���ֵ��Ӽ���
 * Communication University of China / Digital TV Technology
 * http://blog.csdn.net/leixiaohua1020
 * <p/>
 * <p/>
 * ����������ֲFFmpeg����׿ƽ̨����򵥳�������Դ�ӡ��FFmpeg����������Ϣ��
 * Protocol:  FFmpeg���֧�ֵ�Э��
 * AVFormat:  FFmpeg���֧�ֵķ�װ��ʽ
 * AVCodec:   FFmpeg���֧�ֵı������
 * AVFilter:  FFmpeg���֧�ֵ��˾�
 * Configure: FFmpeg����������Ϣ
 * <p/>
 * This is the simplest program based on FFmpeg in Android. It can show following
 * informations about FFmpeg library:
 * Protocol:  Protocols supported by FFmpeg.
 * AVFormat:  Container format supported by FFmpeg.
 * AVCodec:   Encoder/Decoder supported by FFmpeg.
 * AVFilter:  Filters supported by FFmpeg.
 * Configure: configure information of FFmpeg.
 */


package com.example.l1.ffmpegdemo;

/**
 * Created by jakey on 2017/4/8.
 * QQ 784990536
 */
import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView libinfoText = (TextView) findViewById(R.id.text_libinfo);
        libinfoText.setMovementMethod(ScrollingMovementMethod.getInstance());

        libinfoText.setText(configurationinfo());

        Button configurationButton = (Button) this.findViewById(R.id.button_configuration);
        Button urlprotocolButton = (Button) this.findViewById(R.id.button_urlprotocol);
        Button avformatButton = (Button) this.findViewById(R.id.button_avformat);
        Button avcodecButton = (Button) this.findViewById(R.id.button_avcodec);
        Button avfilterButton = (Button) this.findViewById(R.id.button_avfilter);

        urlprotocolButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                String info = urlprotocolinfo();
                libinfoText.setText(info);
            }
        });

        avformatButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                libinfoText.setText(avformatinfo());
            }
        });

        avcodecButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                libinfoText.setText(avcodecinfo());
            }
        });

        avfilterButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                libinfoText.setText(avfilterinfo());
            }
        });

        configurationButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                libinfoText.setText(configurationinfo());
            }
        });

    }

    //声明函数
    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();
    public native String configurationinfo();

    //载入动态库
    static {
//        System.loadLibrary("avcodec-57");
//        System.loadLibrary("avdevice-57");
//        System.loadLibrary("avfilter-6");
//        System.loadLibrary("avformat-57");
//        System.loadLibrary("avutil-55");
//        System.loadLibrary("postproc-54");
//        System.loadLibrary("swresample-2");
//        System.loadLibrary("swscale-4");

        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avformat-57");
        System.loadLibrary("swscale-4");
        System.loadLibrary("postproc-54");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avdevice-57");

        System.loadLibrary("ffmpegdemo");   //自己的库
    }

}
