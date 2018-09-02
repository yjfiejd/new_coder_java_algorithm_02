// �Ƚ����Ĺ��죺
// һ��ϵͳ�ṩ������Ľṹ����������űȽ����Ĺ��죬����Ƚ��������������ṹ�����֯!! -> �������������ȼ����У������
// ���ڱȽϵ����� 

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import Code_09_Comparator.Student;

public class comparator {

	// ������
	public static void main(String[] args) {
		Student student1 = new Student("A", 1, 23);
		Student student2 = new Student("B", 2, 21);
		Student student3 = new Student("C", 3, 22);
		
		Student[] students = new Student[] {student3, student2, student1};
		printStudent(students);
		
		Arrays.sort(students, new IdAscendingComparator());
		printStudent(students);
		
		Arrays.sort(students, new IdDescendingComparator());
		printStudent(students);
		
		// �ѵķ�ʽ:
		// ϵͳ�ṩ��һ���ѣ����ȼ����У�	// ��������Ƚ�������Ĭ�ϰ��ڴ��ַ����û����˼, ��Ҫ�Խ�ȥ�Ƚ���
		// ��������ӽ�ȥ��idС������ǰ�棬������һ��С���ѣ� -> ����ͨ���Ƚ���������С����
		System.out.println("*********************************************");
		PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
		heap.add(student3);
		heap.add(student2);
		heap.add(student1);
		
		while (!heap.isEmpty()) {
			Student student = heap.poll(); // ������
			System.out.println("name: " + student.name +" "+ "id: " + student.id + " "+"Age: " + student.age );
		}
	}
	
	
	// 1) ����Student�࣬ �ڲ�����3�����������֣�id������
	public static class Student{
		public String name;
		public int id;
		public int age;
		
		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}

	// 2) ����һ���Ƚ����� -> id���򣬼̳�
	public static class IdAscendingComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
//			return o1.id - o2.id;
			if(o1.id < o2.id) {
				return -1; // ��ʾo1��С�� ��Ϊo1.id - o2.id < 0 , Ϊ��������һ��������ǰ�档
			}else if (o1.id > o2.id) {
				return 1; // ��ʾo1���� ��Ϊo1.id - o2.id > 0 , Ϊ������
			}else {
				return 0;
			}
		}
	}
	
	// �Ƚ��� -> ���併��
	public static class IdDescendingComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o2.age - o1.age;  // Ũ����д�������o2.age - o1.age > 0, ����o2����
		}
	}
	
	
	// 3) ��ӡ������ͼ
	public static void printStudent(Student[] students) {
		for (Student student:students) {
			System.out.println("name: " + student.name +" "+ "id: " + student.id + " "+"Age: " + student.age );
		}
		System.out.println("============================================");
	}
	
}
