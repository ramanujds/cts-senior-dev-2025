export async function signup(username, password) {
    const role = 'USER'
    const response = await fetch('http://localhost:8080/auth', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password, role}),
    });
    return response.json();
}

export async function login(username, password) {
    const response = await fetch('http://localhost:8080/auth/authenticate', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password}),
    });
    if (!response.ok) throw new Error('Login failed');
    return response.json();
}


