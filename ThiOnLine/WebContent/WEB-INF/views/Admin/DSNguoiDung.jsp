<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Student</title>
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
                <div class="navbar-brand dropdown" >
                    <a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        <span>Admin</span>
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
                                        <span class="media-heading">ADMIN</span>
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
                                    <li data-toggle="collapse" data-target="#question" class="nav-item">Câu hỏi</li>
                                    <li class="nav-item">Lớp học</li>
                                    <li class="nav-item">Học sinh</li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="col content-wrapper">
                    <div class="page-header page-header-default">
                        <div class="page-header-content">
                            <div class="page-title">
                                <h3 class="media-heading">Danh sách học sinh</h3>
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
                                        <th>Tên tài khoản</th>
                                        <th>Tên học sinh</th>
                                        <th>Ngày sinh</th>
                                        <th>Địa chỉ</th>
                                        <th>Số điện thoại</th>
                                        <th>Số lớp học</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${DShocsinh}" var="hocsinh" >
                                	<tr>
                                        <td>
                                            <div class="dropdown">
                                                <span data-toggle="dropdown" class="dropdown-toggle">${hocsinh.tenTK}</span>
                                                <ul class="dropdown-menu">
                                                    <li class="dropdown-item">Xóa</li>
                                                    <li data-ten="${hocsinh.tenNguoiDung}" data-target="#fac" id=${hocsinh.tenTK} data-toggle="modal" class="dropdown-item edit">Xem
                                                        và sửa</li>
                                                </ul>
                                            </div>
                                        </td>
                                        <td>${hocsinh.tenNguoiDung}</td>
                                        <td>${hocsinh.ngaySinh}</td>
                                        <td>${hocsinh.diaChi}</td>
                                        <td>${hocsinh.SDT}</td>
                                        <td>${hocsinh.soLuongLopHoc}</td>
                                      </tr>         
                                </c:forEach>                                         
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <p style="color: red">${error}</p>
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
                                    <h4 id="heading-name" class="modal-title"></h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="user-profile d-flex">
                                        <div class="col">
                                            <h5 class="text-primary">Lớp học đã tham gia</h5>
                                            <div class="list-members" id="list-class"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-success">Lưu</button>
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
                                </div>
                                <div class="modal fade" id="accept-delete">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Bạn có chắc chăn?</h4>
                                                <button type="button" class="close close-modal">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                Xác nhận xóa học sinh ra khỏi lớp học?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-danger accept-delete">Xóa</button>
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
        $(document).ready(function () {
            $(".edit").click(function () {
            	$("#heading-name").text( $(this).data("ten"));
                var tentk = this.id;
                $.ajax({
                    type: "GET",
                    data: { TenTK: tentk },
                    url: "LopHocThamGia",
                    success: function (responsejson) {
                        var parent = document.getElementById("list-class");
                        parent.innerHTML = "";
                        $.each(responsejson, function (key, value) {
                            var tmp = document.createElement("div");
                            tmp.className = "d-flex list-member-item";
                            tmp.id ="block-" + value['MaLop'];
                            tmp.innerHTML = '<p>' + value['MaLop'] + '</p>'
                            + '<p>' + value['TenLop'] + '</p>'
                            + '<div><button data-target="#accept-delete" data-toggle="modal"'
                            + 'id = "' + value['MaLop'] + '"'
                            +'class="btn delete-item btn-danger remove-n">Xóa</button></div>'                                
                            parent.appendChild(tmp);
                        })
					 $('.remove-n').click(function()
                        {
						 var cl = this.id;
						 $(".accept-delete").unbind();
                            $(".accept-delete").click(function(){
                                $.ajax({
                                    type: "GET",
                                    data: { TenTK: tentk, MaLop:cl },
                                    url: "XoaKhoiLop",
                                    success: function(status){
										if(status=="done")
										{
											var old =  document.getElementById("block-"+ cl);
											parent.removeChild(old);
											$("#accept-delete").modal('hide');
										}
										else alert(status);
                                    }
                                })
                            })
                        })
                    }                    
                })
                
            })
        })
    </script>
</body>
</html>