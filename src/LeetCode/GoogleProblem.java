package LeetCode;

import java.util.*;

//
//    Create a data structure to represent biological relationships, then write an algorithm to determine if two people are blood related.
//
//        Example: I am blood-related to my Father’s brother (Uncle), but not my Uncle’s wife.


//   Mary ------ Frank     Joe -------- Ann
//           /     \              /       \
//           Sara    Lisa ------- Mike     Donna ------- John
//           |                       |
//           Susan                   James
//
//           Hint:
//           You can assume a list of people and their parents:
//           Mike, 		Ann,		Joe
//           Donna,		Ann,		Joe
//           James,		Donna,		John


class person {

    String name;
    person father;
    person mother;
    List<person> children;

    public person(String name, person father, person mother) {
        this.name = name;
        this.children = new ArrayList<person>();
        this.father = father;
        this.mother = mother;
    }
}

public class GoogleProblem {
    public boolean areRelated(person p1, person p2) {

        Set<person> p1Ancestors = new HashSet<person>();
        Set<person> p2Ancestors = new HashSet<person>();

        List<person> p1List = new LinkedList<person>();
        List<person> p2List = new LinkedList<person>();
        p1List.add(p1);
        p2List.add(p2);
        p1Ancestors.add(p1);
        p2Ancestors.add(p2);
        while (!p1List.isEmpty() || !p2List.isEmpty()) {
            person nextp1 = p1List.remove(0);
            if (nextp1 != null) {
                if (p2Ancestors.contains(nextp1))
                    return true;
                p1List.add(nextp1.father);
                p1List.add(nextp1.mother);
                p1Ancestors.add(nextp1.father);
                p1Ancestors.add(nextp1.mother);

                person nextp2 = p2List.remove(0);
                if (nextp2 != null) {

                    if (p1Ancestors.contains(nextp2))
                        return true;

                    p2List.add(nextp2.father);
                    p2List.add(nextp2.mother);
                    p2Ancestors.add(nextp2.father);
                    p2Ancestors.add(nextp2.mother);
                }
            }
        }
        return false;
    }

}



