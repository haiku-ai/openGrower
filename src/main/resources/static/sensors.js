let ctx = Chart.helpers.canvas.getContext('2d');
let labels = [];
let data = [];
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

function onSelectedChange() {
    let selected = document.getElementById("selected").value;
    document.getElementById("measurements_iframe").src = "http://192.168.1.80:8080/measurements/" + selected;

    let jsonList = document.getElementById("measurements_iframe").innerHTML;
    console.log(jsonList);
    let labels = jsonList.jsonarray.map(function (e) {
        return e.timeStamp;
    });
    let data = jsonList.jsonarray.map(function (e) {
        return e.moisture;
    });
    console.log(labels);
    console.log(data);

    measurements_plot.labels = labels;
    measurements_plot.data = data;
}