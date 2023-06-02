import java.util.Scanner ;


enum gender {Male,Female} ;
enum level {One,Two,Three} ;
enum sudject {Mathematics , Sciene , English , Aradic , Programming } ;

class Person {
    protected gender gen ;
    protected int age ;
    public Person(){
        
    }
    public Person(gender x , int y ){
        this.gen = x ;
        this.age= y ;
    }

    public gender getGen() {
        return gen;
    }

    public int getAge() {
        return age;
    }
}


class Student extends Person{
    protected int ID ;
    protected level l ;
    protected double degree ;
    protected double cost ;
    protected double discount ;
    protected static int Number_student = 0 ;
    public Student (){
        this.Number_student ++ ;
    }
    public Student (gender x , int y , int ID , level z , double d ){
        super(x , y);
        this.ID = ID ;
        this.l = z ;
        this.degree = d ;
        if (this.l == level.Three )
            this.cost = 5000 ;
        else if(this.l == level.Two)
            this.cost = 4500 ;
        else
            this.cost = 4000 ;
        if (this.degree >= 3.5)
            this.discount = 0.1 ;
        else
            this.discount = 0 ;
        this.Number_student ++ ;
    }
    public double getCost (){
        return this.cost ;
    }
    public double getcostdis (){
        return this.discount*100 ;
    }
    public double getcostafdis (){
        return cost - (this.discount*cost) ;
    }
    public static int numberofstudents(){
        return Number_student ;
    }
    
}


class Teacher extends Person {
    protected sudject sud ;
    protected int experience_work ;
    protected static int number_teachers = 0 ;
    protected double salary ;
    public Teacher(){
        number_teachers++;
    }
    public Teacher (sudject s , int e , gender g , int ag){
        super(g , ag) ;
        this.sud = s ;
        this.experience_work = e ;
        number_teachers++;
        this.salary = 1000 ;
    }
    public double getSalary (){
        return this.salary ;
    }
    public static int getNumberteachers (){
        return number_teachers ;
    }
}


class Room {
    private int capasity ;
    private static int number_rooms = 0 ;
    public Room (){
        number_rooms ++ ;
        this.capasity = 50 ;
    }
    public Room (int n ){
        number_rooms ++ ;
        this.capasity = n ;
    }
    public Room (Room r){
        number_rooms ++ ;
        this.capasity = r.capasity ;
    }
    public void compilerto (Room r){
        if (this.capasity > r.capasity)
            System.out.println("First");
        else if (this.capasity < r.capasity)
            System.out.println("Second");
        else
            System.out.println("Equal");
    }
    public static int getNumberrooms(){
        return number_rooms ;
    }
    public int getCapasity (){
        return this.capasity ;
    }
}


public class School{
    public static void main (String [] args){
        Student s1 = new Student() ;
        Student s2 = new Student(gender.Female , 10 , 20210202 , level.One , 3.2 );
        Teacher t2 = new Teacher(sudject.Mathematics , 5 , gender.Male , 40);
        Room r1 = new Room (20) ;
        Room r2 = new Room (r1) ;
        Room r3 = new Room () ;
        System.out.println(s2.getCost() + " " + s2.getcostdis() + " " + s2.getcostafdis() + " " + Student.numberofstudents()) ;
        System.out.println(t2.getSalary() + " " +Teacher.getNumberteachers()) ;
        System.out.println(r2.getCapasity() + " " + Room.getNumberrooms());
        r3.compilerto(r2) ;
    }
}
