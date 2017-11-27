package my;

import my.list.MyList;

public class Main {

	public static void main(String[] args) {
		MyList<Integer> list = new MyList<>();
		list.add(1).add(2).add(4);
		System.out.println(list);

		list.add(5);
		list.add(2, 3);
		list.add(6);
		list.add(7);

		System.out.println(list.toString());

		list.revers();
		System.out.println(list.toString());

		System.out.println(list.get(6));
	}
}
