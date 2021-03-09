package com.filepicker;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import static java.security.AccessController.getContext;

public class MainActivity extends ReactActivity {
    public static final int PICKFILE_RESULT_CODE = 1;

    private Button btnChooseFile;
    private TextView tvItemPath;

    private Uri fileUri;
    private String filePath;
    private String fileName;

    private View rootView;

    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "filepicker";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == -1) {
                    fileUri = data.getData();
                    fileName = getFileName(fileUri);



                    WritableMap event = Arguments.createMap();
                    event.putString("message", fileName);
                    ReactContext reactContext = getReactNativeHost().getReactInstanceManager().getCurrentReactContext();

                  Resources res = getResources();
                    Bundle bundle = data.getExtras();
                    if(bundle != null) {
                        String ID = bundle.getString("id");
                    }
                  res.getIdentifier("CustomFilePickerView","id",getPackageName());
                    reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                            3,
                            "onClick",
                            event);

                }

                break;
        }
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }


}
