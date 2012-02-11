package it.anddev.bradipao.janus;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// extended from compatibility Fragment for pre-HC fragment support
public class MenuFragment extends Fragment {
   
   // views
   Button btn1,btn2;
   
   // activity listener
   private OnMenufragListener menufragListener;

   // interface for communication with activity
   public interface OnMenufragListener {
      public void onMenufrag(String s);
   }
   
   // onAttach
   @Override
   public void onAttach(Activity activity) {
      super.onAttach(activity);
      try {
         menufragListener = (OnMenufragListener) activity;
      } catch (ClassCastException e) {
         throw new ClassCastException(activity.toString()+" must implement OnMenufragListener");
      }
   }
   
   // onCreate
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   // onActivityCreated
   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
   }
   
   // onCreateView
   @Override
   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fr_menu,container,false);
      
      // get button BTN1
      btn1 = (Button)view.findViewById(R.id.btn1);
      // button listener
      btn1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            sendBodyTextToFragment("Text From Fragment");
         }
      });
      
      // get button BTN2
      btn2 = (Button)view.findViewById(R.id.btn2);
      // button listener
      btn2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            sendBodyTextToActivity("Text From Activity");
         }
      });
      
      return view;
   }
   
   // (recommended) method to send command to activity
   private void sendBodyTextToActivity(String s) {
      menufragListener.onMenufrag(s);
   }
   
   // alternate (not recommended) method with direct access to fragment
   private void sendBodyTextToFragment(String s) {
      
      // get body fragment (native method is getFragmentManager)
      BodyFragment fragment = (BodyFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.bodyFragment);
      
      // if fragment is not null and in layout, set text, else launch BodyActivity
      if ((fragment!=null)&&fragment.isInLayout()) {
         fragment.setText(s);
      } else {
         Intent intent = new Intent(getActivity().getApplicationContext(),BodyActivity.class);
         intent.putExtra("value",s);
         startActivity(intent);
      }
      
   }
   
}
