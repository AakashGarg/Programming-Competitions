import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Aakash
 */
public class Pearson {

    static HashMap<Integer, Double> scores1 = new HashMap<Integer, Double>();
    static HashMap<Integer, Double> scores2 = new HashMap<Integer, Double>();

    public static Double getPearsonCorrelation(HashMap<Integer, Double> scores1, HashMap<Integer, Double> scores2) {
        double result = 0;
        double sum_sq_x = 0;
        double sum_sq_y = 0;
        double sum_coproduct = 0;
        double mean_x = scores1.get(0);
        double mean_y = scores2.get(0);
        for (int i = 2; i < scores1.size() + 1; i += 1) {
            double sweep = Double.valueOf(i - 1) / i;
            double delta_x = scores1.get(i - 1) - mean_x;
            double delta_y = scores2.get(i - 1) - mean_y;
            sum_sq_x += delta_x * delta_x * sweep;
            sum_sq_y += delta_y * delta_y * sweep;
            sum_coproduct += delta_x * delta_y * sweep;
            mean_x += delta_x / i;
            mean_y += delta_y / i;
        }
        
        if( (sum_sq_x/scores1.size() < 0) || (sum_sq_y/scores2.size() < 0) )
            return null;
        
        double pop_sd_x = (double) Math.sqrt(sum_sq_x / scores1.size());
        double pop_sd_y = (double) Math.sqrt(sum_sq_y / scores1.size());
        double cov_x_y = sum_coproduct / scores1.size();
        result = cov_x_y / (pop_sd_x * pop_sd_y);
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException ex) {
            //exception caught
        }

        int k = 0;

        try {
            while (true) {
                scores1.put(k, Double.parseDouble(s.split(" ")[0]));
                scores2.put(k, Double.parseDouble(s.split(" ")[1]));

                k++;
                try {
                    s = br.readLine();
                } catch (IOException ex) {
                    //exception caught
                }
            }
        } catch (Exception ex) {
        } finally {
            Double result = getPearsonCorrelation(scores1, scores2);
            if(result == null)
                System.out.println("invalid input");
            else
            System.out.println(String.format("%.4f",result ));
        }
    }
}
