var getURL = function (url, success, error) {
    if (!window.XMLHttpRequest) return;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status !== 200) {
                if (error && typeof error === 'function') {
                    error(request.responseText, request);
                }
                return;
            }
            if (success && typeof success === 'function') {
                success(request.responseText, request);
            }
        }
    };
    request.open('GET', url);
    request.send();
};

getURL(
    '../../views/product/header.html',
    function (data) {
        var el = document.createElement(el);
        el.innerHTML = data;
        var fetch = el.querySelector('#new-header');
        var embed = document.querySelector('#header');
        if (!fetch || !embed) return;
        embed.innerHTML = fetch.innerHTML;
    }
);

// fetch("../../views/product/header.html")
//     .then(response => {
//         return response.text();
//     })
//     .then(data => {
//         document.querySelector("header").innerHTML = data;
//     });