<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Example</title>
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
                                    <li class="nav-item">Đề thi</li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="col content-wrapper">
                    <div class="page-header page-header-default">
                        <div class="page-header-content">
                            <div class="page-title">
                                <h3 class="media-heading">Thêm đề thii</h3>
                            </div>
                        </div>
                        <div class="breadcrumb-line">
                            <ul class="breadcrumb">
                                <li><a href="index.html">Home</a></li>
                                <li class="active">Thêm đề thi</li>
                            </ul>
                        </div>
                    </div>
                    <div class="content">
                        <div class="panel panel-border-top">
                            <div class="col-12">
                            </div>
                        </div>
                        <div class="table-reponsive">
                            <div id="edit-elment">
                                <div class="panel">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col">
                                                <div class="tabbable tab-content-bordered">
                                                    <div class="tab-content">
														<form id="form" action="ThemDeThi" method="get">
															<div class="d-flex">
																<div class="col">
																	<div class="form-group">
																		<label class="control-label">Mã đề thi</label> <input
																			id="ma-de" name="maDeThi" type="text"
																			class="form-control" />
																	</div>
																</div>
																<div class="col">
																	<label class="control-label">Môn học</label> <select
																		id="mon-hoc" name="monHoc" class="custom-select">
																		<c:forEach items="${DSLopHoc }" var="monHoc">
																			<option value="${monHoc.maMonHoc }"><span>${monHoc.tenMonHoc}-</span><span>${monHoc.maMonHoc}</span></option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="d-flex">
																<div class="col">
																	<div class="form-group">
																		<label class="control-label">Số câu dễ</label> <input
																			id="cau-tb" name="soCauDe" type="text"
																			class="form-control" />
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label class="control-label">Số câu trung bình</label>
																		<input id="cau-de" name="soCauTrungBinh" type="text"
																			class="form-control" />
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label class="control-label">Số câu khó</label> <input
																			id="cau-kho" name="soCauKho" type="text"
																			class="form-control" />
																	</div>
																</div>
															</div>
															<div style="text-align: center" id="gui"
																class="col mt-4 pb-3">
																<button type="submit" class="btn btn-primary">Tiếp
																	tục</button>
															</div>
														</form>
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
            </div>
        </div>
    </div>
</body>
</html>