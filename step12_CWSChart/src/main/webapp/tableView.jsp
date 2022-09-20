<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tableView.jsp</title>
<% System.out.println("tableView Check"); %>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('number', 'bookno');
        data.addColumn('string', 'bookname');
        data.addColumn('string', 'writer');
        data.addColumn('string', 'publisher');
        data.addColumn('number', 'inventory');
        data.addRows(${requestScope.getAllBooks[0]});
          
    	  var table = new google.visualization.Table(document.getElementById('table_div'));
    	  table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
      
      function tableHidden(){
          document.getElementById("table_div").style.display = 'none';
      }
      
    </script>
  </head>

<body>
    <div id="table_div"></div>
    <button onclick="tableHidden()">Table 숨기기</button>
    ${requestScope.getAllBooks};
  </body>

</html>