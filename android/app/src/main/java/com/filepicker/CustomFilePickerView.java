package com.filepicker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;



public class CustomFilePickerView extends LinearLayout {
    public ThemedReactContext myContext;
    public static final int PICKFILE_RESULT_CODE = 1;
    public View rootView;

    public CustomFilePickerView(ThemedReactContext context) {
        super(context);
        this.myContext = context;
        init();
    }

    private void init() {
        rootView = inflate(myContext, R.layout.main_layout, this);
        Button btnChooseFile = (Button) rootView.findViewById(R.id.btn_choose_file);
        btnChooseFile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CustomFilePickerView.this.myOnClick(v);
            }
        });
    }

    public void myOnClick(View view) {
        Log.d("DEBUG", "CLICKED ");
        WritableMap event = Arguments.createMap();
        event.putString("message", "MyMessage");
        ReactContext reactContext = (ReactContext) getContext();
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.setType("*/*");
        chooseFile = Intent.createChooser(chooseFile, "Choose a file");
        Bundle args=new Bundle();
        args.putInt("id", this.getId());
        reactContext.startActivityForResult(chooseFile, PICKFILE_RESULT_CODE, args);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        ReactContext reactContext = (ReactContext) getContext();




    }


}