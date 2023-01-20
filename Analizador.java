public class Analizador {
    int tam = 10;
    Pila miPilaApertura = new Pila(tam);
    Pila miPilaTerminacion = new Pila(tam);
    String textoAnalizar;
    int stringSize;

    public Boolean analizarSimbolos(String textoAnalizar) {
        this.textoAnalizar = textoAnalizar;
        int i;

        for (int j = miPilaApertura.mostrarTope(); j <= tam; j++) {
            miPilaApertura.pop();
        }
        for (int k = miPilaTerminacion.mostrarTope(); k <= tam; k++) {
            miPilaTerminacion.pop();
        }

        stringSize = textoAnalizar.length();
        if (textoAnalizar.charAt(0) == '('
                || textoAnalizar.charAt(0) == '{'
                || textoAnalizar.charAt(0) == '['
                || textoAnalizar.charAt(0) == '<') {
            do {
                for (i = 0; i < textoAnalizar.length(); i++) {
                    if (esSimApertura(i)) {
                        if (estanEmparejados()) {
                            miPilaApertura.pop();
                            miPilaTerminacion.pop();
                        }
                    } else {
                        if (esSimTerminacion(i)) {
                            if (estanEmparejados()) {
                                miPilaApertura.pop();
                                miPilaTerminacion.pop();
                            }
                        }
                    }

                }
                return (miPilaApertura.estaVacia() && miPilaTerminacion.estaVacia());
            } while (i < stringSize);
        }
        return false;
    }

    private boolean esSimApertura(int i) {
        if (textoAnalizar.charAt(i) == '(') {
            miPilaApertura.push(1);
            return true;
        }
        if (textoAnalizar.charAt(i) == '[') {
            miPilaApertura.push(2);
            return true;
        }
        if (textoAnalizar.charAt(i) == '{') {
            miPilaApertura.push(3);
            return true;
        }
        if (textoAnalizar.charAt(i) == '<') {
            miPilaApertura.push(4);
            return true;
        }
        return false;
    }

    private boolean esSimTerminacion(int i) {
        if (textoAnalizar.charAt(i) == ')') {
            miPilaTerminacion.push(1);
            return true;
        }
        if (textoAnalizar.charAt(i) == ']') {
            miPilaTerminacion.push(2);
            return true;
        }
        if (textoAnalizar.charAt(i) == '}') {
            miPilaTerminacion.push(3);
            return true;
        }
        if (textoAnalizar.charAt(i) == '>') {
            miPilaTerminacion.push(4);
            return true;
        }
        return false;
    }

    private boolean estanEmparejados() {
        return (miPilaTerminacion.mostrarTope() == miPilaApertura.mostrarTope());
    }
}