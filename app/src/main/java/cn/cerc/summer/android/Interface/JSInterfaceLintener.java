package cn.cerc.summer.android.Interface;

import android.content.Context;

import cn.cerc.summer.android.Utils.PhotoUtils;

/**
 * Created by fengm on 2016/12/23.
 */

public interface JSInterfaceLintener {

    Context getContext();

    /**
     * 登陆和退出的js调用回调
     * @param islogin   true：登录 false：退出
     */
    void LoginOrLogout(boolean islogin,String rul);

    /**
     * 调用硬件的各种动作
     * @param json      暂时无用
     * @param action    操作动作
     */
    void Action(String json, String action);

    /**
     * 隐藏返回按钮
     * @param flag  是否隐藏
     */
    void showBack(boolean flag);
    /**
     * 隐藏绑卡按钮
     * @param flag   外部网页的url
     */
//    void showCard(boolean flag);
    /**
     * 显示图片的
     * @param imgUrl    图片的URL
     */
    void showImage(String imgUrl);

    /**
     * 单独打开外部的url
     * @param url   外部网页的url
     */
    void openAd(String url);
    /**
     * 打开或关闭下拉刷新
     * @param flag  是否隐藏
     */
    void pullrefresh(boolean flag);

    void showBtn(String name,String callback,boolean flag);
/*
通用右上角标题图标按键事件
@name 文字内容
@callback 方法名称
@img textview的图片背景
 */
    void showtitlrright(String json);
}
