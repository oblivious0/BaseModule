package krt.wid.demo;

import android.Manifest;
import android.app.Dialog;
import android.view.View;

import butterknife.OnClick;
import krt.wid.demo.base.BaseActivity;
import krt.wid.demo.test.update.CustomVersionDialog;
import krt.wid.demo.test.update.HfyUpdateProgressDialog;
import krt.wid.util.MPermissions;
import krt.wid.util.MToast;
import krt.wid.util.MUpdate;

public class MainActivity extends BaseActivity {

    HfyUpdateProgressDialog dialog;
    CustomVersionDialog Vdialog;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }

    @OnClick({R.id.action_update, R.id.action_permission})
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
            default:
        }
    }

}
