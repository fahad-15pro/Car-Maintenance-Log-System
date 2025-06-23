import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CarCheckManager {
    String path;

    public CarCheckManager() {
        path = "./maintenance.txt";
    }

    public void writeRecord(MaintenanceRecord record) {

        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(record.toString());
            writer.flush();
            writer.close();
        } catch (Exception ex) {
        }
    }

    public MaintenanceRecord[] getAllRecords() {
        File file = new File(path);
        int count = 0;

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
        } catch (Exception ex) {
        }

        MaintenanceRecord[] records = new MaintenanceRecord[count];

        try {
            Scanner sc = new Scanner(file);
            for (int i = 0; i < count; i++) {
                String line = sc.nextLine();
                records[i] = new MaintenanceRecord(line);
            }
        } catch (Exception ex) {
        }

        return records;
    }
}