import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class ContractorFraudDetection {

    public static Map<String, Record> list = new HashMap<String, Record>();

    public static class Record {
        protected Integer lineStart;
        protected Integer lineStop;
        protected String[] id;
    }

    /*
     * Complete the function below.
     */
    static String[] findViolations(String[] datafeed, List<Record> list1) {
        String[] res;

        for(int i=0; i<datafeed.length; i++){
            String[] datasplit = datafeed[i].split(";");
            if(list.containsKey(datasplit[0]))
                updateMap(datasplit, i);
            else
                insertMap(datasplit, i);
        }

        int i = 0;
        for (Iterator<Map.Entry<String, Record>> it = list.entrySet().iterator(); it.hasNext(); ) {
            Iterator r = it.next();
            if(i>0)
                list.get(i-1). ;
            i++;
        }

        return res;
    }

    static void updateMap(String[] data, Integer lineNum){
        list.get(data[0]).id = data[1].split(",");
        list.get(data[0]).lineStop = lineNum;
    }

    static void insertMap(String[] data, int lineNum){
        Record rec = new Record();
        rec.lineStart = lineNum;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String[] res;
        int datafeed_size = 0;
        datafeed_size = Integer.parseInt(in.nextLine().trim());

        String[] datafeed = new String[datafeed_size];
        for(int i = 0; i < datafeed_size; i++) {
            String datafeed_item;
            try {
                datafeed_item = in.nextLine();
            } catch (Exception e) {
                datafeed_item = null;
            }
            datafeed[i] = datafeed_item;
        }

        res = findViolations(datafeed);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
