<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/user.css" />
    <style>
        #body-block{
            padding-top: 70px;
            padding-bottom: 200px;
        }
    </style>
</head>

<body>
    <div class="root">
        <header id="header">
            <nav id="navbar-user" class="navbar custom-navbar navbar-expand-sm navbar-dark fixed-top">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="logo">
                                <img class="img-fluid" src="images\logo.png">
                            </div>
                        </div>
                        <div class="col">
                            <div class="d-flex flex-row-reverse">
                                <div class="navbar-item">
                                    <div class="dropdown">
                                        <div data-toggle="dropdown" class="d-inline-block">
                                            <span class="size-18 d-none d-md-inline">Malcolm Graves</span>
                                            <span class="size-18 dropdown-toggle"></span>
                                        </div>
                                        <ul class="dropdown-menu">
                                            <li class="dropdown-item">Cái gì đó</li>
                                            <li class="dropdown-item">Cái gì đó</li>
                                            <li class="dropdown-item">Đăng xuất</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="navbar-item">
                                    <div class="navbar-image user-avatar">
                                        <a href=""><img class="rounded-circle" src="images\user-avt.png"></a>
                                    </div>
                                </div>
                                <div class="navbar-item dropdown mr-3">
                                    <div class="d-inline-block" data-toggle="dropdown">
                                        <span class="d-none d-lg-inline">Lớp học của bạn</span>
                                        <i class="fa fa-home d-lg-none" aria-hidden="true"></i>
                                        <span class="dropdown-toggle"></span>
                                    </div>
                                    <ul class="dropdown-menu">
                                        <li class="dropdown-item">Toán đại cương A1 - Giải tich</li>
                                        <li class="dropdown-item">Lí đại cương A1</li>
                                        <li class="dropdown-item">Hóa đại cương A2</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        <section id="body-block" class="bg-whitesmoke">
            <div class="container">
                <div class="page-content d-flex">
                    <div class="test-helper d-none d-lg-block">
                        <div id="helper-body" class="bg-white">
                            <div class="time-count">
                                <h2 class="text-primary"><strong>Còn lại</strong></h2>
                                <h3 class="text-danger">
                                    <strong>
                                        <span id="minute">15</span>
                                        <span>: </span>
                                        <span id="second">00</span>
                                    </strong>
                                </h3>
                            </div>
                            <script>
                                var txtm = document.getElementById("minute");
                                var txts = document.getElementById("second");
                                var m = txtm.innerHTML;
                                var s = txts.innerHTML;
                                var set = setInterval(function CountDown() {
                                    s--;
                                    if (s <= 0) {
                                        if (m == 0) { alert("het gio"); setTimeout(set) }
                                        else {
                                            s = 59;
                                            m = m - 1;
                                        }
                                    }
                                    txtm.innerHTML = m;
                                    txts.innerHTML = s;
                                }, 1000)
                            </script>
                            <div id="questions-complete" class="questions-complete pt-5 pb-5">
                                <h2 class="text-primary"><strong>Câu hỏi</strong></h2>
                            </div>
                            <div class="test-name">
                                <h3 class="text-primary">English test for beginer</h3>
                            </div>
                        </div>
                    </div>
                    <div class="test-content">
                    <c:forEach items="${DSCauHoi}" var="cauhoi">
                    	<ul class="question">
                            <li>
                                <div class="frage">
                                    <div class="row">
                                        <div class="col-2 d-none d-md-block">
                                            <div class="number bg-dark"><span class="index-question"></span></div>
                                        </div>
                                        <div class="col-md-10">
                                            <div class="question-content">
                                                <p>${cauhoi.noiDung }</p>
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
                                        <input data-choice="B" type="radio" name=${cauhoi.noiDung }>
                                        <span>${cauhoi.dapAnB}</span>
                                    </div>
                                    <div class="answer-content">
                                        <input data-choice="C" type="radio" name=${cauhoi.maCauHoi }>
                                        <span>${cauhoi.dapAnC}</span>
                                    </div>
                                    <div class="answer-content">
                                        <input data-choice="D" type="radio" name=${cauhoi.noiDung }>
                                        <span>${cauhoi.dapAnD}</span>
                                    </div>
                                </div>
                            </li>
                        </ul>         
                    </c:forEach>        
                        <button data-toggle="modal" data-target="#accept-submit" class="btn mt-2 btn-primary">Nội bài</button>
                    </div>
                </div>
            </div>
        </section>
        <div class="modal fade" id="accept-submit">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Xác nhận nộp bài</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        Sau khi nộp bài bạn sẽ không thể tiếp tục làm bài cũng như xem lại câu hỏi,
                        bạn có chắc chắn?
                    </div>
                    <div class="modal-footer">
                        <button type="submit" id="btn-accept-submit" class="btn btn-success">Nộp</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                    </div>
                </div>
            </div>
        </div>
        <section id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 footer_col">
                        <div class="footer_column footer_contact">
                            <div class="logo_container">
                                <div class="logo"><a href="#">G4-Saturday</a></div>
                            </div>
                            <div class="footer_title">Đặt câu hỏi? Trợ giúp 24/7</div>
                            <div class="footer_phone">+84 326845214</div>
                            <div class="footer_contact_text">
                                <p>01 Võ Văn Ngân - Thủ Đức</p>
                                <p>TP.Hồ Chí Minh - Việt Nam</p>
                            </div>
                            <div class="footer_social">
                                <ul>
                                    <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                    <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fab fa-youtube"></i></a></li>
                                    <li><a href="#"><i class="fab fa-google"></i></a></li>
                                    <li><a href="#"><i class="fab fa-vimeo-v"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-2 offset-lg-2">
                        <div class="footer_column">
                            <div class="footer_title">Tìm kiếm nhanh</div>
                            <ul class="footer_list">
                                <li><a href="#">Toán Học</a></li>
                                <li><a href="#">Vật Lí</a></li>
                                <li><a href="#">Hóa Học</a></li>
                                <li><a href="#">Sinh Học</a></li>
                                <li><a href="#">Ngoại ngữ</a></li>
                                <li><a href="#">Tin Học</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-2">
                        <div class="footer_column">
                            <ul class="footer_list footer_list_2">
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-2">
                        <div class="footer_column">
                            <div class="footer_title">Liên hệ</div>
                            <ul class="footer_list">
                                <li><a href="#">Huỳnh Công Chiến</a></li>
                                <li><a href="http://facebook.com/trankhuongduy1123">Trần Khương Duy</a></li>
                                <li><a href="#">Chu Thị Hương Giang</a></li>
                                <li><a href="#">Võ Đình Khởi</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="copyright_container d-flex flex-sm-row flex-column align-items-center justify-content-start">
                            <div class="copyright_content">
                                Copyright &copy;
                                <script>document.write(new Date().getFullYear());</script> All rights reserved | This
                                website is made by G4-Saturday
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
</body>
<script src="JS/PostMethod.js" type="text/javascript"></script>
 <script>
        var lq = document.getElementsByClassName("index-question");
        var parent = document.getElementById("questions-complete");
        for (i = 0; i < lq.length; i++) {
            lq[i].innerHTML = i+1;
            lq[i].id = "c" + (i+1);
            var tmp = document.createElement("a");
            tmp.className = "btn btn-outline-primary";
            tmp.innerHTML = i +1;
            tmp.href = "#c" + (i+1);
            parent.appendChild(tmp);
        }
    </script>  
    <script>
        $(document).ready(function(){
            $("#btn-accept-submit").click(function(){
                var baiThi = "";
                var luachon ;
               var al = document.getElementsByClassName("answorten");
                for(i=0;i<al.length;i++){
                   luachon = "*";
                   var ch = al[i].querySelectorAll('input[type="radio"]')
                    for(j=0;j<ch.length;j++)
                    {
                        if(ch[j].checked == true) luachon = ch[j].getAttribute("data-choice");
                    }
                    baiThi += luachon;
                }
				post('Example',{baiThi:baiThi});
            })
        })
    </script>  
</html>