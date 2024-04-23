import javax.swing.*;
public class 문자열_04 extends JFrame{
	JTextField tf=new JTextField();
	public 문자열_04()
	{
		add("North",tf);
		tf.setText(String.valueOf(true));
		setSize(400,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 문자열_04();
	}

}
