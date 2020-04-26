package com.example.jyotikasharma.makeupstudio936;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final LinearLayout mLinearLayout=(LinearLayout) inflater.inflate(R.layout.fragment_contact, container, false);
        Button mButton=mLinearLayout.findViewById(R.id.button);
       final EditText name =mLinearLayout.findViewById(R.id.editText);
       final EditText email  =mLinearLayout.findViewById(R.id.editText3);
     final EditText phone =mLinearLayout.findViewById(R.id.editText4);
     final EditText msg =mLinearLayout.findViewById(R.id.editText5);
        View btnCall=(Button)mLinearLayout.findViewById(R.id.call_btn2);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callnow();
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Your enquiry is SENT", Toast.LENGTH_LONG).show();
                String myname = name.getText().toString();
                String myemail = email.getText().toString();
                String myphone = phone.getText().toString();
                String mymsg = msg.getText().toString();
                String emailAddressList[] = {"enter email"};
                String mycontent = myname + "," + myemail + "," + myphone + ","+ mymsg;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
                startActivity(Intent.createChooser(email, "Select Sender:"));

            }
        });
        return mLinearLayout;
    }
    private void callnow(){
        Intent callIntent1=new Intent(Intent.ACTION_CALL);
        callIntent1.setData(Uri.parse("tel:" + ""));
        callIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent1);
    }

}
