public class Main {
    public  void main() {
        try {
            m1(4);
            m2();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("MyException");
        }catch (MyException2 e) {
            e.printStackTrace();
            System.out.println("MyException2");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }finally {
            System.out.println("finally");
        }
    }
    void m1(int i)throws MyException{
        if(i == 1){
            throw new MyException("m1");
        }
    }
    void m2()throws MyException2{

    }
}
