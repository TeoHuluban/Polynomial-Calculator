package Model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private TreeMap<Integer, Double> polynomial;

    public Polynomial ()
    {
        polynomial = new TreeMap<Integer, Double>(Collections.reverseOrder());
    }

    public TreeMap<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(TreeMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }


    @Override
    public String toString() {
        String result="";
        if (this.getPolynomial().firstEntry() == null || (this.getPolynomial().lastEntry().getValue() == 0 && this.getPolynomial().firstEntry().getValue() == 0))
            result = "0";
        for (Map.Entry<Integer, Double> e : this.getPolynomial().entrySet()){
            if(e.getValue() != 0) {
                if (e.getValue().intValue() == e.getValue()) {
                    if (e.getKey() == 0) {
                        result = result + e.getValue().intValue() + " + ";
                    }
                    else {
                        result = result + e.getValue().intValue() + "x^" + e.getKey() + " + ";
                    }
                }else {
                    if (e.getKey() == 0) {
                        result = result + String.format("%.2f", e.getValue()) + " + ";
                    }
                    else {
                        result = result + String.format("%.2f", e.getValue()) + "x^" + e.getKey() + " + ";
                    }
                }

            }
        }
        result = result.replace("1x", "x");
        result = result.replace("x^1", "x");
        result = result.replace("+ -", "- ");
        if(result.length()>=3)
        result = result.substring(0, result.length() - 3);
        return result;
    }

}
