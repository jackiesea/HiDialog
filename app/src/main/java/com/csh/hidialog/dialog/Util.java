package com.csh.hidialog.dialog;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;

public class Util {
    //设置自定义dialog的属性
    public static void setDialogAttributes(Dialog dialog, int width, int heigh, int gravity) {
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(gravity);
        lp.width = width;
        lp.height = heigh;
        dialogWindow.setAttributes(lp);
    }
}
