$(document).ready(function() {
   //empty
});

//-----------add users---------------
async function addUser(){
    let data = {};

    data.first_name = document.querySelector('#txtFirstName').value;
    data.last_name = document.querySelector('#txtLastName').value;
    data.email = document.querySelector('#txtEmail').value;
    data.password = document.querySelector('#txtPassword').value;
    data.dni = document.querySelector('#txtDni').value;
    data.birthdate = document.querySelector('#txtbirthdate').value;
    data.nationality = document.querySelector('#txtNationality').value;
    data.province = document.querySelector('#txtProvince').value;
    data.city = document.querySelector('#txtCity').value;
    data.gender = document.querySelector('#txtGender').value;
    data.modality = document.querySelector('#txtModality').value;
    data.belt = document.querySelector('#txtBelt').value;
    data.degrees = document.querySelector('#txtDegrees').value;
    data.category_age = document.querySelector('#txtCategoryAge').value;
    data.category_weight = document.querySelector('#txtCategoryWeight').value;
    data.academy = document.querySelector('#txtAcademy').value;

    let confirm_password = document.querySelector('#txtPasswordConfirm').value;

    if(data.password != confirm_password){
        alert('Passwords do not match!');
        return;
    }

    if(data.province == null){
        data.province = "-";
    }
    if(data.city == null){
        data.city = "-";
    }
    if(data.degrees == null){
        data.degrees = "-";
    }

    for(let athlete of data){
        if(athlete == null){
            alert('Empty fields are not allowed');
            return;
        }
    }

  const request = await fetch('usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)        //esto se usa para convertir el objeto datos a una cadena de JSON
  });

}
