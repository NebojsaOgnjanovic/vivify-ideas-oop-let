package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static Logger logInst;

	private String putanjaFajla = "log.fajl";

	private BufferedWriter bw = null;
	private FileWriter fw = null;

	private Logger() {

	}

	public static Logger getInstance() {
		if (logInst == null)
			logInst = new Logger();
		return logInst;
	}

	private void fajlLog(String sadrzaj) {
		try {

			fw = new FileWriter(putanjaFajla, true);
			bw = new BufferedWriter(fw);
			bw.write("\n" + sadrzaj + "\n");

		} catch (IOException e) {
			System.out.println("Neuspesno logovanje!!! " + e.getMessage());
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}

				if (fw != null) {
					fw.close();
				}
			} catch (IOException ioE) {
				ioE.printStackTrace();
			}
		}

	}

	public void loguj(String sadrzaj, boolean logujUFajl) {
		if (logujUFajl) {
			fajlLog(sadrzaj);
			return;
		}
	}
}
