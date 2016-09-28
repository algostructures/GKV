enum preceedence {
    lparen('('),rparen(')'),plus('+'),minus('-'),times('*'),divide('/'),mod('%'),eos,operand;
    char value;
    preceedence(char c){
        value=c;
    }
    preceedence(){
        value='\0';
    }
}
