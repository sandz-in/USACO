/*
ID: sandyri1
LANG: JAVA
TASK: ride
*/

import java.io.*;

public class ride {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String a = f.readLine();
        String b = f.readLine();
        while (a != null) {
            int aVal = 1;
            for (int i = 0; i < a.length(); i++) {
                aVal *= (a.charAt(i) - 'A' + 1);
            }
            int bVal = 1;
            for (int i = 0; i < b.length(); i++) {
                bVal *= (b.charAt(i) - 'A' + 1);
            }
            if ((aVal % 47) == (bVal % 47)) {
                out.println("GO");
            } else {
                out.println("STAY");
            }
            a = f.readLine();
            b = f.readLine();
        }

        out.close();
        System.exit(0);
    }


}
