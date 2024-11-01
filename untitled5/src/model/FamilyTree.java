//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members = new ArrayList();

    public FamilyTree() {
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public List<T> getMembers() {
        return this.members;
    }

    public Iterator<T> iterator() {
        return this.members.iterator();
    }

    public void sortByName() {
        Collections.sort(this.members, (p1, p2) -> {
            return p1.toString().compareTo(p2.toString());
        });
    }

    public void sortByBirthYear() {
        if (this.members.get(0) instanceof Person) {
            Collections.sort(this.members, (p1, p2) -> {
                return Integer.compare(((Person)p1).getBirthYear(), ((Person)p2).getBirthYear());
            });
        }

    }
}
