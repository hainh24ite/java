package chap8;

import java.util.NoSuchElementException;

public class MyIntstack {

    private int [] contents;

    private int tos;

    public MyIntstack(int capacity) {
        contents =new int [capacity];
    }

    public boolean isFull(){
        return tos==contents.length-1;
    }


//(1)
//    public void push(int element){
//        if(isFull()){
//            throw new IllegalStateException("Stack is full");
//        }
//        else{
//            contents[++tos]=element;
//        }
//    }


//(2)
//    public boolean push(int element){
//        if(isFull()){
//            return false;
//        }
//        else{
//            contents[++tos]=element;
//            return true;
//        }
//    }


    public void increaseCapacity(){
        int [] newContents=new int [contents.length*2];
        System.arraycopy(contents,0,newContents,0,contents.length);
        contents=newContents;
    }

//(3)
    public void push(int element){
        if(isFull()){
            increaseCapacity();
        }
        contents[++tos]=element;
    }


    public boolean isEmpty(){
        return tos<0;    
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty!");
        }
        return contents[tos--];
    }


    public int peek(){
        return contents[tos];
    }
}
