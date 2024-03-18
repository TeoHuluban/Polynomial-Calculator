package Logic;

import GUI.UserInterface;
import Model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Operations {

    public static Polynomial addition(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        p.getPolynomial().putAll(p1.getPolynomial());

        for (Map.Entry<Integer, Double> e : p2.getPolynomial().entrySet()) {
            int key = e.getKey();
            double value = e.getValue();

            if (p.getPolynomial().containsKey(key)) {
                p.getPolynomial().put(key, p.getPolynomial().get(key) + value);
            } else {
                p.getPolynomial().put(key, value);
            }
        }

        return p;
    }

    public static Polynomial subtraction(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        p.getPolynomial().putAll(p1.getPolynomial());

        for (Map.Entry<Integer, Double> e : p2.getPolynomial().entrySet()) {
            int key = e.getKey();
            double value = e.getValue();

            if (p.getPolynomial().containsKey(key)) {
                    p.getPolynomial().put(key, p.getPolynomial().get(key) - value);
                if(p.getPolynomial().get(key) == 0)
                    p.getPolynomial().remove(key);

            } else {
                p.getPolynomial().put(key, -  value);
            }
        }

        return p;
    }

    public static Polynomial multiplication(Polynomial p1, Polynomial p2){
        Polynomial p = new Polynomial();

        for (Map.Entry<Integer, Double> e1 : p1.getPolynomial().entrySet()) {
            int key1 = e1.getKey();
            double value1 = e1.getValue();

            for (Map.Entry<Integer, Double> e2 : p2.getPolynomial().entrySet()) {
                int key2 = e2.getKey();
                double value2 = e2.getValue();
                int key = key1 + key2;
                double value = value1 * value2;

                if(p.getPolynomial().containsKey(key)){
                    double initialValue = p.getPolynomial().get(key);
                    p.getPolynomial().put(key, initialValue + value);
                }
                else{
                    p.getPolynomial().put(key, value);
                }
            }
        }

        return p;
    }

    public static Polynomial[] division(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();
        Polynomial deimp = new Polynomial();
        Polynomial imp = new Polynomial();

        if(p1.getPolynomial().firstKey() >= p2.getPolynomial().firstKey()) {
            deimp.getPolynomial().putAll(p1.getPolynomial());
            imp.getPolynomial().putAll(p2.getPolynomial());
        } else{
            deimp.getPolynomial().putAll(p2.getPolynomial());
            imp.getPolynomial().putAll(p1.getPolynomial());
        }

        while(deimp.getPolynomial().firstEntry() != null && deimp.getPolynomial().firstKey()>=imp.getPolynomial().firstKey())
        {
            int key = imp.getPolynomial().firstEntry().getKey();
            double value = imp.getPolynomial().firstEntry().getValue();
            int intKey = deimp.getPolynomial().firstKey();
            double intValue = deimp.getPolynomial().firstEntry().getValue();

            Polynomial monom = new Polynomial();
            monom.getPolynomial().put(intKey - key, intValue/value);

            result.getPolynomial().put(intKey - key, intValue/value);
            deimp = subtraction(deimp,  multiplication(monom, imp));
        }

        return new Polynomial[] {result, deimp};
    }
    public static Polynomial differentiation(Polynomial p1){
        Polynomial p = new Polynomial();

        for (Map.Entry<Integer, Double> e : p1.getPolynomial().entrySet()) {
            int key = e.getKey() - 1;
            double value =  e.getValue() * e.getKey();

            p.getPolynomial().put(key, value);
        }
        return p;
    }

    public static Polynomial integration(Polynomial p1){
        Polynomial p = new Polynomial();

        for (Map.Entry<Integer, Double> e : p1.getPolynomial().entrySet()) {
            int key = e.getKey() + 1;
            double value =  e.getValue() / (e.getKey() + 1);

            p.getPolynomial().put(key, value);
        }
        return p;
    }
}
