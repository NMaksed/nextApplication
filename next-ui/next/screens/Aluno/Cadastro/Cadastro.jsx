import { useState } from "react";
import { Button, StyleSheet, View } from "react-native";
import { CampoTexto } from "../../../components/CampoTexto";
import DateTimePicker from '@react-native-community/datetimepicker';

export function CadastroAluno() {
  const [nome, setNome] = useState();
  const [rg, setRg] = useState();
  const [cpf, setCpf] = useState();
  const [cep, setCep] = useState();
  const [email, setEmail] = useState();
  const [dataNascimento, setDataNascimento] = useState();
  const [telefone, setTelefone] = useState();


  const salvar = () => {
    if (nome.trim() != "" || rg.trim() != "" || cpf.trim != null || cep.trim != null) {
      const form = { nome, rg }
      fetchSalvar(form);
    }
  }

  const fetchSalvar = (form) => {
      const response = SalvarAluno(form);
  }

  const limpar = () => {
      setCep('');
      setCpf('');
      setRg('');
      setDataNascimento('')
      setEmail('');
      setNome('')
      setTelefone('')
  }

  return (
    <View style={styles.container}>
      <View style={styles.centeredView}>
        <View style={{ width: "80%", marginBottom: 50, marginTop: 90 }}>
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
        <CampoTexto
          value={cpf}
          placeholder="CPF"
          onChangeText={setCpf}
        />
        <CampoTexto
          value={email}
          placeholder="Email"
          onChangeText={setEmail}
        />
        <CampoTexto
          value={dataNascimento}
          placeholder="yyyy-MM-dd"
          onChangeText={setDataNascimento}
          />
        <CampoTexto
          value={telefone}
          placeholder="Telefone"
          onChangeText={setTelefone}
        />
        <CampoTexto
          value={cep}
          placeholder="CEP"
          onChangeText={setCep}
        />
        <Button
          onPress={salvar}
          title="Salvar"
          color="#e54360"
        />
        <View style={{ marginTop: 20 }}>
        <Button
          onPress={limpar}
          title="Limpar"
          color="#e54360"
        />
        </View>
        </View>
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