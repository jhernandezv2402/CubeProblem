import java.math.*;

public class Cubo{
    
    int[][][] cubo; // Numero de iteraciones 
    int N; // Dimension de cubo
    
    public Cubo(int N) throws InvalidFormatException{
        // Validar condiciones iniciales
        // 1 <= N <= 100 
        if(1<= N && N<=100){
            this.cubo = new int[N+1][N+1][N+1];   
            this.N = N;
        } else {
            throw new InvalidFormatException("Valor invalido para construccion de cubo");
        }
    }
    
    public String update(int x, int y, int z, int W){
        // Validar coordenadas 1 <= x,y,z <= N 
        if(!(1<=x && x<=this.N && 1<=y && y<=this.N && 1<=z && z<=this.N)){
            return "Coordenadas para UPDATE invalidas";
        } 
        
        // Validar valor
        if(!(Math.pow(-10,9)<= W && W<=Math.pow(10,9))){
            return "Valor invalido";
        }
        
        this.cubo[x][y][z] = W;
        return "";
    }
    
    public String query(int x1, int y1, int z1, int x2, int y2, int z2){
        // Validar coordenadas
        if(!(1<=x1 && x1<= x2 && x2<=this.N && 1<=y1 && y1<=y2 && y2<=this.N && 1<=z1 && z1<=z2 && z2<=this.N)){
            return "Operacion invalida";
        }
        
        int suma = 0;
        
        for(int i= x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                for(int k=z1; k<=z2; k++){
                    suma+= this.cubo[i][j][k];
                }
            }
        }
        return ""+suma;
    }
}