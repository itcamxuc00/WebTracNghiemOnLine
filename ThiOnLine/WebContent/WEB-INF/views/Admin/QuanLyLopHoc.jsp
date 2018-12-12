<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Class</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
</head>

<body>
    <div id="header">
        <div class="navbar-header">
            <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
                <a class="navbar-brand" href="#"><span>Thi trắc nghiệm online</span></a>
                <ul class="navbar-nav mr-auto">
                </ul>
                <div class="navbar-brand dropdown">
                    <a class="dropdown-toggle" id="navbardrop" data-toggle="dropdown">
                        <span>Quản lý</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-item"><a href="#"><span class="bg-dark text-light float-right" id="number-message">58</span>
                                <i class="icon-comment-discussion"></i>
                                Tin nhắn</a></li>
                        <li class="dropdown-item"></li>
                        <li class="dropdown-item"><a href="#"><i class="icon-switch2"></i> Đăng xuất</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <div class="page-container">
        <div class="page-content">
            <div class="row">
                <div class="d-none d-lg-block sidebar  sidebar-fixed-left pr-0">
                    <div class="sidebar-content">
                        <div class="sidebar-user">
                            <div class="category-content">
                                <div class="media">
                                    <div class="media-body">
                                        <span class="media-heading">Quản lý</span>
                                        <div class="text-size-mini text-muted">
                                            <span class="fs-11">Việt Nam</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="sidebar-category">
                            <nav class="category-content p-0">
                                <ul class="navigation">
                                   <li class="nav-item"><a style="color:white" href="QuanLyLopHoc" >Lớp học</a></li>
                                    <li class="nav-item"><a style="color:white" href="NguoiDung" > Học sinh</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="col content-wrapper">
                    <div class="page-header page-header-default">
                        <div class="page-header-content">
                            <div class="page-title">
                                <h3 class="media-heading">Danh sách lớp học</h3>
                            </div>
                        </div>
                        <div class="breadcrumb-line">
                            <ul class="breadcrumb">
                                <li><a href="index.html">Home</a></li>
                                <li class="active">Danh sách</li>
                            </ul>
                        </div>
                    </div>
                    <div class="content">
                        <div class="panel panel-border-top">
                            <div class="col-12">
                            </div>
                        </div>
                        <div class="table-reponsive">
                            <table class="table table-striped table-hover">
                                <thead class="custom-thead">
                                    <tr>
                                        <th>Mã lớp học</th>
                                        <th>Tên lớp học</th>
                                        <th>Ngày kết thúc</th>
                                        <th>Sỉ số hiện tại</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dsLopHoc }" var="lophoc">
                                    <tr>
											<td>
                                            <div class="dropdown">
                                                <span data-toggle="dropdown" class="dropdown-toggle">${lophoc.maLop }</span>
                                                <ul class="dropdown-menu">
                                                    <li class="dropdown-item"><a href="XoaLopHoc?maLop=${lophoc.maLop }">Xóa</a></li>
                                                    <li data-ten="${lophoc.tenLop}" data-ma="${lophoc.maLop}" data-target="#fac" data-toggle="modal" class="edit dropdown-item">Xem
                                                        và sửa</li>
                                                </ul>
                                            </div>
                                        </td>
                                        <td>${lophoc.tenLop}</td>
                                        <td>${lophoc.ngayKetThuc}</td>
                                        <td>${lophoc.soHocSinh}</td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="pagination">
                        <a href="#">&laquo;</a>
                        <a href="#">1</a>
                        <a href="#" class="active">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">&raquo;</a>
                    </div>
                    <div id="fac" class="modal full-question-content">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 id="modal-title" class="modal-title"></h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="class-profile">
                                        <div>
                                        <ul class="nav nav-tabs">
										    <li class="nav-item">
										      <a id="nav-not-in" class="nav-link active" data-toggle="tab" href="#list-not-in">Thêm học sinh</a>
										    </li>
										    <li class="nav-item">
										      <a id="nav-in" class="nav-link" data-toggle="tab" href="#list-in">Đã tham gia</a>
										    </li>
										  </ul>                       
                                           <div class="tab-content">
                                              <div id="list-not-in" class="tab-pane fade list-members">
                                              </div>
                                              <div id="list-in" class="list-members  tab-pane fade">                                                 
                                              </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
                                </div>
                                <div class="modal fade" id="accept-delete">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Bạn có chắc chăn?</h4>
                                                <button type="button" class="close close-modal">&times;</button>
                                            </div>
                                            <div id="veri-question" class="modal-body">
                                                
                                            </div>
                                            <div class="modal-footer">
                                                <button id="btn-accept-delete" type="button" class="btn btn-danger">Xóa</button>
                                                <button type="button" class="btn btn-secondary close-modal">Close</button>
                                            </div>
                                            <script>
                                                $(document).ready(function () {
                                                    $(".close-modal").click(function () {
                                                        $("#accept-delete").modal('hide');
                                                    })
                                                })
                                            </script>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
      </div>
      <script>
      var daTaiXuong1 = false;
      var daTaiXuong2 = false;
        $(document).ready(function () {
            $("#gui").click(function () {
                alert("aaaa");
                $("#ma-mon-hoc").val($("#mon-hoc").val());
                document.getElementById("form").submit();
            })
        })

        $(document).ready(function () {
            $(".edit").click(function () {
                var maLop = $(this).data("ma");
                $("#modal-title").text($(this).data("ten") + " -- " + maLop);
                var listHSChuaVao = document.getElementById("list-not-in");
                var LisHSDaVao = document.getElementById("list-in");
                daTaiXuong1 = false;
                daTaiXuong2 = false;
                $("#nav-not-in").click(function(){
                	if(daTaiXuong1==false)
					{
                    	LayDSHocSinhChuaVaoLop(maLop,listHSChuaVao);
                    	daTaiXuong1 = true;
					}
                })
                 $("#nav-in").click(function(){
                	if(daTaiXuong2==false)
					{
                    	LayDSHocSinhDaVaoLop(maLop,LisHSDaVao);
                    	daTaiXuong2 = true;
					}
                })
            })
        })
          function LayDSHocSinhChuaVaoLop(maLop,listHSChuaVao){
            $.ajax({
                    url: "QuanLyLopHoc",
                    type: "post",
                    data: { tool: "them", maLop: maLop },
                    success: function (responsejson) {
                        listHSChuaVao.innerHTML = "";
                        $.each(responsejson, function (key, value) {
                            var tmp = document.createElement("div");
                            tmp.className = "d-flex list-member-item";
                            tmp.id ="not-in-" + value['TenTK'];
                            tmp.innerHTML = '<p>' + value['TenTK'] + '</p>'
                            + '<p>' + value['TenHocSinh'] + '</p>'
                            + '<div><button '
                            + 'data-ma = "' + value['TenTK'] + '"'
                            + 'data-ten = "' + value['TenHocSinh'] + '"'
                            +'class="btn btn-success add-h">Thêm</button></div>'                                
                            listHSChuaVao.appendChild(tmp);
                        })
                            $(".add-h").click(function(){
                            var tenTK = $(this).data("ma");
                            var tenHocSinh = $(this).data("ten");
                            $.ajax({
                                url:("XoaKhoiLop"),
                                type:"post",
                                data:{tool:"them", tenTK:tenTK, maLop:maLop},
                                success:function(status){
                                    if(status=="ok"){
                                        var old =  document.getElementById("not-in-"+tenTK);
                                        listHSChuaVao.removeChild(old);
                                        daTaiXuong2 = false;
                                    }
                                    else alert(status);
                                }
                            })
                        })
                    }
                })
            }
        
        function LayDSHocSinhDaVaoLop(maLop,LisHSDaVao){
            $.ajax({
                url: "QuanLyLopHoc",
                type: "post",
                data: { tool: "xoa", maLop: maLop },
                success: function (responsejson) {
                    LisHSDaVao.innerHTML = "";
                    $.each(responsejson, function (key, value) {
                        var tmp = document.createElement("div");
                        tmp.className = "d-flex list-member-item";
                        tmp.id ="in-" + value['TenTK'];
                        tmp.innerHTML = '<p>' + value['TenTK'] + '</p>'
                        + '<p>' + value['TenHocSinh'] + '</p>'
                        + '<div><button data-target="#accept-delete" data-toggle="modal"'
                        + 'data-ma = "' + value['TenTK'] + '"'
                        + 'data-ten = "' + value['TenHocSinh'] + '"'
                        +'class="btn btn-danger delete-h">Xóa</button></div>'                                
                        LisHSDaVao.appendChild(tmp);
                    })
                        $(".delete-h").click(function(){
                        	var tenTK = $(this).data("ma");
                        	var tenHocSinh = $(this).data("ten");
                        	$("#veri-question").text("Bạn muốn xóa"+tenHocSinh+" ra khỏi lớp?" );
                        	$("#btn-accept-delete").unbind();
                        	$("#btn-accept-delete").click(function(){
                        	alert("haha");
                            $.ajax({
                                url:"XoaKhoiLop",
                                type:"post",
                                data:{tool:"xoa",tenTK:tenTK, maLop:maLop},
                                success: function(status){
                                    if(status=="ok")
                                    {
                                        var old =  document.getElementById("in-"+tenTK);
                                        LisHSDaVao.removeChild(old);
                                        daTaiXuong1 = false;
                                    }
                                    else alert(status);
                                }
                            })
                        })
                    })
                }
            })
        }
        
    </script>
</body>
</html>