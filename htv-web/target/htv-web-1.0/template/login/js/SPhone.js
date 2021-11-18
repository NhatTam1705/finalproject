var passIMG = '<img id="correctips" src="/htv-web/template/img/register/icons_right.png" border="0" align="absmiddle"/>'

//Check Pass
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

//Register
function checkRegisterForm() {
    var form = document.registerInfoForm
    var errorMessage = ''
    var staticCheckPass = true

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

    //Password
    if ((errorMessage = isValidPassword(form['registerVO.password'].value)) != '') {
        document.getElementById('spanpwdinfo').innerHTML = errorMessage;
        staticCheckPass = false;
    }
    return staticCheckPass
}

var formResubmitFlag = false;
function isFormResubmit() {
    if (formResubmitFlag == true)
        return false;
    else {
        formResubmitFlag = true;
        return true;
    }
}

function userRegister() {
    if (!checkRegisterForm())
        return
    if (isFormResubmit()) {
        document.registerInfoForm.method.value = "doRegister";
		document.registerInfoForm.submit();
    }
}