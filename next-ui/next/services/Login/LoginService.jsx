

  export const Logar = async (form) => {
    console.log(form)
      const response = (`http://localhost:8080/usuario/`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form),
      })
      return response;
  }