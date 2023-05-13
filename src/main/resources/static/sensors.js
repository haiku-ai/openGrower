function onSelectedChange() {
    let selected = document.getElementById("selected").value;
    document.getElementById("measurements_iframe").src = "http://192.168.1.80:8080/measurements/" + selected;

    let jsonList = document.getElementById("measurements_iframe").innerHTML;
    let labels = jsonList.jsonarray.map(function (e) {
        return e.timeStamp;
    });
    let data = jsonList.jsonarray.map(function (e) {
        return e.moisture;
    });

    let ctx = canvas.getContext('2d');
    let config = {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Graph Line',
                data: data,
                backgroundColor: 'rgba(0, 119, 204, 0.3)'
            }]
        }
    };

    let measurements_plot = new Chart(ctx, config);

}