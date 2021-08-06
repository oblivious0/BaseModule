package krt.wid.demo.test.update;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.numberprogressbar.NumberProgressBar;

import krt.wid.demo.R;
import krt.wid.demo.base.SpUtil;


/**
 * @author: MaGua
 * @create_on:2021/8/2 15:27
 * @description
 */
public class HfyUpdateProgressDialog extends Dialog {
    private NumberProgressBar bar;

    private FrameLayout bg;

    TextView sure, gx;
    TextView neirong, tv_ver;
    private String info, ver;
    private SpUtil sp;

    public HfyUpdateProgressDialog(Context context, String ver, String info) {
        this(context, R.style.progressDialog);
        this.info = info;
        this.ver = ver;
    }

    private HfyUpdateProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hfy_dialog_update_progress);
        sp = new SpUtil(getContext());
        bg = findViewById(R.id.bg);
        bar = findViewById(R.id.progress);
        setCanceledOnTouchOutside(false);
        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                YoYo.with(Techniques.BounceInDown)
                        .duration(8 * 100)
                        .playOn(bg);
            }
        });

        neirong = findViewById(R.id.neirong);
        gx = findViewById(R.id.gx);

        if (TextUtils.isEmpty(info)) {
            neirong.setText("尊敬的用户，南昌城市大脑已经更新版本，请点击更新进行体验吧\n" +
                    "1.页面优化，全新设计。\n" +
                    "2.体验优化\n" +
                    "3.页面优化，全新设计。\n" +
                    "4.体验优化");
        } else neirong.setText(info);
        gx.setText("V" + ver + "版本更新");
    }

    public void setProgress(int progress) {
        bar.setProgress(progress);
    }

}
