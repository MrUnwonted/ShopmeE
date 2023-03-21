// Sales Report By Date

var Data;
var chartOptions;

$(document).ready(function (){
    setUpButtonEventHandler("_category",loadSalesReportByDateForCategory);
});

function loadSalesReportByDateForCategory(period){
    if (period == 'custom'){
        startDate = $("#startDate_category").val();
        endDate = $("#endDate_category").val();

        requestURL = contextPath + "reports/category/" + startDate + "/" + endDate;
    } else {
        requestURL = contextPath + "reports/category/" + period;
    }

    $.get(requestURL, function (responseJSON){
        console.log(responseJSON);
        prepareChartDataForReportByDateForCategory(responseJSON);
        customizeChartForReportByCategory();
        formatChartData(data, 1, 2);
        drawChartForReportByCategory(period);
        setSalesAmount(period,'_category', 'Total Products');
    })
}

function prepareChartDataForReportByDateForCategory(responseJSON){
    data = new google.visualization.DataTable();
    data.addColumn('string', 'Category');
    data.addColumn('number', 'Gross Sales');
    data.addColumn('number', 'Net Sales');

    totalGrossSales = 0.0;
    totalNetSales = 0.0;
    totalItems = 0;

    $.each(responseJSON, function (index, reportItem){
        data.addRows([[reportItem.identifier, reportItem.grossSales, reportItem.netSales]]);
        totalGrossSales += parseFloat(reportItem.grossSales);
        totalNetSales += parseFloat(reportItem.netSales);
        totalItems += parseInt(reportItem.productsCount);
    })

}

function customizeChartForReportByCategory(){
    chartOptions = {
        height: 360,
        legend: {
            position: 'right'
        }
    };

}

function drawChartForReportByCategory(){
    var salesChart = new google.visualization.PieChart(document.getElementById('chart_sales_by_category'));
    salesChart.draw(data, chartOptions);


}

