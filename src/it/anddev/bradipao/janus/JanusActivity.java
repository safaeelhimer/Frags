package it.anddev.bradipao.janus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

// main activity (FragmentActivity provides fragment compatibility pre-HC)
public class JanusActivity extends FragmentActivity implements MenuFragment.OnMenufragListener {
   
   // called when the activity is first created
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.ac_main);
   }
   
   // MenuFragment listener
   @Override
   public void onMenufrag(String s) {
      
      // get body fragment (native method is getFragmentManager)
      BodyFragment fragment = (BodyFragment) getSupportFragmentManager().findFragmentById(R.id.bodyFragment);
      
      // if fragment is not null and in layout, set text, else launch BodyActivity
      if ((fragment!=null)&&fragment.isInLayout()) {
         fragment.setText(s);
      } else {
         Intent intent = new Intent(this,BodyActivity.class);
         intent.putExtra("value",s);
         startActivity(intent);
      }
      
   }
   
}