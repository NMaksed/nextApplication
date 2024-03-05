import * as React from 'react';
import { View, Text } from 'react-native';
import NextSvg from "../../assets/Next-Logo.svg"

export function HomeScreen() {
    return (
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Text>Home Screen...</Text>
        <NextSvg height={40} width={40}/>
      </View>
    );
  }