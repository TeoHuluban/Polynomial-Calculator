package Model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

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

    public String toString() {
        String result="";
        for (Map.Entry<Integer, Double> e : this.getPolynomial().entrySet()){
            result = result + e.getValue() + "x^" + e.getKey() + " + ";
        }
        if(result.length()>=3)
        result = result.substring(0, result.length() - 3);
        return result;
    }
}
