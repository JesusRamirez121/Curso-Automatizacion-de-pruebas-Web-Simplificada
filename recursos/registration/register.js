document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('save-btn').addEventListener('click', function() {
        console.log('Botón guardar clickeado');
        
        const name = document.getElementById('name').value;
        const lastName = document.getElementById('last-name').value;
        const age = document.getElementById('age').value;
        const country = document.getElementById('country').value;
        const sexElement = document.querySelector('input[name="sex"]:checked');
        const sex = sexElement ? sexElement.value : '';
        const email = document.getElementById('email').value;
        const workingDaysElements = document.querySelectorAll('input[type="checkbox"]:checked');
        const workingDays = Array.from(workingDaysElements).map(el => el.value);
        const pictureFile = document.getElementById('picture').files[0];

        console.log('Datos del formulario:', {
            name, lastName, age, country, sex, email, 
            workingDays: workingDays.length, 
            pictureFile: !!pictureFile
        });

        // Validación más específica
        let errors = [];
        if (!name) errors.push('Nombre');
        if (!lastName) errors.push('Apellido');
        if (!age) errors.push('Edad');
        if (!country) errors.push('País');
        if (!sex) errors.push('Sexo');
        if (!email) errors.push('Email');
        if (workingDays.length === 0) errors.push('Al menos un día laboral');
        if (!pictureFile) errors.push('Foto de perfil');

        if (errors.length === 0) {
            // Comprimir imagen antes de guardar
            const canvas = document.createElement('canvas');
            const ctx = canvas.getContext('2d');
            const img = new Image();
            
            img.onload = function() {
                // Redimensionar imagen a máximo 300x300
                const maxSize = 300;
                let { width, height } = img;
                
                if (width > height) {
                    if (width > maxSize) {
                        height = (height * maxSize) / width;
                        width = maxSize;
                    }
                } else {
                    if (height > maxSize) {
                        width = (width * maxSize) / height;
                        height = maxSize;
                    }
                }
                
                canvas.width = width;
                canvas.height = height;
                ctx.drawImage(img, 0, 0, width, height);
                
                // Convertir a base64 con calidad reducida
                const compressedImage = canvas.toDataURL('image/jpeg', 0.7);
                
                try {
                    const userData = {
                        name,
                        lastName,
                        age,
                        country,
                        sex,
                        email,
                        workingDays,
                        pictureData: compressedImage
                    };
                    localStorage.setItem('userData', JSON.stringify(userData));
                    window.open('summary.html', '_blank');
                } catch (error) {
                    console.error('Error al guardar datos:', error);
                    document.getElementById('alert-container').innerHTML = `
                        <div class="alert alert-danger" role="alert">
                            La imagen es demasiado grande. Intente con una imagen más pequeña.
                        </div>
                    `;
                }
            };
            
            img.onerror = function() {
                document.getElementById('alert-container').innerHTML = `
                    <div class="alert alert-danger" role="alert">
                        Error al procesar la imagen. Intente con otra imagen.
                    </div>
                `;
            };
            
            const reader = new FileReader();
            reader.onload = function(e) {
                img.src = e.target.result;
            };
            reader.readAsDataURL(pictureFile);
        } else {
            document.getElementById('alert-container').innerHTML = `
                <div class="alert alert-danger" role="alert">
                    Por favor complete los siguientes campos: ${errors.join(', ')}
                </div>
            `;
        }
    });
});
