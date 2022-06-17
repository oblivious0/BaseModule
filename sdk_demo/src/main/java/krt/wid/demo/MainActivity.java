package krt.wid.demo;

import android.Manifest;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.blankj.utilcode.util.AppUtils;
import com.lihang.ShadowLayout;

import java.io.File;
import java.util.List;

import butterknife.OnClick;
import krt.wid.demo.base.BaseActivity;
import krt.wid.demo.test.update.CustomVersionDialog;
import krt.wid.demo.test.update.HfyUpdateProgressDialog;
import krt.wid.demo.web.WebActivity;
import krt.wid.util.MPermissions;
import krt.wid.util.MToast;
import krt.wid.util.MUpdate;

public class MainActivity extends BaseActivity {

    HfyUpdateProgressDialog dialog;
    CustomVersionDialog Vdialog;

    ShadowLayout shadowLayout;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        shadowLayout = findViewById(R.id.action_update);
    }

    @Override
    public void loadData() {

    }

    @OnClick({R.id.action_update, R.id.action_permission, R.id.action_shareWX, R.id.action_openWX})
    public void onAction(View view) {
        switch (view.getId()) {
            case R.id.action_update:
                String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                MPermissions.getInstance().request(this, permissions, value -> {
                    if (value) {
                        MUpdate.newBuilder(this)
                                .setUrl("https://www.krtimg.com/file/json/version-APP-000074.json")
                                .setVerListener(updateInfo -> {
                                    Vdialog = new CustomVersionDialog(MainActivity.this,
                                            updateInfo.getAndroid().getProd().getVersion(), updateInfo.getAndroid().getProd().getInfo());
                                    Vdialog.show();
                                    return Vdialog;
                                })
                                .setCustomDownloadDialogListenr(new MUpdate.CustomDownloadDialogListener() {

                                    @Override
                                    public Dialog getCustomDownloadingDialog(String ver, String info) {
                                        return dialog = new HfyUpdateProgressDialog(MainActivity.this, ver, info);
                                    }

                                    @Override
                                    public void updateProgress(Dialog dialog, int progress) {
                                        MainActivity.this.dialog.setProgress(progress);
                                    }
                                })
                                .setInBack(true)
                                .build();
                    } else {
                        MToast.showToast(MainActivity.this, "您没有授权该权限，请在设置中打开授权!");
                    }
                });
                break;
            case R.id.action_permission:
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        MPermissions.getInstance().request(MainActivity.this, Manifest.permission.CAMERA, value -> {
                            if (value) {
                                MToast.showToast(MainActivity.this, "已跳出子线程");
                            } else {
                                MToast.showToast(MainActivity.this, "您没有授权该权限，请在设置中打开授权!");
                            }
                        });
                    }
                }.start();
                break;
            case R.id.action_shareWX:
//                shareText2WechatFriend(this, "无sdk微信分享！巴扎嘿");
                shareMsg(this, "巴扎嘿",
                        Environment.getExternalStorageDirectory().getPath() + File.separator + AppUtils.getAppName()
                                + File.separator+"/aaa.png");
                break;
            case R.id.action_openWX:
                Intent intent = new Intent(this, WebActivity.class);
                intent.putExtra("url","https://www.ly3618.com/h5video/searchPage.html");
                startActivity(intent);
                break;
            default:
        }
    }

    public static final String PACKAGE_WECHAT = "com.tencent.mm";

    public static boolean isInstallApp(Context context, String app_package) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
        if (pInfo != null) {
            for (int i = 0; i < pInfo.size(); i++) {
                String pn = pInfo.get(i).packageName;
                if (app_package.equals(pn)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void shareText2WechatFriend(Context context, String content) {
        if (isInstallApp(context, PACKAGE_WECHAT)) {
            Intent intent = new Intent();
            ComponentName cop = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
            intent.setComponent(cop);
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra("android.intent.extra.TEXT", content);
            intent.putExtra("Kdescription", !TextUtils.isEmpty(content) ? content : "");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "您需要安装微信客户端", Toast.LENGTH_LONG).show();
        }
    }

    public  void shareMsg(Context context, String msgText,
                                String imgPath) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));
        if (imgPath == null || imgPath.equals("")) {
            intent.setType("text/plain");
        } else {
            File f = new File(imgPath);
            if (f != null && f.exists() && f.isFile()) {
                intent.setType("image/*");
                Uri u = FileProvider.getUriForFile(this,getPackageName()+".fileprovider",f);
                intent.putExtra(Intent.EXTRA_STREAM, u);
            }
        }
        intent.putExtra(Intent.EXTRA_SUBJECT, "巴扎嘿");
        intent.putExtra(Intent.EXTRA_TEXT, "剑光如我，斩尽芜杂");
        intent.putExtra("Kdescription", "剑光如我，斩尽芜杂");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, "分享"));
    }

    @Override
    public void afterRequestPermission(int requestCode, boolean isAllGranted) {

    }
}
