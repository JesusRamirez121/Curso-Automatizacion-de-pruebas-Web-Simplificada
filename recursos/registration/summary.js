document.addEventListener('DOMContentLoaded', function() {
    try {
        const userDataString = localStorage.getItem('userData');
        if (!userDataString) {
            alert('No hay datos de registro. Redirigiendo al formulario.');
            window.location.href = 'register.html';
            return;
        }
        const userData = JSON.parse(userDataString);
        if (userData) {
            document.getElementById('summary-name').textContent = userData.name || '';
            document.getElementById('summary-lastname').textContent = userData.lastName || '';
            document.getElementById('summary-age').textContent = userData.age || '';
            document.getElementById('summary-country').textContent = userData.country || '';
            document.getElementById('summary-sex').textContent = userData.sex || '';
            document.getElementById('summary-email').textContent = userData.email || '';
            document.getElementById('summary-workingdays').textContent = userData.workingDays ? userData.workingDays.join(', ') : '';
            if (userData.pictureData) {
                document.getElementById('summary-picture').src = userData.pictureData;
            }
        }
    } catch (error) {
        console.error('Error al cargar los datos:', error);
        alert('Error al cargar los datos. Redirigiendo al formulario.');
        window.location.href = 'register.html';
    }
});