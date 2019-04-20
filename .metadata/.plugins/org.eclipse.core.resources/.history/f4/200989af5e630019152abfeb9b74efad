package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerLeta {
	private static LoggerLeta instancaLoggera;
	
	// akcije ce se logovati u fajlove organizovane po datumima
	private String fajlPutanja = String.format("log-leta-%s.txt", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
	
	private BufferedWriter bw = null;
	private FileWriter fw = null;
	
	
	// onemogucavamo direktno instanciranje loggera (Singleton)
	private LoggerLeta() {
		
	}
	
	public void testFajl() {
		System.out.println(fajlPutanja);
	}
	
	// metoda koja omogucava dobijanje instance logera
	public static LoggerLeta getInstance() {
		if(instancaLoggera == null)
			instancaLoggera = new LoggerLeta();
		return instancaLoggera;
	}
	
	private void konzolniLog(String sadrzaj) {
		System.out.println(sadrzaj);
	}
	
	private void fajlLog(String sadrzaj) {
		try {
			fw = new FileWriter(fajlPutanja,true);
			bw = new BufferedWriter(fw);
			bw.write("\n" + sadrzaj + "\n");
		} catch(IOException e) {
			System.out.println("Neuspesno logovanje, nije mogouce zapisati log u fajl. " + e.getMessage());
		} finally {
			try {
				if(bw != null)
					bw.close();
				
				if(fw != null)
					fw.close();
			} catch (IOException ioE) {
				ioE.printStackTrace();
			}
		}
		
	}
	
	public void loguj(String sadrzaj, boolean logujUFajl) {
		if(logujUFajl) {
			fajlLog(sadrzaj);
			return;
		}
		konzolniLog(sadrzaj);
	}
}
