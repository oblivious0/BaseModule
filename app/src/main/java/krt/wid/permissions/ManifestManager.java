package krt.wid.permissions;

import android.Manifest;

public class ManifestManager {
    /**
     * 文件读写权限
     * 需要执行文件读取/写入时申请
     */
    public static String[] EXTERNAL_STORAGE_GROUP = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    /**
     * 位置信息获取
     * 需要获取设备GPS信息时申请
     */
    public static String[] LOCATION_GROUP = {Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    /**
     * 手机状态
     * 需要保持手机唤醒状态/网络状况时申请
     */
    public static String[] DEVICE_STATUS_GROUP = {Manifest.permission.READ_PHONE_STATE};

    public static String EXTERNAL_STORAGE_HINT = "此功能或模块需要申请读取/写入您的手机文件权限，如果拒绝将导致部分功能不可使用";
    public static String LOCATION_HINT = "此功能或模块需要申请获取您的位置信息权限，如果拒绝将导致部分功能不可使用";
    public static String DEVICE_STATUS_HINT = "此功能或模块需要申请获取您设备状态权限，如果拒绝将导致部分功能不可使用";
}
