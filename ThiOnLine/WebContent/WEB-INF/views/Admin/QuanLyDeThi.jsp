<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="css/main.css" />
</head>

<body>
	<div id="header">
		<div class="navbar-header">
			<nav class="navbar navbar-expand-sm navbar-dark fixed-top">
				<a class="navbar-brand" href="#"><span>Thi trắc nghiệm
						online</span></a>
				<ul class="navbar-nav mr-auto">
				</ul>
				<div class="navbar-brand dropdown">
					<a class="dropdown-toggle" href="#" id="navbardrop"
						data-toggle="dropdown"> <span>Admin</span>
					</a>
					<ul class="dropdown-menu">
						<li class="dropdown-item"><a href="#"><span
								class="bg-dark text-light float-right" id="number-message">58</span>
								<i class="icon-comment-discussion"></i> Tin nhắn</a></li>
						<li class="dropdown-item"></li>
						<li class="dropdown-item"><a href="#"><i
								class="icon-switch2"></i> Đăng xuất</a></li>
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
								<h3 class="media-heading">Danh sách đề thi</h3>
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
								<button data-target="#new-exam" data-toggle="modal"
									class="btn btn-dark btn-labeled">
									<b><i class="fas fa-plus-square"></i></b>Thêm đề thi
								</button>
							</div>
						</div>
						<div class="table-reponsive">
							<table class="table table-striped table-hover">
								<thead class="custom-thead">
									<tr>
										<th>Mã đề thi</th>
										<th>Môn học</th>
										<th>Số câu dễ</th>
										<th>Số câu trung bình</th>
										<th>Số câu khó</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${DSDeThi }" var="deThi">
										<tr>
											<td>
												<div class="dropdown">
													<span data-toggle="dropdown" class="dropdown-toggle">${deThi.maDeThi }</span>
													<ul class="dropdown-menu">
														<li class="dropdown-item"><a
															href="XoaDeThi?maDe=${deThi.maDeThi}"></a> Xóa</li>
														<li data-sub="${deThi.maMonHoc}" data-id="${deThi.maDeThi }"
															class="dropdown-item edit-exam">Sửa</li>
														<li class="dropdown-item">Đã giao</li>
														<li data-id="${deThi.maDeThi }" data-target="#fac"
															data-toggle="modal" class="dropdown-item zao">Giao
															đề thi</li>
													</ul>
												</div>
											</td>
											<td>${deThi.maMonHoc }</td>
											<td>${deThi.soCauDe }</td>
											<td>${deThi.soCauTrungBinh }</td>
											<td>${deThi.soCauKho }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="pagination">
						<a href="#">&laquo;</a> <a href="#">1</a> <a href="#"
							class="active">2</a> <a href="#">3</a> <a href="#">4</a> <a
							href="#">5</a> <a href="#">6</a> <a href="#">&raquo;</a>
					</div>

					<div class="modal fade" id="fac">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<div class="panel-heading">
										<h3 id="title-dethi" class="panel-title"></h3>
									</div>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div id="edit-elment">
									<div class="panel">
										<div class="panel-body">
											<div class="row">
												<div class="col">
													<div class="tabbable tab-content-bordered">
														<div class="tab-content">
															<div class="tab-panel has-padding active">
																<div class="form-group">
																	<label class="control-label">Tiêu đề</label> <input
																		id="tieu-de" type="text" class="form-control" />
																</div>
																<div class="d-inline-block" style="width: 45%">
																	<div class="form-group">
																		<label class="control-label">Lớp học</label> <select
																			id="lop" name="lopHoc" class="custom-select">

																		</select>
																	</div>
																	<div class="form-group">
																		<label class="control-label">Thời lượng</label> <input
																			id="thoi-luong" value="15" type="text"
																			class="form-control" />
																	</div>
																</div>
																<div class="d-inline-block" style="width: 45%">
																	<div class="form-group">
																		<label class="control-label">Bắt đầu</label> <input
																			id="bat-dau" type="datetime-local"
																			class="form-control" />
																	</div>
																	<div class="form-group">
																		<label class="control-label">Kết thúc</label> <input
																			id="ket-thuc" type="datetime-local"
																			class="form-control" />
																	</div>
																	<div class="form-group">
																		<label class="control-label">Số lần làm bài</label> <input
																			id="so-lan" type="text" class="form-control" />
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button id="save" type="button" class="btn btn-success">Thêm</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Hủy</button>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="modal fade" id="new-exam">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">Dề thi mới</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form id="form" action="ThemDeThi" method="get">
										<div class="d-flex mb-3">
											<div class="col">
												<label class="control-label">Môn học</label> <select
													id="mon-hoc" name="monHoc" class="custom-select">
													<c:forEach items="${dsMonHoc }" var="monHoc">
														<option value="${monHoc.maMonHoc }"><span>${monHoc.tenMonHoc}-</span><span>${monHoc.maMonHoc}</span></option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="d-flex">
											<div class="col">
												<div class="form-group">
													<label class="control-label">Số câu dễ</label> <input
														id="cau-tb" name="soCauDe" type="number"
														class="form-control" />
												</div>
											</div>
											<div class="col">
												<div class="form-group">
													<label class="control-label">Số câu trung bình</label> <input
														id="cau-de" name="soCauTrungBinh" type="number"
														class="form-control" />
												</div>
											</div>
											<div class="col">
												<div class="form-group">
													<label class="control-label">Số câu khó</label> <input
														id="cau-kho" name="soCauKho" type="number"
														class="form-control" />
												</div>
											</div>
										</div>
										<div style="text-align: center" id="gui" class="col mt-4 pb-3">
											<button type="submit" class="btn btn-primary">Tiếp
												tục</button>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="JS/QuanLyDeThi.js" type="text/javascript"></script>
</body>
</html>