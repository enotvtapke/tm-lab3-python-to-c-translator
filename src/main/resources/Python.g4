grammar Python;

@parser::header {
    import java.util.*;
    import java.lang.*;
    import java.util.stream.Collectors;
}

@parser::members {
    public StringBuilder translated = new StringBuilder();
    Set<String> memory = new HashSet<String>();
}

file returns [String res]
: (stats+=stat)* EOF
{
String stats = $stats.stream().filter(it -> it.res != null).map(it -> "\t" + it.res + ";\n").collect(Collectors.joining());
String varDecls = "int " + memory.stream().collect(Collectors.joining(", "));
translated.append(String.format("""
#include <stdio.h>
%s;
int main() {
%s
    return 0;
}
""", varDecls, stats));
}
;

stat returns [String res]
: ID '=' 'int' '(' 'input' '(' ')' ')'
{
$res = "scanf(\"%d\", &" + $ID.text + ")";
memory.add($ID.text);
}
| 'print' '(' expr ')' { $res = "printf(\"%d\\n\", " + $expr.res + ")"; }
| assign NEWLINE { $res = $assign.res; }
| expr NEWLINE { $res = $expr.res; }
| NEWLINE
;

assign returns [String res]
: ID '=' e=expr
{
$res = $ID.text + "=" + $e.res;
memory.add($ID.text);
}
;

expr returns [String res]
: a=expr '//' b=expr { $res = $a.res + "/" + $b.res; }
| a=expr '*' b=expr { $res = $a.res + "*" + $b.res; }
| a=expr op=('+'|'-') b=expr { $res = $a.res + $op.text + $b.res; }
| '(' expr ')' { $res = $expr.res; }
| ID { $res = $ID.text; }
| INT { $res = $INT.text; }
;

INT : [0-9]+ ;
ID : [a-zA-Z_] [a-zA-Z_0-9]* ;
NEWLINE
    : '\r'? '\n'
    ;
IDENT : '\r'? '\n' ('\t'|'  ') ;
WS : [ \t\r\n]+ -> skip ;
