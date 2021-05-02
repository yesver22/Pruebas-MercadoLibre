package com.yacode.model;

public class MutantValidation {

	String matrizMutante[][];

	private void armarMatrizMutante() {
		String[] vectorMutante = { "A", "T", "G", "C", "G", "A", "C", "A", "G", "T", "G", "C", "T", "T", "A", "T", "G",
				"T", "A", "G", "A", "A", "G", "G", "C", "C", "C", "C", "T", "A", "T", "C", "A", "C", "T", "G" };
		matrizMutante = new String[6][6];
		int pos = 0;
				
        for (int i = 0; i < matrizMutante.length; i++) {
            for (int j = 0; j < matrizMutante.length; j++) {
                matrizMutante[i][j] = vectorMutante[pos];
                pos++;
            }
        }
	}
	
	public boolean validarAdn(String[] dna) {
		
		armarMatrizMutante();
		
        String cadena = "";
        String letraMatriz = "";
        int contador = 0;
        boolean isMutant = false;
        int cantOcurrencias = 0;
        int cantCadenas = 0;
        boolean encontrado = false;

        for (int i = 0; i <= dna.length; i++) {
            if (i < dna.length) {
                cadena = dna[i];
                //Validacion horizontal
                for (int k = 0; k < matrizMutante.length; k++) {
                    letraMatriz = "";
                    for (int l = 0; l < matrizMutante[0].length; l++) {
                        letraMatriz = letraMatriz + matrizMutante[k][l];
                    }

                    encontrado = validarLetra(cadena, letraMatriz);

                    if (encontrado) {
                        cantOcurrencias++;
                        break;
                    }
                }
            }
        }
        if (cantOcurrencias >= 2) {
            System.out.println("Es Mutante Horizontal");
            return true;
        } else {
            //Recorrido Vertical
            for (int k = 0; k < matrizMutante.length; k++) {
                letraMatriz = "";
                for (int l = 0; l < matrizMutante[0].length; l++) {
                    letraMatriz = letraMatriz + matrizMutante[l][k];
                }
                encontrado = validarLetra(cadena, letraMatriz);
                if (encontrado) {
                    cantOcurrencias++;
                    break;
                }
            }

            if (cantOcurrencias >= 2) {
                System.out.println("Es Mutante Vertical");
                return true;
            } else {
                //Recorrido Diagonal
                /*for (int k = 0; k < matrizMutante.length; k++) {
                    letraMatriz = "";
                    for (int l = 0; l < matrizMutante[0].length; l++) {
                        letraMatriz = letraMatriz + matrizMutante[l][k];
                    }
                    encontrado = validarLetra(cadena, letraMatriz);
                    if (encontrado) {
                        cantOcurrencias++;
                        break;
                    }
                }

                if (cantOcurrencias >= 2) {
                    System.out.println("Es Mutante Diagonal");
                    return true;
                } else {
                    System.out.println("NO ES MUTANTE");

                }*/
            	return false;
            }

        }
	}
	
    private boolean validarLetra(String cadena, String letraMatriz) {
        String letraValidar = "";

        char[] dnaUnidad;
        dnaUnidad = cadena.toCharArray();

        for (int i = 0; i < dnaUnidad.length; i++) {
            letraValidar = Character.toString(dnaUnidad[i]);
            if (!letraValidar.equals("A") && !letraValidar.equals("T")
                    && !letraValidar.equals("C") && !letraValidar.equals("G")) {
                System.out.println("La letra " + letraValidar + " No es valida");
                return false;
            }
        }

        if (cadena.equals(letraMatriz)) {
            return true;
        }
        return false;
    }

}
