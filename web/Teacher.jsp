<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28572
  Date: 2020-12-19
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher</title>
    <link rel="stylesheet" href="css/displayteacher.css">
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/login3.js"></script>
</head>
<body>
<div>
    <!-- left panel -->
    <div class="left-panel">
        <div class="left-content">
            <div class="logo">
                <h1 style="color: rgb(255, 255, 255);">SIMS</h1>
            </div>
            <input type="text" placeholder="Search">
            <!-- icon -->
            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="img">
                <img src="iconimg/chakan.svg" alt="">
                <div>Search</div>
            </div>

            <div class="logout">
                <a href=""><button><img src="iconimg/logout.svg" alt=""></button></a>
            </div>

        </div>
    </div>


    <!-- right panel -->
    <div class="right-panel">
        <div class="dashbored">
            <div class="dash-txt">
                <span>Teacher Panel</span>
            </div>
            <div class="dash-btn">
                <button class="btn-stu">Student</button>
                <button class="btn-teh">Score</button>
            </div>
        </div>

        <div class="content">
            <!-- course form -->
            <div class="stu-form">
                <div class="data-display">
                    <div class="left-data-display">
                        <span>Student Score</span>
                        <div class="data-chart" id="stu-score"></div>
                    </div>
                </div>

                <!-- form content -->
                <div class="form-content">
                    <form action="">
                        <div class="form-title">
                            <span>Student</span>
                            <input id="input-search" type="text" placeholder="Search" name="course">
                            <button id="form-subtn"><img src="iconimg/forward.svg" alt=""></button>
                            <p style="margin-right: 10px;">
                                <img src="iconimg/more.svg" alt="">
                            </p>
                            <p  id="form-search">
                                <img src="iconimg/form-search.svg" alt="">
                            </p>
                        </div>
                    </form>
                    <div class="form">
                        <table class="form-table">
                            <tr class="tr-first">
                                <th style="width: 20px;"></th>
                                <th style="width: 150px;">Id</th>
                                <th style="width: 200px;">Name</th>
                                <th style="width: 200px;">Email</th>
                                <th style="width: 200px;">Major</th>
                                <th style="width: 150px;">Score</th>
                                <th style="width: 20px;"></th>
                            </tr>

                            <c:forEach items="${pbs.list}" var="student" varStatus="s">

                                <tr>
                                    <th></th>
                                    <th >${student.getSno()}</th>
                                    <th ><img class="tea-img" src="student/${student.getSname()}.jpg">${student.getSname()}</th>
                                    <th >${student.getEmail()}</th>
                                    <th >${student.getMajor()}</th>
                                    <th  stuid="${student.getSno()}"><div class="sinput-text">${student.getScore()}</div><input class="score-input" type="text"></th>
                                    <th></th>
                                </tr>

                            </c:forEach>



                        </table>
                    </div>
                </div>
            </div>




            <div class="teh-form">teh-form</div>
        </div>

    </div>








    <!-- User info -->
    <div class="user-info">
        <div class="title">
            <div class="profile">
                <img src="teacher/Alisa.jpg" alt="">
            </div>
            <div class="user-text">
                <h2><%=request.getSession().getAttribute("teacher")%></h2>
                <span> Nice to see you</span>
            </div>
            <div class="line"></div>

        </div>

        <!-- User Teacher -->
        <div class="user-teacher">
            <p>My Work</p>
            <div id="UTC">

            </div>
        </div>

        <div class="line2"></div>
        <!-- User Course -->
        <div class="user-course">
            <p>My Course</p>
            <div id="UC">
                <li id="course-animate">Mysql</li>
            </div>

        </div>
    </div>

















    <!-- test From -->
    <div class="">
        <!-- <form action="">
            <table class="contain" cellspacing="0">
                <tr class="tr">
                    <th class="left-border">Check Box</th>
                    <th>Sno</th>
                    <th>Sname</th>
                    <th>Ssex</th>
                    <th class="right-border">Birthday</th>
                </tr>
                <tr>
                    <th>09104110</th>
                </tr>
                <tr>
                    <th>09104110</th>
                </tr>
            </table>
        </form> -->
    </div>


</div>












<script >

    $(function () {

        FlashStu_Score();
        FlashWork();
        FlashStudentInfo();

        function FlashStu_Score(){
            $.get("/flashScoreLine",function (data) {
                stu_score.setOption({
                    xAxis: {
                        data:data.names
                    },
                    series:[{
                        data:data.LessonPeriod
                    }]
                })
            },"json")
        }

        function FlashWork() {
            $.get("/flashWork", function (data) {

                Work.setOption({
                    series: [{
                        // 根据名字对应到相应的系列
                        data: (function () {

                            var res = [];
                            var i;
                            var len = data.names.length;
                            for (i = 0, size = len; i < size; i++) {
                                res.push({
                                    //通过把result进行遍历循环来获取数据并放入Echarts中
                                    name: data.names[i],
                                    value: data.LessonPeriod[i]
                                });
                            }
                            return res;
                        })()

                    }]
                })

            }, "json");
        }

        function FlashStudentInfo(){
            $.ajax({
                url:"/findAllStudent",
                type:"POST",


            });
        }

        //logout
        $(".logout").click(function () {
            $.ajax({
                url:"/logout",
                type:"POST",
                success:function () {
                    window.location.href="/logout"
                }
            });
        });

        //id 唯一确定 不能重复

        $(".form-table tr th").click(function () {
            var stuid = $(this).attr('stuid');
            $(this).children(".sinput-text").css("display","none");
            $(this).children(".score-input").css("display","block");

            $(this).children(".score-input").blur(function () {
                //get score
                var score = $(this).val();
                $.get("/insertScore",{'stuid':stuid,'score':score},function (data) {
                    if (data.code === 200){
                        FlashStu_Score();
                        FlashWork();
                        FlashStudentInfo();
                    }
                    else{
                        FlashStu_Score();
                        FlashWork();
                        FlashStudentInfo();
                    }
                })

            });
        });


    })
</script>



<!-- echart -->
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var stu_score = echarts.init(document.getElementById('stu-score'));
    var Work = echarts.init(document.getElementById('UTC'));

    Work.setOption({
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        series: [
            {
                name: '工作进度',
                type: 'pie',
                // color:'rgb(50,197,233)',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '20',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data:[{
                    value:[],name:[]
                }]
            }
        ]
    });


    stu_score.setOption({

        tooltip: {
            trigger: 'axis'
        },
        grid:{
            width:'80%',
            height:'70%',
            bottom:40
        },

        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: []
        },
        yAxis: {
            splitLine: {color:'rgb(255,255,255)'},
            type: 'value',
        },
        series: [
            {
                name: '分数',
                type: 'line',
                data: [],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
            },

        ]

    });
</script>
</body>
</html>
