var ImgShowPass = document.querySelector('.psw-show')
var ImgHidePass = document.querySelector('.psw-hide')
var passWord = document.getElementById('registerVO.password')

ImgShowPass.addEventListener('click', () => {
    ImgHidePass.style.visibility = 'visible'
    ImgShowPass.style.visibility = 'hidden'
    passWord.type = "password"
});

//Hide Pass
ImgHidePass.addEventListener('click', () => {
    ImgShowPass.style.visibility = 'visible'
    ImgHidePass.style.visibility = 'hidden'
    passWord.type = "text"
});