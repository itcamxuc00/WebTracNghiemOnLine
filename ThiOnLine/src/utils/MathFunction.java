package utils;

public class MathFunction {
	
	public static float ChamDiem(String baiThi, String dapAn)
	{
		baiThi= baiThi.toUpperCase();
		dapAn = dapAn.toUpperCase();
		float diem = 0;
		float dem = 0;
		float dodaidapan = dapAn.length();
		float dodaibaithi = baiThi.length();
		if(dodaidapan==dodaibaithi)
		{
			for(int i=0;i<dodaibaithi;i++)
				if (baiThi.charAt(i)==dapAn.charAt(i)) dem++;
		}
		else return -1;
		diem = (dem/dodaibaithi)*10;
		return diem;
	}
}
