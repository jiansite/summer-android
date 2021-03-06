package cn.cerc.summer.android.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import org.json.JSONObject;

import cn.cerc.summer.android.core.MyApp;
import cn.cerc.summer.android.forms.JavaScriptService;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Administrator on 2017/12/29.
 */

public class HeartbeatCheck implements JavaScriptService {

    private String token = null;

    @Override
    public String execute(Context context, JSONObject request) throws Exception {
        if (!request.has("status")) {
            return "没有传入指定参数";
        }
        if (!request.has("time")) {
            return "没有传入指定参数";
        }
        if (!request.has("token")) {
            return "没有传入指定参数";
        }
        boolean status = request.getBoolean("status");
        token = request.getString("token");
        Intent intent = new Intent(context, LongRunningService.class);
        if (!"".equals(token)) {
            intent.putExtra("token", token);
        }
        intent.putExtra("time", request.getInt("time") * 60000);
        if (status) {
            if (!MyApp.getInstance().isServiceWork(context, "cn.cerc.summer.android.services.LongRunningService")) {
                context.startService(intent);
            }
        } else {
            AlarmManager manager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
            Intent intent1 = new Intent("ELITOR_CLOCK");
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent1, 0);
            manager.cancel(pi);
            context.stopService(intent);
        }
        return "";
    }
}