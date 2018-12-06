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
    <link rel="stylesheet" type="text/css" media="screen" href="css/calendar.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/user.css" />
</head>
<body>
	<div class="root">
		<jsp:include page="_Header.jsp"></jsp:include>
		        <section id="body-block" class="bg-whitesmoke pb-5">
            <div class="container anti-fixed">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="user-profile">
                            <div class="d-flex flex-column flex-wrap align-items-center">
                                <div class="user-avatar d-block">
                                    <img class="rounded-circle" src="images\user-avt.png">
                                </div>
                                <p id="user-name" class="size-18 m-0 mt-3">${user.tenNguoiDung }</p>
                                <p id="user-position" class="sub-info">(Học sinh)</p>
                                <div class="user-info p-3">
                                    <p class="w-100">
                                        <i class="fas fa-birthday-cake icon-info"></i>
                                        <span>Ngày sinh: </span>
                                        <span id="date-of-birth" class="detail-info">${user.ngaySinh }</span>
                                        <i class="fas fa-pencil-alt float-right edit"></i>
                                    </p>
                                    <p>
                                        <i class="fas fa-map-marker-alt icon-info"></i>
                                        <span>Địa chỉ: </span>
                                        <span id="phone-number" class="detail-info">${user.diaChi }</span>
                                    </p>
                                    <p>
                                        <i class="fas fa-mobile-alt icon-info"></i>
                                        <span>Số điện thoại: </span>
                                        <span id="phone-number" class="detail-info">${user.SDT }</span>
                                    </p>
                                    <p>
                                        <i class="far fa-envelope icon-info"></i>
                                        <span>Email: </span>
                                        <span id="email" class="detail-info">Example@gmail.com</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="user-class">
                            <h3 class="panel-heading text-primary">Lớp học của bạn</h3>
                            <div class="d-flex flex-wrap">
                                <div class="col-12 col-md-6">
                                    <div class="class-block d-flex">
                                        <div class="class-icon math">
                                            <span class="notification">1</span>
                                        </div>
                                        <div class="class-name">
                                            <h4 class="class-name">Luyện thi THPTQG 2019 môn Toán</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="class-block d-flex">
                                        <div class="class-icon english">
                                            <span class="notification">1</span>
                                        </div>
                                        <div class="class-name">
                                            <h4 class="class-name">Tiếng Anh cấp độ tiểu học-Primary English</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="class-block d-flex">
                                        <div id="chem" class="class-icon chemistry">
                                            <span class="notification">1</span>
                                        </div>
                                        <div class="class-name">
                                            <h4 class="class-name">Luyện thi THPTQG 2019 môn Hóa </h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="class-block d-flex">
                                        <div class="class-icon physical">
                                            <span class="notification">1</span>
                                        </div>
                                        <div class="class-name">
                                            <h4 class="class-name">Luyện thi THPTQG 2019 môn Vật Lí</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="class-block d-flex">
                                        <div class="class-icon english">
                                            <span class="notification">1</span>
                                        </div>
                                        <div class="class-name">
                                            <h4 class="class-name">Luyện thi THPTQG 2019 môn Tiếng Anh</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="class-block d-flex">
                                        <div class="class-icon it">
                                            <span class="notification">1</span>
                                        </div>
                                        <div class="class-name">
                                            <h4 class="class-name">Tin học văn phòng cho kế toán-2018</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mt-1">
                    <div class="event-time">
                        <div class="row">
                            <div class="col-lg-4 d-none d-lg-block">
                                <div class="bg-white">
                                    <h3 class="panel-heading text-primary pl-3 m-0 pt-3 text-left">Lịch của bạn</h3>
                                    <div class="calendar-wrapper">
                                        <button id="btnPrev" type="button"><i class="fas fa-backward"> Prev</i></button>
                                        <button id="btnNext" type="button">Next <i class="fas fa-forward"></i></button>
                                        <div id="divCal"></div>
                                    </div>
                                    <script src="JS/calendar.js"></script>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="bg-white">
                                    <h3 class="panel-heading text-primary pl-3 m-0 pt-3 text-left">Sựu kiện sắp tới</h3>
                                    
                                    <c:forEach items="${dsDeThi }" var="deThi">
										 <div class="event-recent mt-4">
                                        <div class="event-block pl-3 pt-2">
                                            <a class="size-18 event-name text-primary">${deThi.tieuDe }</a>
                                            <p class="event-info pl-3">
                                                <span>Lớp:</span>
                                                <a href=""><span class="text-primary mr-3">${deThi.tenLop }</span></a>
                                                <span>Bắt đầu:</span>
                                                <span class="text-info ml-0 mr-3">${deThi.TGBatDau}</span>
                                                <span>Kết thúc:</span>
                                                <span class="text-danger ml-0">${deThi.TGKetThuc}</span>
                                                <span>Kết thúc:</span>
                                                <span class="text-danger ml-0">${deThi.thoiLuong} phút</span>
                                            </p>
                                            <a href="Example?maLop=${deThi.maLop }&maDe=${deThi.maDeThi}" class="text-primary pl-3"><i class="fas fa-play-circle"></i> Đến ngay...</a>
                                        </div>
                                    </div>
                                    </c:forEach>                     
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
		<jsp:include page="_Footer.jsp"></jsp:include>
	</div>
</body>
</html>