import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { Feather } from "@expo/vector-icons";
import { HomeScreen } from "../screens/Home/HomeScreen";

const Tab = createBottomTabNavigator();

export default function TabRouter() {
  return(
    <Tab.Navigator screenOptions={{ headerShown: false}}>
      <Tab.Screen
        name="home"
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
          tabBarIcon: ({ color, size }) => <Feather name="home"  color={color} size={size} />,
          tabBarLabel: "Home",
        }} />
    </Tab.Navigator>
  )
}