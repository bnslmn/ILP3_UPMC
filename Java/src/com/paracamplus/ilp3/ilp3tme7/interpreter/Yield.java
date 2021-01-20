package com.paracamplus.ilp3.ilp3tme7.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class Yield extends Primitive {

    public Yield() {
        super("yield");
    }

    @Override
    public int getArity() {
        return 0;
    }

    @Override
    public Object apply() throws EvaluationException {
    	//instanciation sur la coroutine courante (currentThread)
        CoroutineInstance corInst = (CoroutineInstance) Thread.currentThread();
        //prendre le ticket du thread courant
        corInst.yieldCoroutine();
        return null;
    }
}