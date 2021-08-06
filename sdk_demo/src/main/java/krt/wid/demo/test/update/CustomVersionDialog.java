package krt.wid.demo.test.update;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;

import java.util.List;

import krt.wid.demo.R;
import krt.wid.view.BaseDialog;

/**
 * @author: MaGua
 * @create_on:2021/8/2 15:27
 * @description
 */
public class CustomVersionDialog extends BaseDialog implements View.OnClickListener {

    private Context mContext;
    private String info, ver;
    private OnCloseListener listener_didismiss, listener2;

    RelativeLayout diss;
    TextView sure, gx;
    TextView neirong, tv_ver;

    public CustomVersionDialog(Context context, String ver, String info) {
        super(context);
        this.mContext = context;
        this.info = info;
        this.ver = ver;
    }

    public CustomVersionDialog(Context context, String info, String ver, OnCloseListener dismiss, OnCloseListener isSure) {
        super(context);
        this.mContext = context;
        this.info = info;
        this.ver = ver;
        this.listener_didismiss = dismiss;
        this.listener2 = isSure;
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击更新按钮
            case R.id.anniu:
                if (listener2 != null) {
                    listener2.onClick(this, true);
                }
                //重要，一定要实现
                if (listener != null) {
                    listener.confirm();
                }
                break;
            //点击取消按钮
            case R.id.chacha:
                if (listener_didismiss != null) {
                    listener_didismiss.onClick(this, true);
                }
                if (listener != null) {
                    listener.cancel(this);
                }
                break;
            default:

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_dialog_view);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        diss = findViewById(R.id.chacha);
        sure = findViewById(R.id.anniu);
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

        sure.setOnClickListener(this);
        diss.setOnClickListener(this);

    }

    public interface OnCloseListener {
        void onClick(Dialog dialog, boolean confirm);
    }

}
