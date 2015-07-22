/**
 * Created by amacavei on 7/20/2015.
 */
public class Operatii {

    public NumarComplex one;
    public NumarComplex two;

    Operatii (NumarComplex one, NumarComplex two)
    {
        this.one = one;
        this.two = two;
    }

    public NumarComplex getOne() {
        return one;
    }

    public NumarComplex getTwo() {
        return two;
    }

    public static NumarComplex complexAdd(NumarComplex one, NumarComplex two)    {
        return new NumarComplex(one.getRe() + two.getRe(),one.getIm() + two.getIm());
    }

    public static NumarComplex complexMul(NumarComplex one, NumarComplex two){
        return new NumarComplex((one.getRe()*two.getRe() + one.getRe()*two.getIm()),one.getIm()*two.getRe() + one.getIm()*two.getIm());
    }


    public void printComplexAdd(){
        System.out.println(complexAdd(one, two));
    }

    public void printComplexMul(){
        System.out.println(complexMul(one, two));
    }
}
