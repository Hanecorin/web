<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chartView.jsp</title>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('number', 'Salary');
        data.addColumn('boolean', 'Full Time Employee');
        data.addRows(${requestScope.tableData});
    	  
    	  var table = new google.visualization.Table(document.getElementById('table'));
    	  table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
      
      function tableHidden(){
          document.getElementById("table").style.display = 'none';
      }
      
    </script>
  </head>

<body>
    <div id="table"></div>
    <button onclick="tableHidden()">Table 숨기기</button>
  </body>

</html>