document.getElementById("sensors").onchange(function(){
    let selected = document.getElementById("selected").valueOf();
    document.getElementById("measurements_iframe").src = "http://opengrower.com/measurements/" + selected;
});