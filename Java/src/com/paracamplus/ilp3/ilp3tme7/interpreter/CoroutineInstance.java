package com.paracamplus.ilp3.ilp3tme7.interpreter;



import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

import java.util.List;
import java.util.concurrent.Semaphore;

public class CoroutineInstance extends Thread {

    private final Invocable fun;
    private final List<Object> args;
    private final Interpreter interpreter;
    
    // Déclaration des sémaphores, les notations "p" et "v" sont souvent trouvées dans la litérrature !
    private final Semaphore p;
    private final Semaphore v;
    
    // 
    private boolean finished = false;

    public CoroutineInstance(Invocable fun, List<Object> args, Interpreter interpreter){
        this.fun = fun;
        this.args = args;
        this.interpreter = interpreter;
        p = new Semaphore(0);
        v = new Semaphore(0);
    }

    // ******** Déclaration des méthodes
    
    // RUN              
    public void run(){
        try {
            p.acquire();
            fun.apply(interpreter, args.toArray());
            finished = true;
        } catch (InterruptedException | EvaluationException e) {
            e.printStackTrace();
        }
        v.release();
    }

    //Resume
    public void resumeCoroutine(){
        p.release();            		// p-- dans la litérrrature
        if(! finished){
            try {
                v.acquire();  			// v++ dans la litérrature
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Yield
    public void yieldCoroutine(){
        v.release();
        try {
            p.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}