class EvaluateExpression {
    private String s;
    char symbol;
    private int n;
    GenericStack<Integer> q;
    GenericStack<preceedence> p;
    static int isp[]={0,19,12,12,13,13,13,0};
    static int icp[]={20,19,12,12,13,13,13,0};
    EvaluateExpression(String x)
    {
        s=x;
        n=0;
        q=new GenericStack<>();
        p=new GenericStack<>();
        p.push(preceedence.eos);

    }
    private  preceedence getNextToken()
    {
        if(n==s.length())
            return preceedence.eos;
         symbol=s.charAt(n++);
        switch(symbol)
        {
        case '(':return preceedence.lparen;
        case ')':return preceedence.rparen;
        case '+':return preceedence.plus;
        case '-':return preceedence.minus;
        case '/':return preceedence.divide;
        case '*':return preceedence.times;
        case '%':return preceedence.mod;
        case ' ' :
        case '\n':
        case '\t':return preceedence.eos;
        default :return preceedence.operand;
        }

    }
    String evaluate()
    {
        n=0;
        preceedence token =getNextToken();
        while(token!=preceedence.eos)
        {
            if(token == preceedence.operand)
                q.push(symbol-'0');
            else
            {
                int op2=q.pop();
                int op1=q.pop();
                switch(token)
                {
                case plus: q.push(op1+op2);break;
                case minus: q.push(op1-op2);break;
                case times: q.push(op1*op2);break;
                case divide:q.push(op1/op2);break;
                case mod:q.push(op1%op2);break;
                default:break;
                }

            }
            token=getNextToken();
        }
        return new String(""+q.pop());
    }
    String toPostfix()
    {
        preceedence token;
        StringBuilder sb = new StringBuilder();
        for(token=getNextToken();token!=preceedence.eos;token=getNextToken())
        {
            if(token==preceedence.operand)
                sb.append(symbol-'0');
            else if(token==preceedence.rparen){
                while(p.peek()!=preceedence.lparen)
                    sb.append(p.pop().value);
                p.pop();
            }
            else {
                while(icp[token.ordinal()]<=isp[p.peek().ordinal()])
                    System.out.print(p.pop().value);
                p.push(token);
            }
        }
        while((token=p.pop())!=preceedence.eos)
            sb.append(token.value);
        s = sb.toString();
        return s;
    }

}
