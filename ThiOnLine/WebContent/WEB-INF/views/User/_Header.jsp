<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                                            <span class="size-18 d-none d-md-inline">${loginedUser.tenNguoiDung}</span>
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