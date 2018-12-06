package com.qst.chapter04.activity;
import com.qst.chapter04.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

public class ProviderActivityDemo extends AppCompatActivity {
	//定义共享的ActionProvider
	private ShareActionProvider  mShareActionProvider;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.provider);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.share_menu, menu);
		MenuItem menuItem = menu.findItem(R.id.share_item);
		mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
		Intent shareIntent=getShareIntent();
		mShareActionProvider.setShareIntent(shareIntent);
		return true;
	}

	public Intent getShareIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_TEXT, "这里是要分享的文字");
		intent.setType("text/plain");
		Intent.createChooser(intent, "Share");
		return intent;
	}

}
