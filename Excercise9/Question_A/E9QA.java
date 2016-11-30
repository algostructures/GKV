class Messagethreads extends Thread{
    String message;
    int time;
    Messagethreads(String message, int time){
        this.message = message;
        this.time = time;
    }
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(this.message);
            try{
                Thread.sleep(time*1000);
            }catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}

public class E9QA{
    public static void main(String args[]){
        Messagethreads t1=new Messagethreads("Good Morning", 1);
        Messagethreads t2=new Messagethreads("Hello", 2);
        Messagethreads t3=new Messagethreads("Welcome", 3);
        t1.start();
        t2.start();
        t3.start();
    }
}
