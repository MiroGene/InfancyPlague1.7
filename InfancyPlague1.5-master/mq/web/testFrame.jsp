<%--
  Created by IntelliJ IDEA.
  User: Gene
  Date: 2017/4/27
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testFrame</title>
    <script src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
/*        $(function () {
            alert("ababababab阿斯蒂芬");
        });*/
        $(function () {
            for(i=0;i<3;i++){
                var creatediv= function(){
                    var parentdiv=$('<div></div>');        //创建一个父div
                    parentdiv.attr('id','parent');        //给父div设置id
                    parentdiv.addclass('parentdiv');    //添加css样式
                    var childdiv=$('<div></div>');        //创建一个子div
                    childdiv.attr('id','child');            //给子div设置id
                    childdiv.addclass('childdiv');    //添加css样式
                    childdiv.appendto(parentdiv);        //将子div添加到父div中
                    parentdiv.appendto('body');            //将父div添加到body中
                }
            }
        });
        function clonea(flowerPicture) {

            var v=$("#juhe1").clone();
            v.attr("id","juhe"+count);
            v.children("select").attr("id","juhe_type_select"+count).val(juhe[0]);
            v.children("#juhe_by1").attr("id","juhe_by"+count).val(juhe[1]).show();
            v.children("#hide_juhe_type1").attr("id","hide_juhe_type"+count).val(juhe[0]);
            v.children("#hide_juhe_by1").attr("id","hide_juhe_by"+count).val(juhe[1]);
            v.children("span").attr("id","del"+count).attr("style","display:inline; height: 35px; margin-top: 5px;");
            (v.children("span")).children("img").attr("onclick","del('juhe"+count+"')");
            $("#add_juhe").before(v);
            count++;
        }
        function ajaxTest() {
            $.ajax({
                type:"POST",
                url:"",
                data:{},
                success:function (data) {
                    for (var obj in data) {
                        alert(obj);
                    }
                }
            })
        }

    </script>

</head>
<body>
<ul>
    <li>

        <div style=" margin-right:100px;float: left; width:225px; height:300px; background: red">     <%--border:1px solid black;--%>

                <img src="image/aaa.bmp" style="width: 100%;max-height: 75%" >

            <div style="background: deepskyblue;width: 100%;height: 25%;word-wrap:break-word" >
                <span>aaaaabbbbbsdfasdfasdffasdfsdfsdf!
                asdfasdfasdf!
                asdasf!
                </span>
            </div>
        </div>

         <%--<div style="float: left;margin-left: 100px;"></div>--%>
        <div style=" margin-right:100px;margin-bottom: 100px;float: left; width:225px; height:300px; background: red">     <%--border:1px solid black;--%>

            <img src="image/aaa.bmp" style="width: 100%;max-height: 75%" >

            <div style="background: deepskyblue;width: 100%;height: 25%;word-wrap:break-word" >
                aaaaabbbbbsdfasdfasdffasdfsdfsdf!
                asdfasdfasdf!
                asdasf!
            </div>
        </div>
        <div style=" margin-right:100px;margin-bottom: 100px;float: left; width:225px; height:300px; background: red">     <%--border:1px solid black;--%>

            <img src="image/aaa.bmp" style="width: 100%;max-height: 75%" >

            <div style="background: deepskyblue;width: 100%;height: 25%;word-wrap:break-word" >
                aaaaabbbbbsdfasdfasdffasdfsdfsdf!
                asdfasdfasdf!
                asdasf!
            </div>
        </div>
        <div style=" margin-right:100px;margin-bottom: 100px;float: left; width:225px; height:300px; background: red">     <%--border:1px solid black;--%>

            <img src="image/aaa.bmp" style="width: 100%;max-height: 75%" >

            <div style="background: deepskyblue;width: 100%;height: 25%;word-wrap:break-word" >
                aaaaabbbbbsdfasdfasdffasdfsdfsdf!
                asdfasdfasdf!
                asdasf!
            </div>
        </div>
        <div style=" margin-right:100px;margin-bottom: 100px;float: left; width:225px; height:300px; background: red">     <%--border:1px solid black;--%>

            <img src="image/aaa.bmp" style="width: 100%;max-height: 75%" >

            <div style="background: deepskyblue;width: 100%;height: 25%;word-wrap:break-word" >
                aaaaabbbbbsdfasdfasdffasdfsdfsdf!
                asdfasdfasdf!
                asdasf!
            </div>
        </div>
    </li>
</ul>


</body>
</html>
