package com.example.myapp.com.example.myapp.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.R;

public class Finish_Dialogs extends Dialog implements View.OnClickListener {

	TextView tvdialogtitle, tvdialogbody;
	Button btndialog, btn_relogin;
	String title, body;
	Context ctx;

	public Finish_Dialogs(Context ctx, int themeTranslucentNotitlebar, String title, String body) {
		super(ctx);
		this.ctx = ctx;
		this.title = title;
		this.body = body;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dilog);
		tvdialogtitle = (TextView) findViewById(R.id.tvdialogtitle);
		tvdialogbody = (TextView) findViewById(R.id.tvdialogbody);
		btndialog = (Button) findViewById(R.id.btndialog);
		btn_relogin = (Button) findViewById(R.id.btn_relogin);
		btn_relogin.setOnClickListener(this);
		tvdialogtitle.setText(title);
		tvdialogbody.setText(body);
		btndialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		dismiss();
		switch (v.getId()) {
		case R.id.btndialog:
			break;
		case R.id.btn_relogin:
			/*Intent i = new Intent(ctx, LoginActivity.class);
			ctx.startActivity(i);*/
			break;
		default:
			break;
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		dismiss();
	}
}
