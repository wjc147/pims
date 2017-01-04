<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
     #f{
          text-align: center;
          margin-top:300px;
          color:white;
        
     }
 


</style>
<script type="text/javascript">
    function checkUser(va){
            if(va==""){
                document.getElementById("user").innerHTML="用户名不能为空";
                document.form1.sub.disabled=true;
                }else{
                    document.getElementById("user").innerHTML="";
                    document.form1.sub.disabled=false;
                    }           
        }
    function checkpwd(va){
        if(va==""){
            document.getElementById("pwd").innerHTML="密码不能为空";
            document.form1.sub.disabled=true;
        }else{
            document.getElementById("pwd").innerHTML="";
            document.form1.sub.disabled=false;
            }                       
    }
    function checkRpwd(va){
        var pwd=document.getElementById("quepwd").value;
        if(va==""){
            document.getElementById("rpwd").innerHTML="密码不能为空";
            document.form1.sub.disabled=true;
        }else{
            document.getElementById("rpwd").innerHTML="";
            document.form1.sub.disabled=false;
            }   
        if(va!=pwd){
            document.getElementById("rpwd").innerHTML="两个密码不同";
            document.form1.sub.disabled=true;
        }else{
            document.getElementById("rpwd").innerHTML="";
            document.form1.sub.disabled=false;
            }   
    }
 
    function checkEmail(va){
        if(va==""){
            document.getElementById("email").innerHTML="邮箱不能为空";
            document.form1.sub.disabled=true;
        }else{
            document.getElementById("email").innerHTML="";
            document.form1.sub.disabled=false;
            }       
         var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
         if(!myreg.test(va)){
             document.getElementById("email").innerHTML="邮箱格式不对";
             document.form1.sub.disabled=true;
            }else{
                document.getElementById("email").innerHTML="";
                document.form1.sub.disabled=false;
            }   
    }
         
</script>
</head>
<body background="image/2.jpg">
 <form id="f" action="" name="form1">
    <p>用户名：<input type="text" name="user" onBlur="checkUser(this.value)" /><span id="user"></span></p>
    <p>密码：<input type="password" name="pwd" onBlur="checkpwd(this.value)" id="quepwd" /><span id="pwd"></span></p>
    <p>确认密码：<input type="password" name="rpwd" onBlur="checkRpwd(this.value)" /><span id="rpwd"></span></p>
    <p>邮箱：<input type="text" name="email" onBlur="checkEmail(this.value)" /><span id="email"></span></p>
    <p><input type="submit" name="sub" value="提交" /></p>
</form>

</body>
</html>