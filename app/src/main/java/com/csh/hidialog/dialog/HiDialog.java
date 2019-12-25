package com.csh.hidialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.csh.hidialog.R;

public class HiDialog extends Dialog {
    private Dialog mDialog;

    private HiDialog(Builder builder) {
        super(builder.context);
        init(builder);
    }

    private void init(Builder builder) {
        buildHiDialog(builder);
    }

    private void buildHiDialog(final Builder builder) {
        mDialog = new Dialog(builder.context, R.style.HiDialog);
        View view = LayoutInflater.from(builder.context).inflate(R.layout.hi_dialog, null);
        mDialog.setContentView(view);
        mDialog.setCanceledOnTouchOutside(false);
        Util.setDialogAttributes(mDialog, 300, 500, Gravity.CENTER);

        TextView hi_title = view.findViewById(R.id.title);
        TextView hi_content = view.findViewById(R.id.content);
        Button hi_cancel = view.findViewById(R.id.cancel);
        Button hi_ok = view.findViewById(R.id.ok);

        hi_title.setText(builder.title);
        hi_content.setText(builder.content);
        hi_content.setMovementMethod(ScrollingMovementMethod.getInstance());

        hi_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (builder.callback != null) {
                    builder.callback.onDialogCancel();
                }
            }
        });

        hi_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (builder.callback != null) {
                    builder.callback.onDialogOk();
                }
            }
        });
    }

    public void show() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public static class Builder {
        private Context context;
        private DialogCallback callback;
        private String title;
        private String content;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setCallback(DialogCallback callback) {
            this.callback = callback;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public HiDialog builder() {
            return new HiDialog(this);
        }
    }
}
