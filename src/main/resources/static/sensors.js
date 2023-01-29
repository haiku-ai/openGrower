function onSelectedChange() {
    let selected = document.getElementById("selected").valueOf();
    document.getElementById("measurements_iframe").src = "http://opengrower.com/measurements/" + selected;
}