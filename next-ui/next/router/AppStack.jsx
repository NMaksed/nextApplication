import { createStackNavigator } from '@react-navigation/stack';
import React from "react";
import { HomeScreen } from "../screens/Home/HomeScreen";
import { Login } from '../screens/login/Login';
import { ConsultarAluno } from '../screens/Aluno/Consultar/Consultar';


const Stack = createStackNavigator();


export function AppStack() {

  return (
    <Stack.Navigator>
      <Stack.Screen
        name="Home"
        component={HomeScreen}
        options={{
          title: "Home",
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