function onSelectedChange() {
    let selected = document.getElementById("selected").value;
    document.getElementById("measurements_iframe").src = "http://opengrower.com/measurements/" + selected;
}