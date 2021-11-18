var buttonShowPassNew = document.querySelector('.new-psw-show')
var buttonHidePassNew = document.querySelector('.new-psw-hide')
var buttonShowPassConfirm = document.querySelector('.confirm-psw-show')
var buttonHidePassConfirm = document.querySelector('.confirm-psw-hide')
var passWord = document.querySelectorAll('.pass')

buttonShowPassNew.addEventListener('click', () => {
    buttonHidePassNew.style.visibility = 'visible'
    buttonShowPassNew.style.visibility = 'hidden'
    passWord[1].type = "password"
});
buttonHidePassNew.addEventListener('click', () => {
    buttonShowPassNew.style.visibility = 'visible'
    buttonHidePassNew.style.visibility = 'hidden'
    passWord[1].type = "text"
});

buttonShowPassConfirm.addEventListener('click', () => {
    buttonHidePassConfirm.style.visibility = 'visible'
    buttonShowPassConfirm.style.visibility = 'hidden'
    passWord[2].type = "password"
});
buttonHidePassConfirm.addEventListener('click', () => {
    buttonShowPassConfirm.style.visibility = 'visible'
    buttonHidePassConfirm.style.visibility = 'hidden'
    passWord[2].type = "text"
});

