<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Preview Example</title>
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
            <nav class ="navbar navbar-expand-sm navbar-dark fixed-top">
                <a class="navbar-brand" href="#"><span>Thi trắc nghiệm online</span></a>
                <ul class="navbar-nav mr-auto">
                </ul>
                <div class="navbar-brand dropdown" >
                    <a class="dropdown-toggle"  id="navbardrop" data-toggle="dropdown">
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
    <div class="page-content">
        <div class="row">
            <div class="d-none d-lg-block sidebar  sidebar-fixed-left pr-0">
                <div class="sidebar-content">
                    <div class="sidebar-user">
                        <div class="category-content">
                            <div class="media">
                                <div class="media-body">
                                    <span class="media-heading">Người quản lí</span>
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
                                <li data-toggle="modal" data-target="#add-question" class="nav-item">Thêm câu hỏi</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="col p-4">
                <div class="test-content">
                <c:forEach items="${dsCauHoi}" var="cauhoi">
                	  <ul class="question">
                        <li>
                            <div class="frage">
                                <div class="row">
                                    <div class="col-2">
                                        <img data-toggle="modal" data-target="#accept-delete" class="img-fluid delete-button"
                                            src="images/delete.png">
                                    </div>
                                    <div class="col-md-10">
										  <div class="question-content">
                                               <p id="${cauhoi.maCauHoi }" class="cau-hoi">${cauhoi.noiDung }</p>
                                          </div>
                                    </div>
                                </div>
                            </div>
                                <div class="answorten">
                                    <div class="answer-content">
                                        <input data-choice="A" type="radio" name=${cauhoi.maCauHoi }>
                                        <span>${cauhoi.dapAnA}</span>
                                    </div>
                                    <div class="answer-content">
                                        <input data-choice="B" type="radio" name=${cauhoi.maCauHoi }>
                                        <span>${cauhoi.dapAnB}</span>
                                    </div>
                                    <div class="answer-content">
                                        <input data-choice="C" type="radio" name=${cauhoi.maCauHoi }>
                                        <span>${cauhoi.dapAnC}</span>
                                    </div>
                                    <div class="answer-content">
                                        <input data-choice="D" type="radio" name=${cauhoi.maCauHoi }>
                                        <span>${cauhoi.dapAnD}</span>
                                    </div>
                                   	 <div class="answer-content">
										<span>Đáp án đúng</span>
                                        <span>${cauhoi.dapAnDung}</span>
                                    </div>
                                </div>
                        </li>
                    </ul>   
                </c:forEach>        
                    <button id="save" class="btn mt-2 btn-primary">Lưu</button>
                </div>
            </div>
            <div class="modal fade" id="accept-delete">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Bạn có chắc chắn?</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            Bạn có chắc chắn xóa câu hỏi này khỏi đề thi?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success">Xóa</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                        </div>
                    </div>
                </div>
            </div>


            <div class="modal fade" id="add-question">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Bạn có chắc chắn?</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <h5 class="text-primary">Chọn môn học</h5>
                                <select name="cars" class="custom-select">
                                    <option value="" selected>Môn học 1</option>
                                    <option value="">Môn học 2</option>
                                    <option value="">Môn học 3</option>
                                    <option value="">Môn học 4</option>
                                </select>

                                <!------List câu hỏi sẽ load theo list môn học ý tưởng là vậy-->
                                <h5 class="text-primary mt-4">Chọn câu hỏi</h5>
                                <select name="cars" class="custom-select">
                                    <option value="" selected>Câu hỏi 1</option>
                                    <option value="">Câu hỏi 2</option>
                                    <option value="">Câu hỏi 3</option>
                                    <option value="">Câu hỏi 4</option>
                                </select>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success">Thêm</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
      <script>
        $(document).ready(function(){
            $("#save").click(function()
            {
                var a = document.getElementsByClassName("cau-hoi");
                var arr = new Array();
                for(var i=0;i<a.length;i++){
                    arr.push(a[i].id);
                 }
                 $.ajax({
                     url:"LuuDeThi",
                     type:"post",
                     data:{arr:JSON.stringify(arr)},
                     success:function(status){
                         if(status=="ok") alert("Thêm thành công");
                        else alert(status);
                     }
                 })
            })
        })
        </script>
</body>

</html>