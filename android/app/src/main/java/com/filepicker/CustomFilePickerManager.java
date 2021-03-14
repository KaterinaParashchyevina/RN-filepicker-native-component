package com.filepicker;


import androidx.annotation.NonNull;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Map;

public class CustomFilePickerManager extends SimpleViewManager<CustomFilePickerView> {
    @NonNull
    @Override
    public String getName() {
        return "RCTMyCustomView";
    }

    @NonNull
    @Override
    protected CustomFilePickerView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new CustomFilePickerView(reactContext);
    }


    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "onClick",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onClick")))
                .build();
    }
}