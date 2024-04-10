document.addEventListener('DOMContentLoaded', function () {
  // Code to run when the DOM is ready
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

    if(data.province == ''){
        data.province = '-';
    }
    if(data.city == ''){
        data.city = '-';
    }
    if(data.degrees == ''){
        data.degrees = '-';
    }


if (!validateData(data)) {
    return;
}


 try {
     const response = await fetch('athletes', {
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

     alert('Successfully registered!');
     window.location.href = 'login.html';

 }catch (error) {
    console.error('Error during registration:', error);
    alert('An error occurred during registration. Please try again later.');
 }

}

function validateData(data) {
    let emptyFields = [];

    for (let key in data) {
        if (data.hasOwnProperty(key) && (data[key] === null || data[key] === undefined || data[key] === '')) {
            emptyFields.push(key);
        }
    }

    if (emptyFields.length > 0) {
        alert('The following fields must be completed: ' + emptyFields.join(', '));
        return false;
    }

    return true;
}
