<%--
  Created by IntelliJ IDEA.
  User: 28572
  Date: 2020-12-09
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="js/jquery-3.5.1.min.js"></script>
    <title>Sign In & Sign Up Form</title>
    <script src="js/login3.js"></script>
    <link rel="stylesheet" href="css/login3.css">
</head>
<body>
<div class="container">
    <div class="forms-container">
        <div class="signin-signup">
            <!-- //Sign in -->
            <form action="${pageContext.request.contextPath}/loginCheck" class="sign-in-form">
                <h2 class="title">Sign in</h2>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="text" name="id" placeholder="YourId">
                </div>

                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="password" placeholder="Password">
                </div>

                <div>
                    <div class="input-field" style="float: left;width: 190px;margin-right: 10px;">
                        <i class="fas fa-lock"></i>
                        <input type="text" name="checkCode" placeholder="CheckCode" >
                    </div>
                    <img src="/checkCodeServlet" id="img" style="border-radius: 50px;border: none;float: right;width: 100px;height: 50px;margin:10px 0;">
                </div>
                <div class="identity">

                    <input type="radio" name="identity" class="gcs-radio" id="Student" value="student"/>

                    <label for="Student">Student</label>

                    <input type="radio" name="identity" class="gcs-radio" id="Teacher" value="Teacher" />

                    <label for="Teacher">Teacher</label>

                </div>

                <input type="submit" value="Login" class="btn solid">

                <p class="social-text">Or Sign in with social platforms</p>

            </form>


            <!-- //Sign up -->
            <form action="" class="sign-up-form">
                <h2 class="title">Sign Up</h2>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Username">
                </div>

                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Password">
                </div>

                <div class="input-field">
                    <i class="fas fa-envelope"></i>
                    <input type="email" placeholder="Email">
                </div>

                <input type="submit" value="Sign Up" class="btn solid">

                <p class="social-text">Or Sign Up with social platforms</p>
<%--                <div class="social-media">--%>
<%--                    <a href="#" class="social-icon">--%>
<%--                        <i class="fab fa-facebook-f"></i>--%>
<%--                    </a>--%>
<%--                    <a href="#" class="social-icon">--%>
<%--                        <i class="fab fa-twitter"></i>--%>
<%--                    </a>--%>
<%--                    <a href="#" class="social-icon">--%>
<%--                        <i class="fab fa-google"></i>--%>
<%--                    </a>--%>
<%--                    <a href="#" class="social-icon">--%>
<%--                        <i class="fab fa-linkedin-in"></i>--%>
<%--                    </a>--%>
<%--                </div>--%>
            </form>
        </div>
    </div>


    <div class="panels-container">

        <!-- left panel -->
        <div class="panel left-panel">
            <div class="content">
                <h3>New Here?</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem architect</p>
                <button class="btn transparent" id="sign-up-btn">Sign up</button>
            </div>

            <img src="img/rocket.svg" class="image" alt="">
        </div>

        <!-- right panel -->
        <div class="panel right-panel">
            <div class="content">
                <h3>One of us?</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem architecto</p>
                <button class="btn transparent" id="sign-in-btn">Sign in</button>
            </div>

            <img src="img/desk.svg" class="image" alt="">
        </div>
    </div>
</div>


<script>
    window.onload = function () {
        document.getElementById("img").onclick = function () {
            this.src = "/checkCodeServlet?time" + new Date().getTime();
        }
    }

    if(<%=request.getAttribute("login_error") != null%>){
        alert("<%=request.getAttribute("login_error")%>");

    }
    if(<%=request.getAttribute("cc_error") != null%>){
        alert("<%=request.getAttribute("cc_error")%>");

    }
</script>
</body>
</html>
