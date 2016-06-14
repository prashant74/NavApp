package com.example.prashant.snapbug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.moe.pushlibrary.MoEHelper;

/**
 * Created by prashant on 6/14/16.
 */
public class BaseActivity extends AppCompatActivity {
  private MoEHelper mHelper;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mHelper = new MoEHelper(this);
  }

  @Override protected void onStart() {
    super.onStart();
    mHelper.onStart(this);
  }

  @Override protected void onStop() {
    super.onStop();
    mHelper.onStop(this);
  }

  @Override protected void onPause() {
    super.onPause();
    mHelper.onPause(this);
  }

  @Override protected void onResume() {
    super.onResume();
    mHelper.onResume(this);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mHelper.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    mHelper.onRestoreInstanceState(savedInstanceState);
  }

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    mHelper.onNewIntent(this, intent);
  }
}
