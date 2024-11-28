let selectedRole = '';

function selectRole(role) {
    selectedRole = role;
    
    const teacherButton = document.getElementById('teacherButton');
    const studentButton = document.getElementById('studentButton');

    // Reset styles
    teacherButton.classList.remove('selected');
    studentButton.classList.remove('selected');

    // Apply selected style
    if (role === 'TEACHER') {
        teacherButton.classList.add('selected');
    } else if (role === 'STUDENT') {
        studentButton.classList.add('selected');
    }
}

function saveRole() {
	
}
