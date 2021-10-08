<%@ page import="java.util.List" %>
<%@ page import="com.rsw.entity.Course" %>
<%@ page import="com.rsw.entity.UserTeacher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28572
  Date: 2020-12-13
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display</title>
    <link rel="stylesheet" href="css/display.css">
    <script src="js/d-toast.min.js" type="text/javascript" charset="UTF-8"></script>
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
                <h1 style="color: black;">SIMS</h1>
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
                <span>Student Panel</span>
            </div>
            <div class="dash-btn">
                <button class="btn-stu">Course</button>
                <button class="btn-teh">Teacher</button>
            </div>
        </div>

        <div class="content">
            <!-- course form -->
            <div class="stu-form">
                <div class="data-display">
                    <div class="left-data-display">
                        <span>My course</span>
                        <div class="data-chart1" id="my-course-data"></div>
                    </div>
                    <div class="right-data-display">
                        <span></span>
                        <div class="data-chart" id="my-course-grade"></div>
                    </div>
                </div>

                <!-- form content -->
                <div class="form-content">
                    <form >
                        <div class="form-title">
                            <span>Course</span>
                            <input id="input-search" type="text" placeholder="Search" name="course-search" value="">
                            <button id="form-subtn"><img src="iconimg/forward.svg" alt=""></button>
                            <p style="margin-right: 10px;">
                                <img src="iconimg/more.svg" alt="">
                            </p>
                            <p  id="form-search">
                                <img src="iconimg/form-search.svg" alt="">
                            </p>
                        </div>
                        <div class="form">
                            <table class="form-table">
                                <tr class="tr-first">
                                    <th style="width: 20px;"></th>
                                    <th style="width: 150px;">Id</th>
                                    <th style="width: 250px;">Name</th>
                                    <th style="width: 150px;">Credit</th>
                                    <th style="width: 250px;">Teacher</th>
                                    <th style="width: 150px;">Period</th>
                                    <th style="width: 150px;">Operation</th>
                                </tr>

                                <c:forEach items="${pb.list}" var="course" varStatus="s">

                                    <tr>
                                        <th></th>
                                        <th >${course.getID()}</th>
                                        <th >${course.getName()}</th>
                                        <th>${course.getCredit()}</th>
                                        <th ><img class="tea-img" src="teacher/${course.getTeacher()}.jpg" alt="">${course.getTeacher()}</th>
                                        <th>${course.getLessonPeriod()}</th>
                                        <th><a id="plus-btn" Teacher="${course.getTeacher()}" Uid="${course.getID()}" CName="${course.getName()}"><div class="plus" type="submit" ><img src="iconimg/Plus.svg" alt=""></div></a></th>
                                    </tr>

                                </c:forEach>


                            </table>
                        </div>
                    </form>
                </div>

                <div class="clear"></div>

            </div>

            <div class="teh-form">teh-form</div>
        </div>

    </div>








    <!-- User info -->
    <div class="user-info">
        <div class="title">
            <div class="profile">
                <img src="student/David.jpg" alt="">
            </div>
            <div class="user-text">
                <h2>David</h2>
                <span> Nice to see you</span>
            </div>
            <div class="line"></div>

        </div>

        <!-- User Teacher -->
        <div class="user-teacher">
            <p>My Teacher</p>
            <div id="UTC">

            </div>


        </div>

        <div class="line2"></div>
        <!-- User Course -->
        <div class="user-course">
            <p>My Course</p>
            <div id="UC">

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








<script type="text/javascript">


    function testInner(i,isShowIcon){

        var config={
            title:"Add Successfully！！！",//通知标题部分  默认 新消息   可选
            body:"",//通知内容部分
            inner:true, // 是浏览器仿桌面通知 否首选桌面通知 默认否 可选

            timeout:10000 // 自动关闭 单位毫秒 默认 6500毫秒   timeout<=0 不自动关闭  可选
        }

        if(isShowIcon==true){
            config.icon="student/David.jpg";//通知的图片 可选
        }

        //仿桌面通知
        new dToast(config);
    }


</script>


