<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chartView.jsp</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>

  <h3>chart data를 동적으로 구성</h3>

  <br><hr><br>
    
    <button onclick="chartHidden()">chart 숨기기</button>

    <div id="piechart" style="width: 900px; height: 500px;"></div>

    <script type="text/javascript">
        function chartHidden(){
            document.getElementById("piechart").style.display = 'none';
        }

        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);
  
        
        /*  let data = ${requestScope.chartData};
        	1. let data = js 변수(front 변수), 브라우저에서 실행되는 변수
        	2. ${requestScope.chartData} = java 코드(back end), tomcat에서 실행되는 코드
        	
        	3. 결론
        		브라우저는 아마도 이 형식으로 tomcat 즉 server 로 부터 응답
        		let data = [['Task', 'Hours per Day'],['작업', 11], ['Eat',  2],['Commute',  2],['Watch TV', 2],['Sleep', 7]];
        */
        function drawChart() {
          let data = ${requestScope.chartData};
          newData(data);
        }

        function newData(v){
          var data = google.visualization.arrayToDataTable(v);
  
          var options = {
            title: 'My Daily Activities'
          };
  
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options);
        }
    </script>
</body>
</html>