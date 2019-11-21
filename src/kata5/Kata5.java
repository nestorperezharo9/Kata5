package kata5;

public class Kata5 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5\\sqlittle\\miercoles.db";
        BaseDatos database = new BaseDatos(url);
        database.open();
        
        database.select_PERSONAS();
        
        People people = new People("Santiago","Sanchez","Marketing");
        database.insert_PERSONAS(people);
        
        System.out.println("* * * * * * * * * * * * *");
        
        database.select_PERSONAS();
        
        database.close();
    }
    
}
