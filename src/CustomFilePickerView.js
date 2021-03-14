import React from 'react';
import {requireNativeComponent} from 'react-native';

const FilePickerView = requireNativeComponent('RCTMyCustomView');

const CustomFilePickerView = (props) => {


   const _onClick = (event) => {
        if (!props.onClick) {
            return;
        }

        // process raw event
       props.onClick(event.nativeEvent);
    }


        return <FilePickerView {...props} onClick={_onClick}/>;

}

export default CustomFilePickerView;
