function onSelectedChange() {
    let selected = document.getElementById("selected").value;
    document.getElementById("measurements_iframe").src = "http://opengrower.com:8080/measurements/" + selected;
}