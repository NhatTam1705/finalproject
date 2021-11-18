var textUser = document.getElementById('text-user');
var textPhone = document.getElementById('text-phone')
var hideTextBoxUser = document.getElementById('textbox-user')
var hideTextBoxNumber = document.getElementById('textbox-number')
var formIdEmail = document.getElementById('form-id-email')
var formMobile = document.getElementById('form-mobile')
let userID = document.querySelector('.user')
let passWord = document.querySelectorAll('.pass')
let phoneNumber = document.querySelector('.phone')

textPhone.addEventListener('click', () => {
    textUser.classList.add('blur-text')
    textUser.classList.remove('unblur-text')
    textPhone.classList.add('unblur-text')
    textPhone.classList.remove('blur-text')
    formMobile.classList.remove('hide-form')
    formIdEmail.classList.add('hide-form')
    userID.value = ''
    passWord[0].value = ''
    message = 'mobile'
    buttonHidePassForm2.style.visibility = 'visible'
    buttonShowPassForm2.style.visibility = 'hidden'
    passWord[1].type = "password"
});


textUser.addEventListener('click', () => {
    textUser.classList.add('unblur-text')
    textUser.classList.remove('blur-text')
    textPhone.classList.add('blur-text')
    textPhone.classList.remove('unblur-text')
    formMobile.classList.add('hide-form')
    formIdEmail.classList.remove('hide-form')
    phoneNumber.value = ''
    passWord[1].value = ''
    message = 'user'
    buttonHidePassForm1.style.visibility = 'visible'
    buttonShowPassForm1.style.visibility = 'hidden'
    passWord[0].type = "password"
});

var buttonShowPassForm1 = document.querySelector('.psw-show-f1')
var buttonHidePassForm1 = document.querySelector('.psw-hide-f1')
var buttonShowPassForm2 = document.querySelector('.psw-show-f2')
var buttonHidePassForm2 = document.querySelector('.psw-hide-f2')

buttonShowPassForm1.addEventListener('click', () => {
    buttonHidePassForm1.style.visibility = 'visible'
    buttonShowPassForm1.style.visibility = 'hidden'
    passWord[0].type = "password"
});
buttonHidePassForm1.addEventListener('click', () => {
    buttonShowPassForm1.style.visibility = 'visible'
    buttonHidePassForm1.style.visibility = 'hidden'
    passWord[0].type = "text"
});

buttonShowPassForm2.addEventListener('click', () => {
    buttonHidePassForm2.style.visibility = 'visible'
    buttonShowPassForm2.style.visibility = 'hidden'
    passWord[1].type = "password"
});
buttonHidePassForm2.addEventListener('click', () => {
    buttonShowPassForm2.style.visibility = 'visible'
    buttonHidePassForm2.style.visibility = 'hidden'
    passWord[1].type = "text"
});