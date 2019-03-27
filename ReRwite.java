import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;


public class ReRwite {
    public static void main(String[] args) throws IOException {


        FileInputStream inputStream = new FileInputStream(new File("src/res/Irregular verbs1.xls"));
        FileWriter writer = new FileWriter("text.txt");
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        StringBuilder d = new StringBuilder();
        d.append("verbs\n");

        int j = 0;
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < 100; i++) {

            b.append("\n" + "\"" + i + "\"\n");
            b.append("{ inf: ");
            b.append(workbook.getSheetAt(0).getRow(i).getCell(j));
            b.append(",\n pastp: ");
            b.append(workbook.getSheetAt(0).getRow(i).getCell(j + 1));
            b.append(",\n simple: ");
            b.append(workbook.getSheetAt(0).getRow(i).getCell(j + 2));
            b.append("},");

            System.out.println(b);
        }
        writer.write(d.toString());
        writer.write(b.toString());
        writer.close();
    }

}