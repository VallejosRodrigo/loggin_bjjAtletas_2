document.addEventListener('DOMContentLoaded', function () {
  // Empty
});

//-----------user login---------------
async function loginEmailPass(){
    let data = {};

    data.email = document.querySelector('#txtEmail').value;
    data.password = document.querySelector('#txtPassword').value;

    try {
        const response = await fetch('login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const respuesta = await response.text();
        console.log(respuesta)
        console.log("holalaa")

        if(respuesta != 'FAIL'){
            localStorage.setItem('token', respuesta);
            localStorage.setItem('email', data.email);
            window.location.href = 'registered_athletes.html';
        }else{
            alert('Records do not match, please enter your details correctly');
            location.reload();
        }

    }catch (error) {
        console.error('Error during loggin:', error);
        alert('Error during Loggin');
    }




}