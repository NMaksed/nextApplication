import { useNavigation } from "@react-navigation/native";
import React from "react";
import { View, Text, Alert, Button, TextInput, StyleSheet } from "react-native";
import { CampoTexto } from "../../components/CampoTexto";
import NextSvg from "../../assets/Next-Logo.svg"
import { Logar } from "../../services/Login/LoginService";


export function Login() {
  const navigation = useNavigation();

  const [email, onChangeEmail] = React.useState("");
  const [senha, onChangeSenha] = React.useState("");


  return (
    <View id="container" style={styles.container}>

      <NextSvg width={80} height={80} style={{ marginBottom: 100 }} />

      <View style={styles.centeredView}>
        <View style={{ width: "80%", marginBottom: 50 }}>
          <CampoTexto
            value={email}
            onChangeText={onChangeEmail}
            placeholder="Email"
          />
          <CampoTexto
            value={senha}
            onChangeText={onChangeSenha}
            placeholder="Senha"
          />
        </View>

        <Button
          onPress={login}
          title="Teste"
          color="#e54360"
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    width: "100vw",
    height: "100vh",
  },
  titulo: {
    marginBottom: 100,
    backgroundColor: "red"
  },
  centeredView: {
    width: "100%",
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    paddingBottom: 100,
  },
  input: {
    width: '80%',
  },
});