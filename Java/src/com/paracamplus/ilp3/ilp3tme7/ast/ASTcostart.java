package com.paracamplus.ilp3.ilp3tme7.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp3.ilp3tme7.interfaces.IASTcostart;
import com.paracamplus.ilp3.ilp3tme7.interfaces.IASTvisitor;

public class ASTcostart extends ASTexpression implements IASTcostart {
	
	    private final IASTexpression coroutine;
	    private final IASTexpression[] arguments;
    
    public ASTcostart (IASTexpression coroutine, IASTexpression[] arguments) {
        this.coroutine = coroutine;
        this.arguments = arguments;
    }
 
    
    @Override
	public IASTexpression getCoroutine () {
        return coroutine;
    }
    @Override
	public IASTexpression[] getArguments () {
        return arguments;
    }
    
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
		 return ((IASTvisitor<Result, Data, Anomaly>)visitor).visit(this, data);
	}

}