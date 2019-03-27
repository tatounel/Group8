/**
 * 
 */

/* The function */

function json2table(json, classes, columns) {
  var cols = Object.keys(json[0]);
  var headerCols = columns || cols;
  var headerRow = '';
  var bodyRows = '';

  classes = classes || '';


  function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
  }

  headerCols.map(function(col) {
    headerRow += '<th>' + capitalizeFirstLetter(col) + '</th>';
  });

  json.map(function(row) {
    bodyRows += '<tr>';

    cols.map(function(colName) {
      bodyRows += '<td>' + row[colName] + '</td>';
    })

    bodyRows += '</tr>';
  });

  return '<table class="' +
         classes +
         '"><thead><tr>' +
         headerRow +
         '</tr></thead><tbody>' +
         bodyRows +
         '</tbody></table>';
}


var columns = [
  "Borough", "Type of Delay", "Bus Company", "Bus No.", "Breakdown ID", "Informed On", "Schools Notified?",
  "OPT Notified?", "Parents Notified?", "Occured On","Created On", "No. of Students on Bus", "Last Updated",  "Reason", "Route No.",
  "Run Type", "Student Ages", "School Year", "Schools Serviced"
];

$.ajax({
    url: "https://data.cityofnewyork.us/resource/fbkk-fqs7.json",
    type: "GET",
    data: {
      "$limit" : 100,
      "$$app_token" : "QejR35CScDS2tj2VMYoCEknu5"
    }
}).done(function(data) {
  alert("Retrieved " + data.length + " records from the dataset!");
  console.log(data);
  document.getElementById('tableGoesHere').innerHTML = json2table(data, 'table', columns);
});
