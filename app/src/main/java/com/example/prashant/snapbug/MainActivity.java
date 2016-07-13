package com.example.prashant.snapbug;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends BaseActivity implements OnNavClickListener {

  FrameLayout content;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    content = (FrameLayout) findViewById(R.id.content);
    showCategories();
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override protected void onSaveInstanceState(final Bundle outState) {
    outState.putInt("key", 0);
    super.onSaveInstanceState(outState);
  }

  private final Handler mDrawerActionHandler = new Handler();

  private void showCategories() {
    mDrawerActionHandler.postDelayed(new Runnable() {
      @Override public void run() {
        FragmentA fragment = new FragmentA();
        Bundle data = new Bundle();
        data.putString("key", "value");
        fragment.setArguments(data);
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.content, fragment, "Fragment")
            .addToBackStack(null)
            .commit();
      }
    }, 300);
  }

  @Override public void onNavClick(View view) {
    navigate(view.getId());
  }

  private void navigate(int id) {
    switch (id) {
      case R.id.nav_camera:
      case R.id.FragBButton:
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.content, new FragmentA(), "Fragment")
            .addToBackStack(null)
            .commit();
        break;
      case R.id.nav_gallery:
      case R.id.FragAButton:
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.content, new FragmentB(), "Fragment")
            .addToBackStack(null)
            .commit();
        break;
    }
  }
}