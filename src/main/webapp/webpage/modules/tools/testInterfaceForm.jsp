<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>接口管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
		});
	</script>
</head>
<body>
		<form:form id="inputForm" modelAttribute="testInterface" action="${ctx}/tools/testInterface/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">接口名称：</label></td>
					<td class="width-35">
						<form:input path="name" htmlEscape="false" maxlength="1024" class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">接口类型：</label></td>
					<td class="width-35">
						<form:select path="type" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('interface_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">请求URL：</label></td>
					<td class="width-35">
						<form:input path="url" htmlEscape="false" maxlength="256" class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">请求body：</label></td>
					<td class="width-35">
						<form:input path="body" htmlEscape="false" maxlength="2048" class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">成功时返回消息：</label></td>
					<td class="width-35">
						<form:input path="successmsg" htmlEscape="false" maxlength="512" class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">失败时返回消息：</label></td>
					<td class="width-35">
						<form:input path="errormsg" htmlEscape="false" maxlength="512" class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注：</label></td>
					<td class="width-35">
						<form:textarea path="comment" htmlEscape="false" maxlength="512" class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>