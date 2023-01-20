public class Main {

    public static void main(String[] args) {

        Analizador a = new Analizador();

        System.out.println("([<{ }>]):" + a.analizarSimbolos("([<{ }>])"));
        System.out.println("([(]):" + a.analizarSimbolos("([(])"));
        System.out.println("([[<{ }>) :" + a.analizarSimbolos("([[<{ }>)"));
        System.out.println("((5+2)-(1+4)) :" + a.analizarSimbolos("((5+2)-(1+4))"));
        System.out.println("][)(:" + a.analizarSimbolos("][)("));
    }
}