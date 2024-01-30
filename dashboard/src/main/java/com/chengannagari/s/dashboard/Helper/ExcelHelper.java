package com.chengannagari.s.dashboard.Helper;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.chengannagari.s.dashboard.Entity.User;

public class ExcelHelper {

		public static boolean checkExcelFormat(MultipartFile file) {
			
			
			String contentType=file.getContentType();
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public static List<User> ConvertExcelToListOfEmployee(InputStream is)
		{
			List <User> li=new ArrayList<>();
			
			try {
				
				XSSFWorkbook  workbook=	new XSSFWorkbook(is);
				
				XSSFSheet sheet=workbook.getSheet("data");
				
				int rowNum=0;
				Iterator<Row> i=sheet.iterator();
				
				while(i.hasNext()) {
					Row r=i.next();
					
					if(rowNum==0) {
						rowNum++;
						continue;
					}
					
					Iterator<Cell> cell=r.iterator();
					
					int cid=0;
					User e=new User();
					
					while(cell.hasNext()) {
						Cell c=cell.next();
						
						switch(cid) {
						
						
						case 0:
							e.setFirstName(c.getStringCellValue());
							break;
						case 1:
							e.setLastName(c.getStringCellValue());
							break;
						case 2:
							e.setUserName(c.getStringCellValue());
						case 3:
							e.setGender(c.getStringCellValue());
						case 4:
							e.setCountry(c.getStringCellValue());
						case 5:
							e.setState(c.getStringCellValue());
						case 6:
							e.setDistrict(c.getStringCellValue());
						case 7:
							e.setAddress( c.getStringCellValue());
							break;
						case 8:
				            if (c.getCellType() == CellType.NUMERIC) {
				                // Use getNumericCellValue for numeric cells
				                e.setPhoneNumber((long) c.getNumericCellValue());
				            } else if (c.getCellType() == CellType.STRING) {
				                // Use getStringCellValue for string cells
				                e.setPhoneNumber(Long.parseLong(c.getStringCellValue()));
				            }
				            break;case 9:
							e.setEmail(c.getStringCellValue());
						case 10:
							e.setPassword(c.getStringCellValue());
						case 11:
							e.setImage(c.getStringCellValue());
                            default:
							break;
						}
						
						cid++;
					}
					li.add(e);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return li;
		}
	
}

