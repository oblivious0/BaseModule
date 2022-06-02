package krt.wid.permissions;

public interface ManifestMain {

    boolean checkPermissions(String[] neededPermissions) ;

    /**
     * 请求权限的回调
     *
     * @param requestCode  请求码
     * @param isAllGranted 是否全部被同意
     */
    void afterRequestPermission(int requestCode, boolean isAllGranted);
}
