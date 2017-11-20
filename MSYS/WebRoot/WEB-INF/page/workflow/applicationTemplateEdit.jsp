<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
	<title>部署流程定义</title>
	<link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
	<script type="text/javascript">
		function saveTemplate(){
			 document.Form1.action="workflow/elecApplicationTemplateAction_update.do";
			 document.Form1.submit();	 		 
			 refreshOpener();
		}
	</script>
</head>
<body>
		<form name="Form1" action="workflow/elecApplicationTemplateAction_update.do" method="post" enctype="multipart/form-data">
			<br>
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<input type="hidden" name="id"/>
				<input type="hidden" name="path"/>
				<tr>
					<td class="ta_01" align="center"
						background="${pageContext.request.contextPath }/images/b-info.gif"
						colspan="4">
						<font face="宋体" size="2"><strong>文档模板信息</strong>
						</font>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="left" bgColor="#ffffff" colspan="4">
						<font face="宋体" size="2">
							说明：<br />
								1，模板文件是doc扩展名的文件（Word文档）。<br />
								2，如果是添加：必须要选择模板文件。<br />
								3，如果是修改：只是在 需要更新模板文件时 才选择一个文件。
						</font>
					</td>
				</tr>
				<tr height=10>
					<td colspan=4></td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">模板名称：<font color="#FF0000">*</font></td>
			        <td class="ta_01" bgColor="#ffffff" colspan="3">
			        	<input type="text" name="name" size="20" value="&#21592;&#24037;&#35831;&#20551;" id="name"/>
			        </td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">所用流程：<font color="#FF0000">*</font></td>
			        <td class="ta_01" bgColor="#ffffff" colspan="3">
			         	<select name="processDefinitionKey" id="processDefinitionKey" style="width:155px">
						    <option value=""></option>
						    <option value="员工请假流程" selected="selected">员工请假流程</option>
						    <option value="费用报销流程">费用报销流程</option>
						</select>
	            	</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">请选择模板文件(doc格式)：<font color="#FF0000">*</font></td>
			        <td class="ta_01" bgColor="#ffffff" colspan="3">
			        	<input type="file" name="upload" style="width:450px;" /> 
			        </td>
				</tr>
				<tr height=50>
					<td colspan=4></td>
				</tr>
				<tr height=2>
					<td colspan=4
						background="${pageContext.request.contextPath }/images/b-info.gif"></td>
				</tr>
				<tr height=10>
					<td colspan=4></td>
				</tr>
				<tr>
					<td align="center" colspan=4>
						<input type="button" name="BT_Submit" value="保存"  style="font-size:12px; color:black; height=22;width=55"   onClick="saveTemplate()">
						<INPUT type="button" name="Reset1" id="save" value="关闭"
							onClick="opener.location.reload(); window.close();"
							style="width: 60px; font-size: 12px; color: black;">
					</td>
				</tr>
			</table>
		</form>

</body>
</html>
	