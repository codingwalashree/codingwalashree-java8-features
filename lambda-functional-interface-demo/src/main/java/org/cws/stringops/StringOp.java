package org.cws.stringops;

@FunctionalInterface
public interface StringOp {
    String perform(String s);
    //void otherAbstractMethod();
    default void someMethod() {
        System.out.println("I am a default method in StringOp");
    }
    static void someStaticMethod() {
        System.out.println("I am a static method in StringOp");
    }
}
