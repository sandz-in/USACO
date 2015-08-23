/*
ID: sandyri1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {

    public static BufferedReader br;
    public static StringTokenizer st;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("friday.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int a = Integer.parseInt(nextToken());
        Map<String, Integer> names = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < a; i++) {
            String b = nextToken();
            names.put(b, i);
        }
        int[] balance = new int[a];
        int[] initial = new int[a];
        String b = nextToken();
        while (b != null) {
            int donor = names.get(b);
            int amount = nextInt();
            int receiversNo = nextInt();
            if (receiversNo != 0) {
                int receiverAmount = amount / receiversNo;
                int donorsAmount = amount % receiversNo;
                balance[donor] -= (receiverAmount * receiversNo);
                for (int i = 0; i < receiversNo; i++) {
                    int receiver = names.get(nextToken());
                    balance[receiver] += receiverAmount;
                }
            }
            b = nextToken();

        }

        for (String c : names.keySet()) {
            out.write(c + " " + balance[names.get(c)]);
            out.write("\n");
        }
        out.close();
        System.exit(0);
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }


}
