package utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class MathFunction {

	public static float ChamDiem(String baiThi, String dapAn) {
		baiThi = baiThi.toUpperCase();
		dapAn = dapAn.toUpperCase();
		float diem = 0;
		float dem = 0;
		float dodaidapan = dapAn.length();
		float dodaibaithi = baiThi.length();
		if (dodaidapan == dodaibaithi) {
			for (int i = 0; i < dodaibaithi; i++)
				if (baiThi.charAt(i) == dapAn.charAt(i))
					dem++;
		} else
			return -1;
		diem = (dem / dodaibaithi) * 10;
		return diem;
	}



	public static String ChuyenThanhChuKhongDau(String s) {

		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("");
	}
}
