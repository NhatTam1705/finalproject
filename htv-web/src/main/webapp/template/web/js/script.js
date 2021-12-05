//Menu bar
$('.btn-menu').click(function () {
    $('.nav-item').toggleClass('nav-item-show')
    $('.nav-item').addClass('trans__li')
    $('.nav-item').show()
    $('.subnav').removeClass('show-subnav')
})

$(window).bind("resize", function () {
    if ($(this).width() > '1024') {
        $('li').removeClass('nav-item-show')
        $('.nav-item').show()
        $('.nav-icon-angle').removeClass('rotate-angle__180')
        $('.subnav').removeClass('show-subnav')
    }
})

var nav = document.getElementById('header')
let lastScrollY = window.scrollY;
window.addEventListener("scroll", () => {
    if (lastScrollY < window.scrollY) {
        nav.classList.add('header-hidden');
    } else {
        nav.classList.remove('header-hidden');
    }
    lastScrollY = window.scrollY;
});

//nav-product-hide
$('.nav-item__up').click(function () {
    if (innerWidth < '1024') {
        $('.nav-item__hide').slideToggle()
        $('.subnav').toggleClass('show-subnav')
        $('.nav-icon-angle').toggleClass('rotate-angle__180')
        $('li').removeClass('trans__li')
    }
})


const htvNavBar = document.getElementById('htv-navbar')
const navRight = document.querySelector('.nav-right')
const showSearchBox = document.querySelector('.icon-search')
const navSearch = document.querySelector('.nav-search')
const hideSearchBox = document.querySelector('.nav-search-btn-close')
var screenWidth = "767"

$(window).bind("resize", function () {
    if ($(this).width() <= screenWidth) {
        $('nav').removeClass('htv-navbar__state')
        $('div').removeClass('nav-search__state')
        $('div').removeClass('nav-right__state')
    }
})

showSearchBox.addEventListener('click', () => {
    if (screenWidth < innerWidth) {
        navRight.classList.add('nav-right__state')
        navSearch.classList.add('nav-search__state')
        htvNavBar.classList.add('htv-navbar__state')
    }
})


hideSearchBox.addEventListener('click', () => {
    if (screenWidth < innerWidth) {
        navRight.classList.remove('nav-right__state')
        navSearch.classList.remove('nav-search__state')
        htvNavBar.classList.remove('htv-navbar__state')
    }
})

const slider = document.querySelector(".slider");
const nextBtn = document.querySelector(".next-btn");
const prevBtn = document.querySelector(".prev-btn");
const slides = document.querySelectorAll(".slide");
const slideIcons = document.querySelectorAll(".slide-icon");
const numberOfSlides = slides.length;
var slideNumber = 0;

//image slider next button
nextBtn.addEventListener("click", () => {
    slides.forEach((slide) => {
        slide.classList.remove("active");
    });
    slideIcons.forEach((slideIcon) => {
        slideIcon.classList.remove("active");
    });

    slideNumber++;

    if (slideNumber > (numberOfSlides - 1)) {
        slideNumber = 0;
    }

    slides[slideNumber].classList.add("active");
    slideIcons[slideNumber].classList.add("active");
});

//image slider previous button
prevBtn.addEventListener("click", () => {
    slides.forEach((slide) => {
        slide.classList.remove("active");
    });
    slideIcons.forEach((slideIcon) => {
        slideIcon.classList.remove("active");
    });

    slideNumber--;

    if (slideNumber < 0) {
        slideNumber = numberOfSlides - 1;
    }

    slides[slideNumber].classList.add("active");
    slideIcons[slideNumber].classList.add("active");
});

//image slider autoplay
var playSlider;

var repeater = () => {
    playSlider = setInterval(function () {
        slides.forEach((slide) => {
            slide.classList.remove("active");
        });
        slideIcons.forEach((slideIcon) => {
            slideIcon.classList.remove("active");
        });

        slideNumber++;

        if (slideNumber > (numberOfSlides - 1)) {
            slideNumber = 0;
        }

        slides[slideNumber].classList.add("active");
        slideIcons[slideNumber].classList.add("active");
    }, 4000);
}
repeater();

//stop the image slider autoplay on mouseover
slider.addEventListener("mouseover", () => {
    clearInterval(playSlider);
});

//start the image slider autoplay again on mouseout
slider.addEventListener("mouseout", () => {
    repeater();
});


window.addEventListener("scroll", scrollFunction);

function scrollFunction() {
    if (window.pageYOffset > 300) { // Show backToTopButton
        if (!backToTopButton.classList.contains("btnEntrance")) {
            backToTopButton.classList.remove("btnExit");
            backToTopButton.classList.add("btnEntrance");
            backToTopButton.style.display = "block";
        }
    } else { // Hide backToTopButton
        if (backToTopButton.classList.contains("btnEntrance")) {
            backToTopButton.classList.remove("btnEntrance");
            backToTopButton.classList.add("btnExit");
            setTimeout(function () {
                backToTopButton.style.display = "none";
            }, 250);
        }
    }
}

const backToTopButton = document.querySelector("#back-to-top-btn");
backToTopButton.addEventListener("click", () => {
    const targetPosition = 0;
    const startPosition = window.pageYOffset;
    const distance = targetPosition - startPosition;
    const duration = 750;
    let start = null;

    window.requestAnimationFrame(step);

    function step(timestamp) {
        if (!start) start = timestamp;
        const progress = timestamp - start;
        window.scrollTo(0, easeInOutCubic(progress, startPosition, distance, duration));
        if (progress < duration) window.requestAnimationFrame(step);
    }
});

function easeInOutCubic(t, b, c, d) {
    t /= d / 2;
    if (t < 1) return c / 2 * t * t * t + b;
    t -= 2;
    return c / 2 * (t * t * t + 2) + b;
};

const setTheme = (theme) => (document.documentElement.className = theme);

const themeLight = document.querySelector('.theme-light')
const themeDark = document.querySelector('.theme-dark')
const iconDark = document.querySelectorAll('.icon-font')