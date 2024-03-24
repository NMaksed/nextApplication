import { useState } from "react";
import { Button, StyleSheet, View } from "react-native";
import { CampoTexto } from "../../../components/CampoTexto";

export function CadastroAluno() {
  const [nome, setNome] = useState();
  const [rg, setRg] = useState();
  const [cpf, setCpf] = useState();
  const [cep, setCep] = useState();
  const [email, setEmail] = useState();
  const [dataNascimento, setDataNascimento] = useState();
  const [telefone, setTelefone] = useState();


  const salvar = () => {
    if (nome.trim() != "" && rg.trim() != "") {
      const form = {nome, rg}
      fetchSalvar(form);
    }
  }

  const fetchSalvar = (form) => {
    
  }


  return (
    <View style={styles.container}>
      <View style={styles.centeredView}>
        <CampoTexto
          value={nome}
          placeholder="Nome"
          onChangeText={setNome}
        />
        <CampoTexto
          value={rg}
          placeholder="RG"
          onChangeText={setRg}
        />

        <Button
          onPress={salvar}
          title="Teste"
          color="#e54360"
        />
      </View>
    </View>
  )

}

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