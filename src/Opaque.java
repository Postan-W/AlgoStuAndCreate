import jdk.internal.cmm.SystemResourcePressureImpl;
import jdk.nashorn.tools.Shell;
import util.*;

import java.time.LocalDate;
import java.util.Arrays;

import static java.lang.System.*;
public class Opaque implements Demo{
    public static void main(String []args){
        int [] a = {1,3,2,14,5,10,8};
        System.out.println( "一共移动了："+ ShellSort.sort(a)+"次");
        System.out.println(Arrays.toString(a));
    }
    static class Employee {
        private String name;
        private int age;
        private String position;
        private float salary;

        public Employee(String n, int a, String p,float s){
            name = n;
            age = a;
            position = p;
            salary = s;
        }
        public boolean equals(Employee e){
            if(e.getAge() == this.getAge()){
                return true;
            }
            return false;
        }
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public float getSalary() {
                return salary;
            }

            public void setSalary(float salary) {
                this.salary = salary;
            }
        }
}

