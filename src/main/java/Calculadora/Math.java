package Calculadora;

public class Math {
    //Attributes
    private int numberOne;
    private int numberTwo;

    //Constructor

    public Math(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }


    //Methods


    public int Sum() {
        return numberOne+numberTwo;
    }
}
