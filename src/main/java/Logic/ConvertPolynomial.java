package Logic;

import Model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertPolynomial {
    public static Polynomial parsePolynomial(String polinom) {
        Polynomial pol = new Polynomial();

        Pattern pattern = Pattern.compile("(\\+|\\-)?(\\s*)(\\d*)(x)?(\\^)?(\\d*)?");
        Matcher matcher = pattern.matcher(polinom);

        while (matcher.find()) {
            String semn = matcher.group(1);
            String spatiu = matcher.group(2);
            String coeficient = matcher.group(3);
            String x = matcher.group(4);
            String p = matcher.group(5);
            String putere = matcher.group(6);
            double c1;
            int p1;

            if(x != null) {
                if (coeficient == null || coeficient.isEmpty()) {
                    c1 = 1;
                } else {
                    c1 = Double.parseDouble(coeficient);
                }
            }
            else{
                if (coeficient == null || coeficient.isEmpty()) {
                    c1 = 0;
                }else {
                    c1 = Double.parseDouble(coeficient);
                }
            }

            if (semn != null && semn.equals("-")){
                c1 = -c1;
            }

            if(x != null) {
                if (putere == null || putere.isEmpty()) {
                    p1 = 1;
                } else {
                    p1 = Integer.parseInt(putere);
                }
            } else{
                p1 = 0;
            }

            if(c1 != 0) {
                if (pol.getPolynomial().containsKey(p1)) {
                    double val = pol.getPolynomial().get(p1);
                    pol.getPolynomial().put(p1, val + c1);
                } else {
                    pol.getPolynomial().put(p1, c1);
                }
            }
        }

        return pol;
    }
}
