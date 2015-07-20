/**
 * Created by amacavei on 7/20/2015.
 */
public class Main {

    public static void main(String[] args) {
        NumarComplex nc1 = new NumarComplex(3,2);
        NumarComplex nc2 = new NumarComplex(1,4);

        Operatii sum = new Operatii(nc1,nc2);


        sum.printComplexAdd();
        sum.printComplexMul();

    }
}
