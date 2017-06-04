package com.example.ncq.jnipractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /* Create a TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
        TextView tv = new TextView(this);
        tv.setText( "avcodecLicense:\n"
            +avcodecLicense()+"\n\n"+
                "avcodecConfiguration:\n"+
                avcodecConfiguration()
        );
        setContentView(tv);
    }

    //在hello-jni中实现(调用avcodec-57中的const char *avcodec_license(void))
    public native String  avcodecLicense();

    //在hello-jni中实现(调用avcodec-57中的const char *avcodec_configuration(void)))
    public native String  avcodecConfiguration();

    /* this is used to load the 'hello-jni' library on application
     * startup. The library has already been unpacked into
     * /data/data/com.example.hellojni/lib/libhello-jni.so at
     * installation time by the package manager.
     */
    static {
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avformat-57");
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("swscale-4");
        System.loadLibrary("hello-jni");
    }
}
