/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState} from 'react';
import {
    SafeAreaView,
    StyleSheet,
    Text,
    View,
    StatusBar,
} from 'react-native';

import {
    Colors,
} from 'react-native/Libraries/NewAppScreen';
import CustomFilePickerView from './src/CustomFilePickerView';

const App: () => React$Node = () => {
    const [fileName, setFileName] = useState(null)
    const onClick = (event: Object) => {
        setFileName(event.message)
    };
    return (
        <>
            <StatusBar barStyle="dark-content"/>
            <SafeAreaView>

                    <View style={styles.body}>
                        <CustomFilePickerView style={{width: 300, height: 300}} onClick={onClick}/>
                        {fileName && <View>
                            <Text>{`Selected file:\n ${fileName}`}</Text>
                        </View>}
                    </View>

            </SafeAreaView>
        </>
    );
};

const styles = StyleSheet.create({
    scrollView: {
        backgroundColor: Colors.lighter,
    },
    engine: {
        position: 'absolute',
        right: 0,
    },
    body: {
        alignItems: 'center',
        justifyContent: 'center'
    },
    sectionContainer: {
        marginTop: 32,
        paddingHorizontal: 24,
    },
    sectionTitle: {
        fontSize: 24,
        fontWeight: '600',
        color: Colors.black,
    },
    sectionDescription: {
        marginTop: 8,
        fontSize: 18,
        fontWeight: '400',
        color: Colors.dark,
    },
    highlight: {
        fontWeight: '700',
    },
    footer: {
        color: Colors.dark,
        fontSize: 12,
        fontWeight: '600',
        padding: 4,
        paddingRight: 12,
        textAlign: 'right',
    },
});

export default App;
