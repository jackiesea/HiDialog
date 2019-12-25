package com.csh.hidialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.csh.hidialog.dialog.DialogCallback;
import com.csh.hidialog.dialog.HiDialog;

public class MainActivity extends AppCompatActivity {
    private Button mClickBtn;
    private HiDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClickBtn = findViewById(R.id.click_btn);

        mDialog = new HiDialog.Builder(this)
                .setTitle("关闭")
                .setContent("营销内容")
                .setCallback(new DialogCallback() {
                    @Override
                    public void onDialogCancel() {
                        dismissDialog();
                    }

                    @Override
                    public void onDialogOk() {
                        dismissDialog();
                    }
                }).builder();

        mClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.show();
            }
        });
    }

    private void dismissDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
