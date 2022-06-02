package krt.wid.permissions;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ManifestUtils {

    private ManifestMain mContext;
    private String[] applyPermissions = {};
    private int requestCode = 0;
    private String hint;

    private ManifestUtils(ManifestMain mContext, String[] applyPermissions, int requestCode, String hint) {
        this.mContext = mContext;
        this.applyPermissions = applyPermissions;
        this.requestCode = requestCode;
        this.hint = hint;
        request();
    }

    private void request() {
        if (mContext.checkPermissions(applyPermissions)) {
            Activity activity = null;
            if (mContext instanceof AppCompatActivity) {
                activity = (AppCompatActivity) mContext;
            } else if (mContext instanceof Fragment) {
                activity = ((Fragment) mContext).getActivity();
            }

            if (activity != null) {
                //ActivityCompat.requestPermissions(activity, applyPermissions, requestCode);
            } else {
                throw new NullPointerException("主体不存在！");
            }


        }

    }

    public static class Builder {
        private ManifestMain mContext;
        private String[] iApplyPermissions = {};
        private int iRequestCode = 0;
        private String iHint;

        public Builder(ManifestMain c) {
            mContext = c;
        }

        public Builder setApplyPermissions(String[] iApplyPermissions) {
            this.iApplyPermissions = iApplyPermissions;
            return this;
        }

        public Builder setRequestCode(int iRequestCode) {
            this.iRequestCode = iRequestCode;
            return this;
        }

        public Builder setHint(String iHint) {
            this.iHint = iHint;
            return this;
        }

        public void build() {
            ManifestUtils manifestUtils = new ManifestUtils(mContext, iApplyPermissions, iRequestCode, iHint);
        }
    }


}
