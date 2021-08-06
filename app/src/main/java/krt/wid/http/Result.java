package krt.wid.http;


import krt.wid.config.BaseModule;

public class Result<T> {
    public String msg;

    public int code;

    public T data;

    public boolean isSuccess() {
        return code == BaseModule.getBaseModuleConfig().getServerSuccessCode();
    }

}
