package com.paracamplus.ilp3.ilp3tme7.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Resume extends UnaryPrimitive {

    public Resume() {
        super("resume");
    }

    @Override
    public Object apply(Object arg) throws EvaluationException {
        if(arg instanceof CoroutineInstance){
        	//instanciation de la coroutine
            CoroutineInstance corInst = (CoroutineInstance) arg;
            // libération du thread
            corInst.resumeCoroutine();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}