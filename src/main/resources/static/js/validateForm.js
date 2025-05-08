
function validateForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var passwordPattern = /^(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/;

    if (username.length < 5) {
        document.getElementById("usernameError").textContent = "Username must be at least 5 characters long.";
        return false;
    }
    if (password.length < 8 || !passwordPattern.test(password)) {
        document.getElementById("passwordError").textContent = "Password must contain at least 8 characters, including one capital letter and one special character (!@#$%^&*)";
        return false;
    }
    return true;

}

function Hour12Time(militaryTime) {

    const [hours, minutes] = militaryTime.split(':').map(Number);
    const isPM = hours >= 12;
    const hours12 = hours % 12 || 12;
    const time12 = `${hours12}:${minutes.toString().padStart(2, '0')} ${isPM ? 'PM' : 'AM'}`;
    return time12;
}


