package com.fmk.huagu.efitness.Interface;

import android.content.Context;

import org.json.JSONObject;

import java.io.File;

/**
 * 文件下载接口回调
 * Created by fff on 2016/11/30.
 */
public interface GetFileCallback {
    void success(String url, File file);
    void Failt(String url, String error);
    Context getContext();
}
