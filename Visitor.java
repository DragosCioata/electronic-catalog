package com.company;

public interface Visitor {
    void visit(Assistant assistant);
    void visit(Teacher teacher);
}
