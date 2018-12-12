$(document).ready(function () {
    $(".edit-exam").click(function () {
        var maDe = $(this).data("id");
        var monHoc = $(this).data("sub");
        window.location.href = "SuaDeThi?maDe=" + maDe +"&monHoc="+monHoc+ "&t=" + Math.random();
    })
    $(".zao").click(function () {
        var maDeThi = $(this).data("id");
        document.getElementById("title-dethi").innerHTML = maDeThi;
        $.ajax({
            type: "Post",
            data: { maDe: maDeThi },
            url: "LopHocChuaThi",
            success: function (responsejson) {
                var parent = document.getElementById("lop");
                parent.innerHTML = "";
                $.each(responsejson, function (key, value) {
                    var tmp = document.createElement("option");
                    tmp.value = value['MaLop'];
                    tmp.id = value["MaLop"];
                    tmp.innerHTML = value['TenLop'];
                    parent.appendChild(tmp);
                })
            }

        })
        $("#save").click(function () {
            var maLop = $("#lop").val();
            var tieuDe = $("#tieu-de").val();
            var thoiLuong = $("#thoi-luong").val();
            var batDau = $("#bat-dau").val();
            var ketThuc = $("#ket-thuc").val();
            var soLanLamBai = $("#so-lan").val();

            var BG_DeThi = { MaLop: maLop, MaDeThi: maDeThi, TieuDe: tieuDe, ThoiLuong: thoiLuong, SoLanLamBai: soLanLamBai };
            $.ajax({
                type: "Post",
                data: { querry: JSON.stringify(BG_DeThi), batDau: batDau, ketThuc: ketThuc },
                url: "GiaoDeThi",
                success: function (status) {
                    if (status == "ok") {
                        parent = document.getElementById("lop");
                        alert("Đã thêm");
                        parent.remove(parent.selectedIndex);
                    }
                    else alert(status);
                }
            })
        })
    })
})

