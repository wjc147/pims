<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——登录界面</title>

  <style type="text/css">
         #bd{
             text-align:center;
             margin-top:150px;
         }
         #j{
             margin:auto;
             margin-top:150px;
             width:350px;
             height:350px;
             border:dotted;
         }
            a{
              color:threedlightshadow;
         
      }
      
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
    

        
        </script>

  
    </head>        
  
<body background="image/1.jpg" >
            
            <div id="j">
                <form id="bd" action="" method="post" >
                  
                  <p>用户名：<input type="text" name="user" onBlur="checkUser(this.value)" /><span id="user"></span></p>
                   <p>密码：<input type="password" name="pwd" onBlur="checkpwd(this.value)" id="quepwd" /><span id="pwd"></span></p>
                         <br>
                           &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; <input type="submit" value="登录" size="12">
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
                            <input type="reset" value="清除" size="12">
                     <hr/>
                        <td>
                           <p align="center">
                             <a href="zc.jsp">注册</a></p>
                        </td>
                       <hr/>
                 </form> 
                 
       </div>
</body>
