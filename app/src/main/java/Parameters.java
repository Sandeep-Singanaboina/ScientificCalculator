import com.fathzer.soft.javaluator.BracketPair;
import com.fathzer.soft.javaluator.Constant;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Operator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.lang.String;

public class Parameters {
    private String functionSeparator;
    private final List operators;
    private final List functions;
    private final List constants;
    private final Map translations;
    private final List expressionBrackets;
    private final List functionBrackets;

    /** Constructor.
     *
     This method builds an instance with no operator, no function, no constant, no translation and no bracket
     *
     Function argument separator is set to ','.
     */
    public Parameters() {
        this.operators = new ArrayList();
        this.functions = new ArrayList();
        this.constants = new ArrayList();
        this.translations = new HashMap();
        this.expressionBrackets = new ArrayList();
        this.functionBrackets = new ArrayList();
        setFunctionArgumentSeparator(',');
    }

    /** Gets the supported operators.
     * @return a Collection of operators.
     */
    public Collection getOperators() {
        return this.operators;
    }

    /** Gets the supported functions.
     * @return a Collection of functions.
     */
    public Collection getFunctions() {
        return this.functions;
    }

    /** Gets the supported constants.
     * @return a Collection of constants.
     */
    public Collection getConstants() {
        return this.constants;
    }

    /** Gets the supported bracket pairs for expressions.
     * @return a Collection of bracket pairs.
     */
    public Collection getExpressionBrackets() {
        return this.expressionBrackets;
    }

    /** Gets the supported bracket pairs for functions.
     * @return a Collection of bracket pairs.
     */
    public Collection getFunctionBrackets() {
        return this.functionBrackets;
    }

    /** Adds operators to the supported ones.
     * @param operators The operators to be added.
     */
    public void addOperators(Collection operators) {
        this.operators.addAll(operators);
    }

    /** Adds an operator to the supported ones.
     * @param operator The added operator
     */
    public void add(Operator operator) {
        this.operators.add(operator);
    }

    /** Adds functions to the supported ones.
     * @param functions The functions to be added.
     */
    public void addFunctions(Collection functions) {
        this.functions.addAll(functions);
    }

    /** Adds a function to the supported ones.
     * @param function The added function
     */
    public void add(Function function) {
        this.functions.add(function);
    }

    /** Adds constants to the supported ones.
     * @param constants The constants to be added.
     */
    public void addConstants(Collection constants) {
        this.constants.addAll(constants);
    }

    /** Adds a constant to the supported ones.
     * @param constant The added constant
     */
    public void add(Constant constant) {
        this.constants.add(constant);
    }

    /** Adds a new bracket pair to the expression bracket list.
     * @param pair A bracket pair
     */
    public void addExpressionBracket(BracketPair pair) {
        this.expressionBrackets.add(pair);
    }

    /** Adds bracket pairs to the expression bracket list.
     * @param brackets The brackets to be added.
     */
    public void addExpressionBrackets(Collection brackets) {
        this.expressionBrackets.addAll(brackets);
    }

    /** Adds a new bracket pair to the function bracket list.
     * @param pair A bracket pair
     */
    public void addFunctionBracket(BracketPair pair) {
        this.functionBrackets.add(pair);
    }

    /** Adds bracket pairs to the function bracket list.
     * @param brackets The brackets to be added.
     */
    public void addFunctionBrackets(Collection brackets) {
        this.functionBrackets.addAll(brackets);
    }

    /** Sets the translated term for a function.
     *
     Using this method, you can localize the names of some built-in functions. For instance,
     * for french people,you can use this method to use "somme" instead of "sum" with the SUM built-in
     * function of DoubleEvaluator.
     * @param function The function you want to translate the name
     * @param translatedName The translated name
     * @see DoubleEvaluator#SUM
     */
    public void setTranslation(Function function, String translatedName) {
        setTranslation(function.getName(), translatedName);
    }

    /** Sets the translated term for a constant.
     * @param constant The constant you want to translate the name
     * @param translatedName The translated name
     * @see #setTranslation(Function, String)
     */
    public void setTranslation(Constant constant, String translatedName) {
        setTranslation(constant.getName(), translatedName);
    }

    private void setTranslation(String name, String translatedName) {
        this.translations.put(name, translatedName);
    }

    String getTranslation(String originalName) {
        String translation = (String) this.translations.get(originalName);
        return translation==null?originalName:translation;
    }

    /** Sets the function argument separator.
     *
     Its default value is ','.
     * @param separator The new separator
     */
    public void setFunctionArgumentSeparator(char separator) {
        this.functionSeparator = new String(new char[]{separator});
    }

    /** Gets the function argument separator.
     * @return a string
     */
    public String getFunctionArgumentSeparator() {
        return this.functionSeparator;
    }
}
