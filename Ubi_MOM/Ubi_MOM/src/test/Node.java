package test;


//�ڵ���
	public class Node {
		/**
		 * number �������
		 */
		int number;

		/**
		 * type �������
		 */
		int type;

		/**
		 * coor_x ���x����
		 */
		double coor_x;

		/**
		 * coor_y ���y����
		 */
		double coor_y;

		/**
		 * coor_z ���z����
		 */
		double coor_z;

		/**
		 * weight �洢����Ȩ��
		 */
		double weight;

		/**
		 * next �����ڽӽ��
		 */
		Node next = null;

		public Node(double a, double b, double c) {

			coor_x = a;
			coor_y = b;
			coor_z = c;
		}

		Node(Node p) {
			coor_x = p.coor_x;
			coor_y = p.coor_y;
			coor_z = p.coor_z;
		}
	}
