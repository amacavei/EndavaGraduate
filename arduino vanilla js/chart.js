window.onload = function () {

  $(function() {
  $('#toggle-event').change(function() {
    var checked = $(this).prop('checked');
    if (!checked) {

		var dps = []; // dataPoints

		var chart = new CanvasJS.Chart("chartContainer",{
			title :{
				text: "Output Voltage"
			},
			data: [{
				type: "line",
				dataPoints: dps
			}]
		});

		var xVal = 0;
		var yVal = 100;
		var updateInterval = 100;
		var dataLength = 500; // number of dataPoints visible at any point

		var updateChart = function (count) {
			count = count || 1;
			// count is number of times loop runs to generate random dataPoints.

			for (var j = 0; j < count; j++) {
				yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
				dps.push({
					x: xVal,
					y: yVal
				});
				xVal++;
			};
			if (dps.length > dataLength)
			{
				dps.shift();
			}

			chart.render();

		};


		// generates first set of dataPoints
		updateChart(dataLength);

		// update chart after specified time.
		setInterval(function(){updateChart()}, updateInterval);


    var chartWind = new CanvasJS.Chart("chartContainerWind",{
			title :{
				text: "Wind Speed"
			},
			data: [{
				type: "line",
				dataPoints: dps
			}]
		});

		var xVal = 0;
		var yVal = 100;
		var updateInterval = 100;
		var dataLength = 500; // number of dataPoints visible at any point

		var updateChartWind = function (count) {
			count = count || 1;
			// count is number of times loop runs to generate random dataPoints.

			for (var j = 0; j < count; j++) {
				yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
				dps.push({
					x: xVal,
					y: yVal
				});
				xVal++;
			};
			if (dps.length > dataLength)
			{
				dps.shift();
			}

			chart.render();

		};


		// generates first set of dataPoints
		updateChartWind(dataLength);

		// update chart after specified time.
		setInterval(function(){updateChart()}, updateInterval);

    var chartGear = new CanvasJS.Chart("chartContainerGear",{
			title :{
				text: "Wind Speed"
			},
			data: [{
				type: "line",
				dataPoints: dps
			}]
		});

		var xVal = 0;
		var yVal = 100;
		var updateInterval = 100;
		var dataLength = 500; // number of dataPoints visible at any point

		var updateChartGear = function (count) {
			count = count || 1;
			// count is number of times loop runs to generate random dataPoints.

			for (var j = 0; j < count; j++) {
				yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
				dps.push({
					x: xVal,
					y: yVal
				});
				xVal++;
			};
			if (dps.length > dataLength)
			{
				dps.shift();
			}

			chart.render();

		};


		// generates first set of dataPoints
		updateChartGear(dataLength);

		// update chart after specified time.
		setInterval(function(){updateChart()}, updateInterval);
  }

})
})
}
