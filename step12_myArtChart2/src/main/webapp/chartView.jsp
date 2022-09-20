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
        data.addColumn('number', 'empno');
        data.addColumn('string', 'ename');
        data.addColumn('string', 'job');
        data.addColumn('number', 'mgr');
        data.addColumn('number', 'hiredate');
        data.addColumn('number', 'sal');
        data.addColumn('number', 'comm');
        data.addColumn('number', 'deptno');
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