function trim(s) {
    var tempStr;
    tempStr = s.replace(/\s+$/g, '');
    tempStr = tempStr.replace(/^\s+/g, '');
    return tempStr;
}

function isEmpty(s) {
    return ((s == null) || (trim(s).length == 0))
}

function isContainChinese(str) {
    if (str.match(/[^\x00-\xff]/ig))
        return true
    return false
}

//Phone Number
function isValidPhone(phone) {
    if (isEmpty(phone))
        return 'Phone cannot be empty.'
    var str = /^[+]{0}[0-9]{10}$/
    if (!str.test(phone))
        return 'Invalid phone number format.'
    return ''
}

function checkPhone() {
    document.getElementById('spanphoneinfo').innerHTML = ''
    var phone = document.getElementById('registerVO.phone').value
    var errorMessage = isValidPhone(phone)
    if (errorMessage != '')
        document.getElementById('spanphoneinfo').innerHTML = errorMessage
    else document.getElementById('spanphoneinfo').innerHTML = passIMG
}

//Check SMS
function isValidSMS(sms) {
    if (isEmpty(sms))
        return 'SMS cannot be empty'
    return ''
}

function checkSMS() {
    document.getElementById('spansmsinfo').innerHTML = ''
    var sms = document.getElementById('registerVO.sms').value
    var errorMessage = isValidSMS(sms)
    if (errorMessage != '')
        document.getElementById('spansmsinfo').innerHTML = errorMessage
    else document.getElementById('spansmsinfo').innerHTML = passIMG
}

//Register common
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
