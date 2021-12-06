$('.card-quantity').each(function () {
    var $this = $(this),
        qty = Number($this.attr('min'))
    var x = qty
    $('.pay-btn').click(function () {
        x += 1
        $this.attr('value', x).val(x)
        if (x >= 1){
            $('.card-quantity').css({
                "visibility": "visible",
            })
        }
        if( x === ""){
            $('.card-quantity').css({
                "visibility": "hidden"
            })
        }
    })
})

$('.pay-btn').click(function(){
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
})

function easeInOutCubic(t, b, c, d) {
    t /= d / 2;
    if (t < 1) return c / 2 * t * t * t + b;
    t -= 2;
    return c / 2 * (t * t * t + 2) + b;
};

