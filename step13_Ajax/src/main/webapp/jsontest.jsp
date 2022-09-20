<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray, org.json.simple.JSONObject, java.util.ArrayList" %>   
<%@ page import="model.domain.Customer" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsontest.jsp</title>
</head>
<body>

<%

	JSONObject obj = new JSONObject();
	
	obj.put("name", "Pankaj Kumar");
	obj.put("age", new Integer(32));
	
	JSONArray cities = new JSONArray();
	cities.add("New York");
	cities.add("Bangalore");
	cities.add("San Francisco");
	
	obj.put("cities", cities);
	
	//["New York","Bangalore","San Francisco"]
	//System.out.println(cities); 
	
	//{"cities":["New York","Bangalore","San Francisco"], "name":"Pankaj Kumar", "age":32}
	//System.out.println(obj); 
%>
<%= obj %>

<br><hr><br>

ArrayList로 구성된 구조를 JSON 포멧으로 변환해 보기 <br>

<%
	ArrayList<String> names = new ArrayList<>();
	names.add("재석");
	names.add("연아");
	names.add("미소");
	names.add("향기");
	
	JSONObject obj1 = new JSONObject();  //하나의 JSON
	obj1.put("n1", names.get(0));
	obj1.put("n2", names.get(1));
	obj1.put("n3", names);
	
	//System.out.println(obj1);  //{"n1":"재석","n2":"연아","n3":["재석","연아","미소","향기"]}
	System.out.println("************"); 
	
	//dto를 json 형식을 변환 후에 key로 value들 활용하는 연습
	JSONObject obj2 = new JSONObject();
	obj2.put("c1", new Customer("user01", 11));
	obj2.put("c2", new Customer("user02", 22));
	//System.out.println(obj2);   //{"c1":Customer [id=user01, pw=11],"c2":Customer [id=user02, pw=22]}
	//System.out.println( ( (Customer)obj2.get("c1") ).getId());//? user01 만 출력


	//사번, 사원명, 급여 로 다수의 직원 정보로 JSON 배열
	JSONObject obj3 = new JSONObject();
	obj3.put("사번", "사원1");
	obj3.put("사원명", "가사원");
	obj3.put("급여", "1000");
	//System.out.println(obj3);

	System.out.println("*** JSON 배열 : 직원들 정보 *********"); 
	JSONArray allEmp = new JSONArray();
	for(int i=0; i < 5 ; i++ ){
		JSONObject obj4 = new JSONObject();
		obj4.put("사번", "사원"+i);
		obj4.put("사원명", "이름"+i);
		obj4.put("급여", 1000+i);
		
		allEmp.add(obj4);
	}
	//[{"사번":"사원0","급여":1000,"사원명":"이름0"},{"사번":"사원1","급여":1001,"사원명":"이름1"},{"사번":"사원2","급여":1002,"사원명":"이름2"},{"사번":"사원3","급여":1003,"사원명":"이름3"},{"사번":"사원4","급여":1004,"사원명":"이름4"}]
	System.out.println(allEmp);
%>
</body>
</html>








