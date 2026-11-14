package com.meloxi.dairy.app;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;

public class MeloxiOverlayService extends Service {
    private WindowManager windowManager;
    private Button floatingMicBtn;

    @Override
    public void onCreate() {
        super.onCreate();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        floatingMicBtn = new Button(this);
        floatingMicBtn.setText("MELOXI DAIRY");
        floatingMicBtn.setTextColor(Color.BLACK);
        floatingMicBtn.setBackgroundColor(Color.parseColor("#f59e0b"));
        floatingMicBtn.setPadding(28, 16, 28, 16);

        int layoutFlag = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
            ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            : WindowManager.LayoutParams.TYPE_PHONE;

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            layoutFlag,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        );
        params.gravity = Gravity.TOP | Gravity.END;
        params.x = 24;
        params.y = 220;

        floatingMicBtn.setOnClickListener(v -> {
            Intent openApp = new Intent(this, MainActivity.class);
            openApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(openApp);
        });

        windowManager.addView(floatingMicBtn, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (floatingMicBtn != null && windowManager != null) {
            windowManager.removeView(floatingMicBtn);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
