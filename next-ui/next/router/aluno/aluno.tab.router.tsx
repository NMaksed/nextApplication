import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { Feather } from "@expo/vector-icons";
import { HomeScreen } from "../../screens/Home/HomeScreen";
import { ConsultarAluno } from "../../screens/Aluno/Consultar/Consultar";
import { CadastroAluno } from "../../screens/Aluno/Cadastro/Cadastro";

const Tab = createBottomTabNavigator();

export default function AlunoTabRouter() {
  return (
    <Tab.Navigator screenOptions={{ headerShown: false }}>
      <Tab.Screen
        name="Cadastro"
        component={CadastroAluno}
        options={{
          title: "Cadastro",
          headerStyle: {
            backgroundColor: "#e54360",
          },
          headerTintColor: "#fff",
          headerTitleStyle: {
            fontWeight: 'bold',
          },
          tabBarIcon: ({ color, size }) => <Feather name="plus" color={color} size={size} />,
          tabBarLabel: "Cadastro",
        }} />
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
          tabBarIcon: ({ color, size }) => <Feather name="home" color={color} size={size} />,
          tabBarLabel: "Home",
        }} />
      <Tab.Screen
        name="Consulta"
        component={ConsultarAluno}
        options={{
          title: "Consulta",
          headerStyle: {
            backgroundColor: "#e54360",
          },
          headerTintColor: "#fff",
          headerTitleStyle: {
            fontWeight: 'bold',
          },
          tabBarIcon: ({ color, size }) => <Feather name="list" color={color} size={size} />,
          tabBarLabel: "Consulta",
        }} />
    </Tab.Navigator>
  )
}