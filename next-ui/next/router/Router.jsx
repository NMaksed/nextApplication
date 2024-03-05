
import React from "react"
import { NavigationContainer } from "@react-navigation/native";
import { AppStack } from "./AppStack";
import { Login } from "../screens/login/Login";
import { HomeScreen } from "../screens/Home/HomeScreen";
import { LoginStack } from "./LoginStack";

export function Router() {

    const auth = false;

    return (
        <NavigationContainer>
            {auth ? <Login /> : <LoginStack />}
        </NavigationContainer>
    )
}