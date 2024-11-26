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
/*    if (!selectedRole) {
        alert('성별을 선택해주세요.');
        return;
    }

    const URL = localStorage.getItem('URL');
    const token = localStorage.getItem('Token');

    const payload = {
        Role: selectedRole,
    };

    fetch(`${URL}/api/member/save/Role`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(payload),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error('성별 저장 실패');
            }
            return response.json();
        })
        .then((data) => {
            console.log('성별 저장 성공:', data);
        })
        .catch((error) => {
            console.error(error);
        });*/
}
