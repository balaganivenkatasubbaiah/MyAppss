package com.example.myapp.dialogs;



import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.R;


public class All_Dialogs extends Dialog implements
		View.OnClickListener {

	TextView tvdialogtitle, tvdialogbody;
	Button btndialog;
	String title, body;
	public All_Dialogs(Context ctx, int themeTranslucentNotitlebar,
			String title, String body) {
		super(ctx);
		this.title = title;
		this.body = body;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.all_dialogs);
		tvdialogtitle = (TextView) findViewById(R.id.tvdialogtitle);
		tvdialogbody = (TextView) findViewById(R.id.tvdialogbody);
		btndialog = (Button) findViewById(R.id.btndialog);
		tvdialogtitle.setText(title);
		tvdialogbody.setText(body);
		btndialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		dismiss();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		dismiss();
	}
}
