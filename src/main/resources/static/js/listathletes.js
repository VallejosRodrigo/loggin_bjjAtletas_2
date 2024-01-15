document.addEventListener('DOMContentLoaded', function() {
  listAthletes();
  // Puedes inicializar DataTables aquí si es necesario
});

async function listAthletes(){

  const request = await fetch('regathletes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const athletes = await request.json();

  let listHTML = '';

  for(let athlete of athletes){

    let athleteHTML = '<tr><td>'+
                        athlete.first_name +'</td><td>'+
                        athlete.last_name +'</td><td>'+
                        athlete.birthdate +'</td><td>'+
                        athlete.nationality +'</td><td>'+
                        athlete.gender +'</td><td>'+
                        athlete.belt +'</td><td>'+
                        athlete.category_age +'</td><td>'+
                        athlete.category_weight +'</td><td>'+
                        athlete.academy +'</td><td>'+
                        athlete.degrees +'</td><td>'+
                        athlete.province +'</td><td>'+
                        athlete.city +'</td><td>'+
                        athlete.modality +'</td></tr>';

    listHTML += athleteHTML;
  }

  document.querySelector('#athletestable tbody').outerHTML = listHTML;
}