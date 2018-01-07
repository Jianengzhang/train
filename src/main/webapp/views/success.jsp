<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>成功</title>
    <link type="text/css" rel="stylesheet" href="/css/animate.css">
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<section class="container">
    <div class="partDivide">
        <form class="form-inline" style="margin-left: 50px;">
            <label class="fieldName">出发站：</label>
            <div class="form-group">
                <select id="departure" class="mySelect" style="width: 170px;margin-right: 10px;">
                </select>
            </div>
        </form>
    </div>
    <div class="partDivide">
        <form class="form-inline" style="margin-left: 50px;">
            <label class="filedName">目的地：</label>
            <div class="form-group">
                <select id="destination" class="mySelect" style="width: 170px;margin-right: 10px;">
                </select>
            </div>
        </form>
    </div>

    <div class="partDivide">
        <button onclick="submitGet()" class="btn btn-primary pull-right" style="margin-right: 10px;">查询</button>
    </div>
    <div id="SelectError" color:red></div>
</section>
<section class="wrapper wrapper-content animated fadeInRight">
    <section class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>审核</h5>
                </div>

                <div class="ibox-content">
                    <table class="footable table table-striped toggle-arrow-tiny" data-page-size="8">
                        <thead>
                        <tr>
                            <th>车次</th>
                            <th>出发站</th>
                            <th>目的站</th>
                            <th>出发时间</th>
                            <th>到达时间</th>
                            <th>商务座</th>
                            <th>一等座</th>
                            <th>二等座</th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${TrainRoute}" var="train">
                            <tr>
                                <td>${train.trainName}</td>
                                <td>${train.stationName1}</td>
                                <td>${train.stationName2}</td>
                                <td><fmt:formatDate value="${train.leaveTime}" pattern="MM-dd HH:mm"/> </td>
                                <td><fmt:formatDate value="${train.arriveTime}" pattern="MM-dd HH:mm"/> </td>
                                <td>${train.restSite1}</td>
                                <td>${train.restSite2}</td>
                                <td>${train.restSite3}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                        <tfoot>
                        <tr>
                            <td colspan="5">
                                <ul class="pagination pull-right"></ul>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </section>
</section>

<%--<div class="partDivide" style="margin-bottom: 100px;">--%>
    <%--<div class="fieldContainer">--%>
        <%--<table class="footable table table-stripped toggle-arrow-tiny" data-page-size="8">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th>车次</th>--%>
                <%--<th>出发站</th>--%>
                <%--<th>目的站</th>--%>
                <%--<th>出发时间</th>--%>
                <%--<th>到达时间</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<c:forEach items="${TrainRoute}" var="train">--%>
                <%--<tr>--%>
                    <%--<td>${train.trainId}</td>--%>
                    <%--<td>${train.stationId1}</td>--%>
                    <%--<td>${train.stationId2}</td>--%>
                    <%--<td>${train.leaveTime}</td>--%>
                    <%--<td>${train.arriveTime}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="fieldContainer">
    <label><a href="/search/advanced"> ${NODirect}</a></label>
</div>
</div>
</body>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/station.js"></script>
<script type="text/javascript" src="/js/selectStation.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/plugins/footable/footable.all.min.js"></script>

</html>
