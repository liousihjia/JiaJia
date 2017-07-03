package com.programcreek.helloworld.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

public class jxlsLearn {
    private static Logger log = LoggerFactory.getLogger(jxlsLearn.class);
	
	public static void main(String args[]){
		
		Connection con = null;  
		Statement stmt = null;  
		ResultSet rs = null;  
		
		log.debug("finding all LCekColumn start");
		try{
			// Establish the connection.  
	         Class.forName("net.sourceforge.jtds.jdbc.Driver");  
	         con = DriverManager.getConnection("jdbc:jtds:sqlserver://jsam06:1433/SMART_TAISC","sa","ti2ce9");
	         //con = DriverManager.getConnection(connectionUrl);  
	         stmt = con.createStatement();  

			List<CaseInfo> CaseInfo=new ArrayList<CaseInfo>();

	         Workbook workbook = Workbook.getWorkbook(ObjectCollectionDemo.class.getResourceAsStream("複本 複本 國華20170629.xls"));
				Sheet sheet = workbook.getSheet("工作表1");
				System.out.println("===");
				for (int i=1;i<sheet.getRows();i++){
//					System.out.print(sheet.getCell(2,i).getContents() + "===");
					StringBuffer queryString=new StringBuffer("select Main, Case_ID,dbo.O_Addr._city + dbo.O_Addr._area + dbo.O_Addr._burg + dbo.O_Addr._li + dbo.O_Addr._lin +");
					queryString.append(" dbo.O_Addr._st + dbo.O_Addr._st_kind + dbo.O_Addr._sec + dbo.O_Addr._lane + dbo.O_Addr._alley +");
					queryString.append("dbo.O_Addr._no + dbo.O_Addr._and + dbo.O_Addr._f + dbo.O_Addr._etc AS ad ,Addr_status,Addr_kind from O_Addr"); 
                           queryString.append(" where (Addr_kind = '新戶籍' or Addr_kind = '戶籍')"+
                           " and Case_ID = " + sheet.getCell(2,i).getContents() + " order by Main desc");
					rs = stmt.executeQuery(queryString.toString());  
					
					
			      // Iterate through the data in the result set and display it.  
			         while (rs.next()) {  
			        	 CaseInfo caseinfo=new CaseInfo();
			        	 caseinfo.setCase_ID(rs.getInt("Case_ID"));
			        	 caseinfo.setAddr1(rs.getString("ad"));
			        	 caseinfo.setAddr_kind(rs.getString("Addr_kind"));
			 			
			 			CaseInfo.add(caseinfo);
//						System.out.print(rs.getInt("Case_ID") + "," + rs.getString("addr1") + "," + rs.getString("Addr_kind"));
			 			if(rs.getString("Addr_kind") != null ){
			 				if(rs.getString("Addr_kind").equals("新戶籍")){
			 					System.out.print(rs.getInt("Case_ID")+"|"+rs.getString("Addr_kind")+"|"+rs.getString("ad")+"|"+rs.getString("Addr_status")+"|"+rs.getString("Main")+",");
//			 					System.out.print("*"+rs.getString("Main")+"=" + rs.getString("Addr_kind") + "=" + rs.getString("addr1"));
////			 					System.out.print(rs.getString("Addr_kind"));
			 				}
			 				else if(rs.getString("Addr_kind").equals("戶籍")){
			 					System.out.print(rs.getInt("Case_ID")+"|"+rs.getString("Addr_kind")+"|"+rs.getString("ad")+"|"+rs.getString("Addr_status")+"|"+rs.getString("Main")+",");
//			 					System.out.print("|" + rs.getString("Addr_kind") + "=" + rs.getString("addr1"));
////			 					System.out.print(rs.getString("Addr_kind"));
			 				}
			 				
			 			}
//						System.out.print(rs.getString("Addr_kind") + "=" + rs.getString("addr1") + ",");
//						log.debug(rs.getString("addr1") + ",");
						
//						 Label label = new Label(0, 1, "新增測試");
//						 sheet.getCell(23,i).new
//						 workbook.write(); 
//						 sheet.getCell(23,i).
			         }  
			         System.out.println();
					
					
				}
				workbook.close();
				
		}catch(Exception e){
			log.error("finding all LCekColumn error msg=>",e);
		}
		
		
	}
	
	public static void main2(String args[]){
		List<Employee> employees = null;
		try {
			employees = ObjectCollectionDemo.generateSampleEmployeeData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try(InputStream is = ObjectCollectionDemo.class.getResourceAsStream("object_collection_template.xls")) {
	        try (OutputStream os = new FileOutputStream("target/object_collection_output.xls")) {
	            Context context = new Context();
	            context.putVar("employees", employees);
//	            JxlsHelper.getInstance().processTemplate(is, os, context);
	            JxlsHelper.getInstance().processTemplateAtCell(is, os, context, "Result!A1");
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
