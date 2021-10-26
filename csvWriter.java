import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

// The class writes data in a file

public class csvWriter {

    public static   String fileName;
    public static   List<String> key;
    public static List<String> value;
    public static List<String> name;

    public csvWriter(String fileName,List<String> key,List<String> value,List<String> name ) throws IOException {
        csvWriter.fileName =fileName;
        csvWriter.key =key;
        csvWriter.value =value;
        csvWriter.name =name;
        writer();
    }



    public static void writer() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName+".csv"),
                "UTF-8"));
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Артикул","Наименование","Цена"));

        for(int i=0;i< key.size();i++) {
            printer.printRecord(key.get(i), name.get(i), value.get(i));
            printer.flush();
        }
    }

}
