<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/sampleForm.jsp</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/03/parameterProcess.do" method="get">
<ul>
	<li>
		<input type="text" name="textParam" placeholder="텍스트"/>
	</li>
	<li>
		<input type="number" name="numParam" placeholder="숫자"/>
	</li>
	<li>
		<input type="radio" name="radioParam" value="radio1"/>R1
		<input type="radio" name="radioParam" value="radio2"/>R2
	</li>
	<li>
		<input type="checkbox" name="chkParam" value="check1"/>C1
		<input type="checkbox" name="chkParam" value="check2"/>C2
		<label>
		<input type="checkbox" name="chkParam" value="check3"/>C3
		</label>
	</li>
	<li>
		<select name="sltParam">
			<option>선택</option>
			<option value="option1">option1</option>
			<option>option2</option>
		</select>
	</li>
	<li>
		<select name="multiParam" multiple>
			<option>LIST1</option>
			<option>LIST2</option>
			<option>LIST3</option>
		</select>
	</li>
	<li>
		<input type="submit" value="전송"/>
	</li>
</ul>
</form>
</body>
</html>