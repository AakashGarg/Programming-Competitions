import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Aakash
 */
public class Resistors {

    static ArrayList<NodePair> nodeList;
    static String[] inputStrings;

    public static void putData(String[] s) {
        nodeList = new ArrayList<NodePair>();
        for (int i = 0; i < s.length; i++) {
            nodeList.add(new NodePair(s[i]));
        }

    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        try {
            t = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            //exception caught
        }
        inputStrings = new String[t];
        int k = 0;
        while (t > 0) {
            try {
                inputStrings[k++] = br.readLine();
            } catch (IOException ex) {
                //exception caught
            }
            t--;
        }

        //processing starts
        t = 0;
        while (t < k) {
            putData(inputStrings[t].split(" "));
            while (nodeList.size() > 1) {
                for (int i = 0; i < nodeList.size(); i++) {
                    char lastChar = nodeList.get(i).node.charAt(1);
                    int count = 0;
                    int reqPos = 0;

                    for (int j = 0; j < nodeList.size(); j++) {
                        if (i != j) {
                            if (nodeList.get(j).node.charAt(0) == lastChar) {
                                reqPos = j;
                                if ((lastChar == 'z') == false) {
                                    count++;
                                }
                            } else if (nodeList.get(j).node.charAt(1) == lastChar) {
                                reqPos = j;
                                if ((lastChar == 'z') == false) {
                                    count++;
                                }
                            }
                            if (count > 1) {
                                break;
                            }
                        }
                    }
                    if (count == 1) {
                        if (lastChar == nodeList.get(reqPos).node.charAt(0)) {
                            NodePair ob = nodeList.get(i);
                            String n = "" + ob.node.charAt(0) + nodeList.get(reqPos).node.charAt(1);
                            float res = (ob.resistance + nodeList.get(reqPos).resistance);
                            ob.resistance = res;
                            ob.node = n;
                             nodeList.remove(reqPos);

                        }
                    }
                    
                    if (count == 1) {
                        i--;
                    }
                }
                
                Collections.sort(nodeList);
                for (int l = 0; l < nodeList.size(); l++) {

                    for (int m = l + 1; m < nodeList.size(); m++) {
                        if ((nodeList.get(l).node).compareTo(nodeList.get(m).node) == 0) {
                            nodeList.get(l).resistance = (float) ((nodeList.get(l).resistance * nodeList.get(m).resistance * 1.0) / (nodeList.get(l).resistance + nodeList.get(m).resistance));
                            nodeList.remove(m);
                            m--;
                        } else {
                            break;
                        }
                    }
                }
                
            }


            System.out.println(String.format("%.4f", nodeList.get(0).resistance));
            t++;
        }

    }

    private static class NodePair implements Comparable<NodePair> {

        float resistance;
        String node;

        public NodePair(String s) {
            this.resistance = 1;
            this.node = s;
        }

        public NodePair(int resistance, String s) {
            this.resistance = resistance;
            this.node = s;

        }

        public int compareTo(NodePair np) {
            return this.node.compareTo(np.node);
        }
    }
}
