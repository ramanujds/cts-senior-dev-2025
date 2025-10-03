export function saveToken(jwt) {
  sessionStorage.setItem('token', jwt);
}

export function getToken() {
  return sessionStorage.getItem('token');
}

export function clearToken() {
  sessionStorage.removeItem('token');
}

