import { createStackNavigator } from '@react-navigation/stack';
import React from "react";
import { Login } from '../screens/login/Login';


export function LoginStack() {

  const Stack = createStackNavigator();

  return (
    <Stack.Navigator>
      <Stack.Screen
        name="Login"
        component={Login}
        options={{
          title: "Login",
          headerStyle: {
            backgroundColor: "#e54360",
          },
          headerTintColor: "#fff",
          headerTitleStyle: {
            fontWeight: 'bold',
          },
        }} />
    </Stack.Navigator>
  )
}