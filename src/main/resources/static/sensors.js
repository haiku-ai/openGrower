document.getElementById("sensors").onchange(function(){
    let selected = document.getElementById("selected").valueOf();
    document.getElementById("measurements").src = "http://opengrower.com/measurements/" + selected;
});