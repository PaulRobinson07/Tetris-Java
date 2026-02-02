import java.util.ArrayList;

public class Bag {
	ArrayList<Integer> pieces = new ArrayList<Integer>();
	ArrayList<Integer> p= new ArrayList<Integer>();
	Bag() {
		generate_bag(2);
	}
	public void generate_bag(int count) {
		for (int b = 0; b<count;b++) {
			for (int i=0;i<7;i++) {
				pieces.add(i+1);
			}
			for (int i=0;i<7;i++) {
				int a = (int)(Math.random()*pieces.size());
				p.add(pieces.get(a));
				pieces.remove(a);
			}
		}
	}
	public void new_piece() {
		p.remove(0);
		if (p.size()<=7) {
			generate_bag(1);
		}
	}
	public void printshit() {
		for (int i=0; i<p.size(); i++) {
			System.out.println(p.get(i));
		}
	}
}
