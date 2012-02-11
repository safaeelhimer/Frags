package it.anddev.bradipao.janus;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//extended from compatibility Fragment for pre-HC fragment support
public class BodyFragment extends Fragment {

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
      View view = inflater.inflate(R.layout.fr_body,container,false);
      return view;
   }
   
   // set text
   public void setText(String item) {
      TextView view = (TextView) getView().findViewById(R.id.detailsText);
      view.setText(item);
   } 
   
}
