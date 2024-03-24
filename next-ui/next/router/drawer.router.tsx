import { createDrawerNavigator } from "@react-navigation/drawer"
import TabRouter from "./tab.router";
import { Feather } from "@expo/vector-icons";

const Drawer = createDrawerNavigator();

export default function DrawerRouter() {

  return(
    <Drawer.Navigator>
      <Drawer.Screen
      name="Home"
      component={TabRouter}
      options={{
        drawerIcon: ({ color, size }) => <Feather name="home"  color={color} size={size} />,
        drawerLabel: "Home"
      }}
      />
    </Drawer.Navigator>
  )

}