import { createDrawerNavigator } from "@react-navigation/drawer"
import TabRouter from "./tab.router";
import { Feather } from "@expo/vector-icons";
import AlunoTabRouter from "./aluno/aluno.tab.router";

const Drawer = createDrawerNavigator();

export default function DrawerRouter() {

  return(
    <Drawer.Navigator>
      <Drawer.Screen
      name="Aluno"
      component={AlunoTabRouter}
      options={{
        drawerIcon: ({ color, size }) => <Feather name="user"  color={color} size={size} />,
        drawerLabel: "Aluno"
      }}
      />
    </Drawer.Navigator>
  )

}