<%--Test-btn--%>
<script >
    $(function () {

        //页面加载时加载数据

        DisplayMyCourse();
        DisplayMyTeacher();
        // DisplayAllCourse();
        //
        // function DisplayAllCourse() {
        //     $.get("/findAllCourseByPage",{'course-search':1})
        // }


        function DisplayMyTeacher() {
            var _html = '';
            $.get("/displayMyTeacher", function (msg) {
                $.each(msg.data, function (key, val) {
                    _html += '<li><img class="teaU-img" src="teacher/' + val['Teacher'] + '.jpg" alt="">' + val['Teacher'] + '</li>';
                })
                $("#UTC").html(_html);
            }, "json")
        }

        function DisplayMyCourse() {
            var _html = '';
            $.get("/displayMyCourse", function (msg) {
                $.each(msg.data, function (key, val) {
                    _html += '<li id="course-animate">' + val['CName'] +'<div class="del-div" id="del-btn" course='+ val['CName'] + '><img src="iconimg/del.svg" alt=""></div></li>';
                })
                $("#UC").html(_html);
            }, "json")
        }

        //Flash my teacher
        function FlashMyTeacher(t) {
                var _html = '';
                _html += '<li id="test-animate"><img class="teaU-img" src="teacher/' +t+ '.jpg" alt="">' + t + '</li>';

                $("#UTC").append(_html);

        }

        //Flash my course
        function FlashMyCourse(c) {
            var _html = '';
            _html += ' <li id="course-animate">'+c+'<div class="del-div" id="del-btn" course="'+ c +'"><img src="iconimg/del.svg" alt=""></div></li>';

            $("#UC").append(_html);

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

        //add event
        $(".form-table tr th a").click(function() {
            var Teacher = $(this).attr('Teacher');
            var Uid = $(this).attr('Uid');
            var CName = $(this).attr('CName');

            $.get("/myTeacher",{'Teacher':Teacher,'CName':CName},function (data) {

                if (data.code == 200){
                    testInner(4,true);
                    FlashMyTeacher(Teacher);
                    FlashMyCourse(CName);
                    FlashCourseInfo();
                }
                else if (data.code == 0){
                    alert("You have already taken the course!!")
                }
                else{
                    alert("选课失败！！！")
                }
            },"json")

        });

        //delete event
        $("body").on('click','#course-animate #del-btn',function () {
                var course = $(this).parent('#course-animate').html();
                var realcourse = course.split("<")[0];

                $.get("/delCourseInfo",{'course':realcourse},function (data) {
                    if (data.code == 200){

                        DisplayMyTeacher();
                        DisplayMyCourse();
                        FlashCourseInfo();
                    }
                    else {
                        alert(data.msg);
                    }
                },"json");


        });

        //form-subtn
        $("#form-subtn").click(function () {
            var search_course = $("#input-search").value;

            $.get("/findAllCourseByPage",function (data) {

            })
        });
    });
</script>


<script type="text/javascript">

    <%--if (${rows} === 1){--%>
    <%--    alert("添加成功！")--%>
    <%--}--%>
</script>
<!-- echart -->
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var Course = echarts.init(document.getElementById('my-course-data'));
    var Grade = echarts.init(document.getElementById('my-course-grade'));
    // 指定图表的配置项和数据

    Course.setOption({
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [
            {
                name: 'Name of Course',
                type: 'pie',
                radius: [20, 90],
                center: ['50%', '50%'],
                roseType: 'radius',

                emphasis: {
                    label: {
                        show: true
                    }
                },
                data:[{
                    value:[],name:[]
                }]
               
            },

        ]
    })

    $.get("/displayCourseInfo",function (data) {

        Course.hideLoading();
        Course.setOption({
            series: [{
                // 根据名字对应到相应的系列
                data: (function(){

                    var res = [];
                    var i ;
                    var len = data.names.length;
                    for(i=0,size=len;i<size;i++) {
                        res.push({
                            //通过把result进行遍历循环来获取数据并放入Echarts中
                            name: data.names[i],
                            value: data.LessonPeriod[i]
                        });
                    }
                    return res;
                })()

            }]
        });

        Grade.hideLoading();
        Grade.setOption({
            xAxis: [
                {
                    data:data.names
                }
            ],
            series: [
                {
                    data: data.LessonPeriod
                }
            ]

        })

    },"json");


    function FlashCourseInfo(){
        $.get("/displayCourseInfo",function (data) {

            Course.hideLoading();
            Course.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    data: (function(){

                        var res = [];
                        var i ;
                        var len = data.names.length;
                        for(i=0,size=len;i<size;i++) {
                            res.push({
                                //通过把result进行遍历循环来获取数据并放入Echarts中
                                name: data.names[i],
                                value: data.LessonPeriod[i]
                            });
                        }
                        return res;
                    })()

                }]
            });

            Grade.hideLoading();
            Grade.setOption({
                xAxis: [
                    {
                        data:data.names
                    }
                ],
                series: [
                    {
                        data: data.LessonPeriod
                    }
                ]

            })

        },"json");

    }


    Grade.setOption({
        color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: [],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'LessonPeriod',
                type: 'bar',
                barWidth: '40%',
                data: []
            }
        ]
    });


</script>
</body>
</html>
