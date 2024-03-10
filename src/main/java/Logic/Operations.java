package Logic;

import GUI.UserInterface;
import Model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Operations {

    public Polynomial add(Polynomial p1, Polynomial p2) {
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

    public Polynomial sub(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        p.getPolynomial().putAll(p1.getPolynomial());

        for (Map.Entry<Integer, Double> e : p2.getPolynomial().entrySet()) {
            int key = e.getKey();
            double value = e.getValue();

            if (p.getPolynomial().containsKey(key)) {
                p.getPolynomial().put(key, p.getPolynomial().get(key) - value);
            } else {
                p.getPolynomial().put(key, value);
            }
        }

        return p;
    }

    public Polynomial mul(Polynomial p1, Polynomial p2){
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

    public Polynomial div(Polynomial p1, Polynomial p2){
        Polynomial p = new Polynomial();
        Polynomial deimp = new Polynomial();
        Polynomial imp = new Polynomial();

        if(p1.getPolynomial().firstKey() > p2.getPolynomial().firstKey()){
            deimp.getPolynomial().putAll(p1.getPolynomial());
            imp.getPolynomial().putAll(p2.getPolynomial());
        }
        else{
            deimp.getPolynomial().putAll(p2.getPolynomial());
            imp.getPolynomial().putAll(p1.getPolynomial());
        }

        while(deimp.getPolynomial().firstKey()>=imp.getPolynomial().firstKey())
        {
            int key = imp.getPolynomial().firstEntry().getKey();
            double value = imp.getPolynomial().firstEntry().getValue();
            int intKey = deimp.getPolynomial().firstKey();
            double intValue = deimp.getPolynomial().firstEntry().getValue();

            Polynomial monom = new Polynomial();
            monom.getPolynomial().put(intKey - key, intValue/value);

            p.getPolynomial().put(intKey - key, intValue/value);
            deimp = sub(deimp,  mul(monom, imp));

            if(deimp.getPolynomial().firstEntry().getValue() == 0)
                deimp.getPolynomial().remove(deimp.getPolynomial().firstKey());
        }
        System.out.println("rest: " + deimp);
            return p;
    }
    public Polynomial der(Polynomial p1){
        Polynomial p = new Polynomial();

        for (Map.Entry<Integer, Double> e : p1.getPolynomial().entrySet()) {
            int key = e.getKey() - 1;
            double value =  e.getValue() * e.getKey();

            p.getPolynomial().put(key, value);
        }
        return p;
    }

    public Polynomial intg(Polynomial p1){
        Polynomial p = new Polynomial();

        for (Map.Entry<Integer, Double> e : p1.getPolynomial().entrySet()) {
            int key = e.getKey() + 1;
            double value =  e.getValue() / (e.getKey() + 1);

            p.getPolynomial().put(key, value);
        }
        return p;
    }

    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Operations op = new Operations();

        p1.getPolynomial().put(3,1d);
        p1.getPolynomial().put(2,-2d);
        p1.getPolynomial().put(1,6d);
        p1.getPolynomial().put(0,-5d);

        p2.getPolynomial().put(2,1d);
        p2.getPolynomial().put(0,-1d);

        p = op.div(p2, p1);
        //System.out.println(p1);
        //System.out.println(p2);
        System.out.println("cat: " + p);
    }

}
