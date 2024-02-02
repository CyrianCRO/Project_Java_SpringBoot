function showLoginForm() {
  document.getElementById('registrationContainer').style.display = 'none';
  document.getElementById('loginContainer').style.display = 'block';
}

function showRegistrationForm() {
  document.getElementById('loginContainer').style.display = 'none';
  document.getElementById('registrationContainer').style.display = 'block';
}

function registerUser() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  fetch('http://localhost:8080/createUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      username: username,
      password: password,
    }),
  })
  .then(response => response.json())
  .then(data => {
    console.log('User created:', data);
    showLoginForm()
  })
  .catch(error => {
    console.error('Error during user registration:', error);
    alert("invalid credentials")
  });
}

function loginUser() {
  const loginUsername = document.getElementById('loginUsername').value;
  const loginPassword = document.getElementById('loginPassword').value;

  fetch('http://localhost:8080/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      username: loginUsername,
      password: loginPassword,
    }),
  })
  .then(response => response.json())
  .then(data => {
    console.log('Login response:', data);
    if(data != null){
     localStorage.setItem('userId', data);
     window.location.href = 'market.html';
    }else{
        alert("invalid credentials");
    }
    // Save user ID to local storage

   //

    // Handle success, e.g., redirect to another page
  })
  .catch(error => {
    console.error('Error during login:', error);

  });
}
