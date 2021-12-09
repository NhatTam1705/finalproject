var passIMG = '<img id="correctips" src="/template/img/register/icons_right.png" border="0" align="absmiddle"/>'

//Check User
function isValidUid(uid) {
    $('#spanuinfo').removeAttr('title')
    if (isEmpty(uid))
        return 'User Id cannot is empty.'
    if (uid.length > 50)
        return 'User Id cannot exceed 50 characters.'
    return ''
}

function checkAccount() {
    document.getElementById('spanuinfo').innerHTML = ''
    var uid = document.getElementById('registerVO.userId').value
    var errorMessage = isValidUid(uid)
    if (errorMessage != '')
        document.getElementById('spanuinfo').innerHTML = errorMessage
    else
        document.getElementById('spanuinfo').innerHTML = passIMG
}

//Check Email
function isValidEmail(email) {
    if (isEmpty(email))
        return 'Email cannot be empty'
    if (email.length > 100)
        return 'Email Address cannot exceed 100 characters.'
    var exmail = /^[a-zA-Z0-9_\.\-\']+@([a-zA-Z0-9_\-]+\.)+([a-zA-Z0-9]{2,4})+$/
    if (!exmail.test(email))
        return 'Invalid email address format.'
    return ''
}

function checkEmail() {
    document.getElementById('spanmailinfo').innerHTML = ''
    var email = document.getElementById('registerVO.email').value
    emailTrim = document.getElementById('registerVO.email').value = $.trim(email)
    email = emailTrim
    var errorMessage = isValidEmail(email)
    if (errorMessage != '')
        document.getElementById('spanmailinfo').innerHTML = errorMessage
    else document.getElementById('spanmailinfo').innerHTML = passIMG
}

//Check Password 
// function isValidPassword(uid, pwd) {
//     var email = document.getElementById('registerVO.email').value
//     if (isEmpty(pwd))
//         return 'Password cannot be empty.'
//     if (pwd.length != trim(pwd).length)
//         return 'Password cannot start or end white a space.'
//     if (isContainChinese(pwd))
//         return 'Password cannot contain Chinese or other multi-byte characters.'
//     if (pwd.length < 8)
//         return 'Password must contain at least 8 characters.'
//     if (pwd.length > 60)
//         return 'Password cannot exceed 60 characters.'
//     if (!isEmpty(email) && ((document.getElementById("registerVO.password").value).toLowerCase()) == ((document.getElementById("registerVO.email").value).toLowerCase()))
//         return 'Your password and email address cannot be the same.'
//     var pwdRevert = pwd.split('').reverse().join('')
//     if (!isEmpty(uid) && ((pwdRevert).toLowerCase()) == (uid.toLowerCase()))
//         return 'The new password cannot contain the email address or account in reverse order.';
//     if (!isEmpty(email) && ((pwdRevert).toLowerCase()) == (email.toLowerCase()))
//         return 'The new password cannot contain the email address or account in reverse order.';
//     return ''
// }

// function checkPassword() {
//     document.getElementById('spanpwdinfo').innerHTML = ''
//     var uid = document.getElementById('registerVO.userId').value
//     var pwd = document.getElementById('registerVO.password').value
//     var errorMessage = isValidPassword(uid, pwd)
//     if (errorMessage != '')
//         document.getElementById('spanpwdinfo').innerHTML = errorMessage
//     else document.getElementById('spanpwdinfo').innerHTML = passIMG
// }

function isValidPassword(pwd) {
    if (isEmpty(pwd))
        return 'Password cannot be empty.'
    if (pwd.length != trim(pwd).length)
        return 'Password cannot start or end white a space.'
    if (isContainChinese(pwd))
        return 'Password cannot contain Chinese or other multi-byte characters.'
    if (pwd.length < 8)
        return 'Password must contain at least 8 characters.'
    if (pwd.length > 60)
        return 'Password cannot exceed 60 characters.'
    return ''
}

function checkPassword() {
    document.getElementById('spanpwdinfo').innerHTML = ''
    var pwd = document.getElementById('registerVO.password').value
    var errorMessage = isValidPassword(pwd)
    if (errorMessage != '')
        document.getElementById('spanpwdinfo').innerHTML = errorMessage
    else document.getElementById('spanpwdinfo').innerHTML = passIMG
}


//Last Name
function isValidName(name) {
    if (isEmpty(name))
        return 'Name cannot be empty.'
    if (name.length > 50)
        return 'Name cannot exceed 50 characters.'
    return ''
}

function checkName() {
    document.getElementById('spannameinfo').innerHTML = ''
    var name = document.getElementById('registerVO.name').value
    var errorMessage = isValidName(name)
    if (errorMessage != '')
        document.getElementById('spannameinfo').innerHTML = errorMessage
    else
        document.getElementById('spannameinfo').innerHTML = passIMG
}

function toAgree(obj) {
    if (obj.checked)
        document.getElementById("regbtn").disabled = false;
    else document.getElementById("regbtn").disabled = true;
}

//Register
function checkRegisterForm() {
    var form = document.registerInfoForm
    var errorMessage = ''
    var staticCheckPass = true

    //User Id
    // if ((errorMessage = isValidUid(form['registerVO.userId'].value)) != '') {
    //     document.getElementById('spanuinfo').innerHTML = errorMessage;
    //     staticCheckPass = false;
    // }

    //Email
    if ((errorMessage = isValidEmail(form['registerVO.email'].value)) != '') {
        document.getElementById('spanmailinfo').innerHTML = errorMessage;
        staticCheckPass = false;
    }

    //Password
    // if ((errorMessage = isValidPassword(form['registerVO.userId'].value, form['registerVO.password'].value)) != '') {
    //     document.getElementById('spanpwdinfo').innerHTML = errorMessage;
    //     staticCheckPass = false;
    // }
    if ((errorMessage = isValidPassword(form['registerVO.password'].value)) != '') {
        document.getElementById('spanpwdinfo').innerHTML = errorMessage;
        staticCheckPass = false;
    }

    //Name
    if ((errorMessage = isValidName(form['registerVO.name'].value)) != '') {
        document.getElementById('spannameinfo').innerHTML = errorMessage
        staticCheckPass = false
    }

    //phone
    if ((errorMessage = isValidPhone(form['registerVO.phone'].value)) != '') {
        document.getElementById('spanphoneinfo').innerHTML = errorMessage
        staticCheckPass = false
    }

    //SMS
    if ((errorMessage = isValidSMS(form['registerVO.sms'].value)) != '') {
        document.getElementById('spansmsinfo').innerHTML = errorMessage
        staticCheckPass = false;
    }
    return staticCheckPass
}