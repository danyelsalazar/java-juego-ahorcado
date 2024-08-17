import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //instanciamos el scanner
        Scanner scanner = new Scanner(System.in);

        //creamos la palabra
        String palabraSecreta = "inteligencia";
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        int i ;
        //llenamos el arreglo de letras con guiones; este sera el que mostraremos a medida que va adivinando
        for(i = 0; i < letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_';
        }

        while(!palabraAdivinada && intentos < intentosMaximos){

            System.out.println("Palabra secreta: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Ingresa una letra por favor");

            //usamos un booleano para saber si la letra esta dentro de la palabra
            boolean letraCorrecta = false;
            //pedimos la letra
            char letra = scanner.next().charAt(0);//asi solo tomamos la primera letyra que escriba el usuario 
            //System.out.println(letra);

            //recorremos la palabra a ver si esta la letra
            for(i = 0; i < palabraSecreta.length(); i++){
                //verificamos letra por letra de la palabra a ver si la letra ingresada se encuentra
                if(palabraSecreta.charAt(i) == letra){
                    letraCorrecta = true;
                    letrasAdivinadas[i] = letra;
                }
            }

            //verificamos si se adivino o no una letra en caso de que no, incrementamos la cantidad de intentos realizados
            if(!letraCorrecta){
                intentos++;
                System.out.println("letra incorrecta te quedan " + (intentosMaximos - intentos) +  " intentos");
            }else{
                if (palabraSecreta.equals(String.valueOf(letrasAdivinadas))) {
                    palabraAdivinada = true;
                    System.out.println("Felicidades adivinaste la palabra: " + palabraSecreta);
                }
            }

        }

        if(!palabraAdivinada){
            System.out.println("No adivinaste la palabra !GAME OVER¡");
        }
        scanner.close();

    }
}
