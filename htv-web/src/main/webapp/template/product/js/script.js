$('.card-number').each(function (e) {
    var $this = $(this),
        min = Number($this.attr('min'))
    var x = min
    $('.card-minus').click(function () {
        x -= 1
        $('.card-minus i').css({
            'background-color': '#ccc'
        })
        $('.card-minus').css({
            'pointer-events': 'none'
        })
        $('.card-plus i').css({
            'background-color': '#288AD6'
        })
        $('.card-plus').css({
            'pointer-events': 'all'
        })
        $this.attr('value', x).val(x)
    })
    $('.card-plus').click(function () {
        x += 1
        $('.card-plus i').css({
            'background-color': '#ccc'
        })
        $('.card-plus').css({
            'pointer-events': 'none'
        })
        $('.card-minus i').css({
            'background-color': '#288AD6'
        })
        $('.card-minus').css({
            'pointer-events': 'all'
        })
        $this.attr('value', x).val(x)
    })
})

$('.btn-close').click(function () {
    $('.card-item').slideToggle()
})
