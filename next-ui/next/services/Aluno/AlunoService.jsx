

async function SalvarAluno(data){
  try{
    const response = await fetch("http://localhost/aluno/salvar", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data)
    });
    if (response.ok) {
      throw new Error("Problema ao acessar servidor!");
    }

    const responseData = await response.json();
    console.log(responseData)
  } catch (error) {
    console.log("Erro na operação!");
  }
}