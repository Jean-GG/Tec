public class SeccuenciaDeNumeros
{
    public static void main(String[] args) throws Exception {
        int valor1 = 0;
        int valor2 = 1;
        int ciclos = 10;
        int suma  = 0;

        //System.out.println(valor1);
        //System.out.println(valor2);

        for(int i= 0; i < ciclos; i = i + 1)
        {
            suma = valor1 + valor2;
            System.out.println(suma);
            valor1 = valor2; 
            valor2 = suma;    
        }
    }
}