package com.company;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class ScoreVisitor implements Visitor{
    private HashMap<Assistant, ArrayList<Tuple<Student, String, Double>>> partialScores;
    private HashMap<Teacher, ArrayList<Tuple<Student, String, Double>>> examScores;
    Catalog obj;

    public ScoreVisitor(HashMap<Teacher, ArrayList<Tuple<Student, String, Double>>> examScores, HashMap<Assistant, ArrayList<Tuple<Student, String, Double>>> partialScores){
        this.examScores=examScores;
        this.partialScores=partialScores;
    }

    @Override
    public void visit(Assistant assistant) {
        ArrayList<Tuple<Student, String, Double>> pair = partialScores.get(assistant);
        for (Iterator<Tuple<Student, String, Double>> iterator = pair.iterator(); iterator.hasNext(); ) {
            Tuple<Student, String, Double> pereche = iterator.next();
            Course curs = Catalog.getInstance().getCourse(pereche.getValue1());
            Integer found = 0;
            for (Iterator<Grade> iter = curs.grades.iterator(); iter.hasNext(); ) {
                Grade grade = iter.next();
                if (pereche.getKey().equals(grade.getStudent())) {
                    grade.setPartialScore(pereche.getValue2());
                    obj.notifyObservers(grade);
                    found = 1;
                }
            }
            if (found.equals(0)) {
                Grade nota = new Grade(curs.name, pereche.getKey());
                nota.setPartialScore(pereche.getValue2());
                curs.grades.add(nota);
            }
        }
    }

    @Override
    public void visit(Teacher teacher) {
        ArrayList<Tuple<Student, String, Double>> pair = examScores.get(teacher);
        for (Iterator<Tuple<Student, String, Double>> iterator = pair.iterator(); iterator.hasNext(); ) {
            Tuple<Student, String, Double> pereche = iterator.next();
            Course curs = Catalog.getInstance().getCourse(pereche.getValue1());
            Integer found = 0;
            for (Iterator<Grade> iter = curs.grades.iterator(); iter.hasNext(); ) {
                Grade grade = iter.next();
                if (pereche.getKey().equals(grade.getStudent())) {
                    grade.setExamScore(pereche.getValue2());
                    obj.notifyObservers(grade);
                    found = 1;
                }
            }
            if (found.equals(0)) {
                Grade nota = new Grade(curs.name, pereche.getKey());
                nota.setExamScore(pereche.getValue2());
                curs.grades.add(nota);

            }
        }
    }

    class Tuple<K, V1, V2>{
        private V1 value1;
        private V2 value2;
        private K key;

        public Tuple(K key, V1 value1, V2 value2){
            this.key = key;
            this.value1 = value1;
            this.value2 = value2;
        }

        public V1 getValue1() {
            return value1;
        }

        public V2 getValue2() {
            return value2;
        }

        public K getKey() {
            return key;
        }
    }
}
