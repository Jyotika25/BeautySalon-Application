package com.example.jyotikasharma.makeupstudio936;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      View rootView= inflater.inflate(R.layout.fragment_home, container, false);
View btnCall=(Button)rootView.findViewById(R.id.call_btn);
btnCall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        call();
    }
});
return rootView;

    }
private void call(){
        Intent callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "7015547964"));
    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    if (ActivityCompat.checkSelfPermission(getActivity(),
            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        return;
    }
        startActivity(callIntent);
}


}
