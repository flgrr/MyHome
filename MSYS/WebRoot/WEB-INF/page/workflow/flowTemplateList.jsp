<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>申请模板选择</title>
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
    <script type="text/javascript">
	    function showProcessImage( pdId ){
	    	var url = "${pageContext.request.contextPath}/elecApplicationTemplateAction_downloadProcessImage.do?id=" + pdId;
	    	window.showModalDialog(url, null, "dialogWidth:600px; dialogHeight:500px; resizable:yes;");
        }
    </script> 
</head>
<body>

		<form id="Form1" name="Form1" action="" method="post" style="margin:0px;"> 
			<table cellspacing="1" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
				<TR height=10><td></td></TR>
				<tr>
					<td class="ta_01" colspan=2 align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
						<font face="宋体" size="2"><strong>申请模板选择管理</strong></font>
					</td>
					
				</tr>
		    </table>	
		</form>


		<form id="Form2" name="Form2" action="" method="post">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<TR height=10><td></td></TR>			
				<tr>
				  	<td>
		                <TABLE style="WIDTH: 125px; HEIGHT: 20px" border="0">
							<TR>
								<TD align="center" background="${pageContext.request.contextPath }/images/cotNavGround.gif"><img src="${pageContext.request.contextPath }/images/yin.gif" width="15"></TD>
								<TD class="DropShadow" background="${pageContext.request.contextPath }/images/cotNavGround.gif">请选择申请模板</TD>
							</TR>
			             </TABLE>
                    </td>
				</tr>
				<tr>
				  	<td class="ta_01" align="left" bgColor="#f5fafe" colspan="2">
		                说明：此页面是列出所有的表单模板记录。<br />
                    </td>
				</tr>
				
				<tr>
					<td class="ta_01" align="left" bgColor="#f5fafe" colspan="2">			
						
								
								<img width="16" height="16" src="${pageContext.request.contextPath }/images/doc.gif"/> 
								<a id="Form2_" href="${pageContext.request.contextPath }/workflow/flowSubmitApplication.jsp?applicationTemplateID=1&applicationTemplateName=员工请假">员工请假</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
						
								
								<img width="16" height="16" src="${pageContext.request.contextPath }/images/doc.gif"/> 
								<a id="Form2_" href="${pageContext.request.contextPath }/workflow/flowSubmitApplication.jsp?applicationTemplateID=2&applicationTemplateName=费用报销">费用报销</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
						
					</td>
				</tr>     
			</TBODY>
		</table>
		</form>


</body>
</html>

