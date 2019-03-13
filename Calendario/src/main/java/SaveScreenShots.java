
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaveScreenShots {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int h = 0;
		String[] fichero = new String [10];
		
		// driver.get("http://sahitest.com/demo/training/login.htm");
		try {
			driver.get("http://sahitest.com/demo/training/login.htm");
			WebElement user = driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[1]/td[2]/input"));
			user.sendKeys("cuarta");
			
			String fichero2= screenShot(driver);
			fichero [h]=fichero2;
			h=h+1;
			System.out.println(fichero2);
			WebElement pass = driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[2]/td[2]/input"));
			pass.sendKeys("quinta");
			screenShot(driver);
			WebElement btnLogin = driver
					.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[3]/td[2]/input"));
			btnLogin.click();
			screenShot(driver);
			
			crearExcel(fichero);
			System.out.println(fichero[0]+"si");
			

		} catch (Exception e) {

		}
		driver.close();

		
	}

	public static void crearExcel(String [] fichero) throws IOException {

		String sDirectorio = "Evidencia";
		File f = new File(sDirectorio);
		
		File[] ficheros = f.listFiles();
		/*for (int x = 0; x < ficheros.length; x++) {
			System.out.println(ficheros[x].getName());
		}*/
		
		
		System.out.println(fichero[0]+"tambien"+ficheros.length+fichero.length);
		int j = 1;
		/* Create a Workbook and Worksheet */
		XSSFWorkbook my_workbook = new XSSFWorkbook();
		XSSFSheet my_sheet = my_workbook.createSheet("Sheet 1");
		for (int i = 0; i < ficheros.length; i++) {
			/* Read input PNG / JPG Image into FileInputStream Object */
			InputStream my_banner_image = new FileInputStream(ficheros[i]);
			/* Convert picture to be added into a byte array */
			byte[] bytes = IOUtils.toByteArray(my_banner_image);
			/* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
			int my_picture_id = my_workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
			/* Close the InputStream. We are ready to attach the image to workbook now */
			my_banner_image.close();
			/* Create the drawing container */
			XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
			/* Create an anchor point */
			XSSFClientAnchor my_anchor = new XSSFClientAnchor();
			/* Define top left corner, and we can resize picture suitable from there */
			my_anchor.setCol1(1);
			my_anchor.setRow1(j);
			/* Invoke createPicture and pass the anchor point and ID */
			XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
			/* Call resize method, which resizes the image */
			my_picture.resize();
			j = j + 30;
		}
		/* Write changes to the workbook */
		FileOutputStream out = new FileOutputStream(new File("ExcelFile\\example.xlsx"));
		my_workbook.write(out);
		out.close();
		my_workbook.close();

	}

	public static String screenShot(WebDriver driver) {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("Evidencia\\" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(SrcFile, DestFile);
			String fichero = Long.toString(System.currentTimeMillis()) + ".png";
			return fichero;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR EN SS!!!");
			return "Error";
		}
	}
}
