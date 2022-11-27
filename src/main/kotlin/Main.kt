import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import translator.PythonLexer
import translator.PythonParser
import java.nio.file.Path

fun main() {
    val input = CharStreams.fromPath(Path.of("src/main/resources/test.py"))
    val lexer = PythonLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = PythonParser(tokens)
    val tree: ParseTree = parser.file()
    println(parser.translated.toString())

    println(tree.toStringTree(parser))
}
