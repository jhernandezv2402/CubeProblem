import java.util.*;
public class Solution{
    ArrayList<String> salida; 
    Scanner sc;
    Cubo c;
    
    public Solution(){
        this.salida = new ArrayList<String>();
        this.sc = new Scanner(System.in);
        
        try{
            Scanner sc = new Scanner(System.in); 
            int iteraciones = sc.nextInt(); 
            
            // Realiza el numero de iteraciones deseadas
            for(int i=0; i<iteraciones; i++){
                this.creaCubo();        
            }
        } catch(InputMismatchException ime){
            System.out.println("Entrada invalida");
        }
    }
    
    private String[] pideDatos(){
        String data = sc.nextLine();
        return data.split(" ");
    }
    
    private void creaCubo(){
        try{
            String[] datos = pideDatos();
            int dimension = Integer.parseInt(datos[0]);
            int nOperaciones = Integer.parseInt(datos[1]);
            c = new Cubo(dimension);
            
            for(int i=0; i<nOperaciones; i++){
                this.operacionCubo(this.pideDatos());
            }
            
            
        } catch(InvalidFormatException ife){
            System.out.println("Dimension de cubo invalida");
        } catch(NumberFormatException nfe){
            System.out.println("Datos invalidos");
        }
    }
    
    private void operacionCubo(String[] data){
        try{
            switch(data[0]){
            case "UPDATE":
                if(data.length<5 || data.length>5){
                    this.salida.add("UPDATE: Numero de parametros invalido");    
                } else {
                    this.salida.add(this.c.update(Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]), Integer.parseInt(data[4])));   
                }
                break; 
            case "QUERY": 
                if(data.length<7 || data.length>7){
                    this.salida.add("QUERY: Numero de parametros invalido");    
                } else {
                    this.salida.add(this.c.query(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
                }
                break; 
            default: 
                this.salida.add("Operacion invalida");
            }
        } catch(NumberFormatException nfe){
            System.out.println("Datos invalidos");
        }
    }
    
    public void salida(){
        for(int i=0; i<this.salida.size(); i++){
            if(!this.salida.get(i).equals("")){
                System.out.println(this.salida.get(i));
            } 
        }
    }
    
    public static void main(String[] args){
        Solution x = new Solution();
        x.salida();
    }
}