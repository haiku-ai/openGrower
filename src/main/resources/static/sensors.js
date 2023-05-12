function onSelectedChange() {
    let selected = document.getElementById("selected").value;
    document.getElementById("measurements_iframe").src = "http://192.168.1.80:8080/measurements/" + selected;
}